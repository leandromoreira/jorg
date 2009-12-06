package jorg.indexing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.FilterIndexReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Scorer;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class LuceneSearcher {

    private static class OneNormsReader extends FilterIndexReader {

        private String field;

        public OneNormsReader(IndexReader in, String field) {
            super(in);
            this.field = field;
        }

        @Override
        public byte[] norms(String field) throws IOException {
            return in.norms(this.field);
        }
    }

    public static int[] search(String value) throws CorruptIndexException, IOException, ParseException {
        int[] documentId = null;
        int hitsPerPage = 120;
        IndexReader reader = IndexReader.open(FSDirectory.open(JorgSearchSystem.INDEX_DIR), true);
        Searcher searcher = new IndexSearcher(reader);
        Set<String> stopWords = new HashSet<String>();
        JorgSearchSystem.fillUp(stopWords);
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT, stopWords);
        QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, JorgSearchSystem.CONTENTS_FIELD, analyzer);
        Query query = parser.parse(value);
        documentId = doPagingSearch(searcher, query, hitsPerPage, false, true);
        reader.close();
        return documentId;
    }

    public static void main(String[] args) throws Exception {
        String index = "index";
        String field = "contents";
        String queries = null;
        int repeat = 0;
        boolean raw = false;
        String normsField = null;
        boolean paging = true;
        int hitsPerPage = 10;

        IndexReader reader = IndexReader.open(FSDirectory.open(new File(index)), true); // only searching, so read-only=true

        if (normsField != null) {
            reader = new OneNormsReader(reader, normsField);
        }

        Searcher searcher = new IndexSearcher(reader);
        Set<String> stopWords = new HashSet<String>();
        stopWords.add("the");
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT, stopWords);

        BufferedReader in = null;
        if (queries != null) {
            in = new BufferedReader(new FileReader(queries));
        } else {
            in = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        }
        QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, field, analyzer);
        while (true) {
            if (queries == null) // prompt the user
            {
                System.out.println("Enter query: ");
            }

            String line = in.readLine();

            if (line == null || line.length() == -1) {
                break;
            }

            line = line.trim();
            if (line.length() == 0) {
                break;
            }

            Query query = parser.parse(line);
            System.out.println("Searching for: " + query.toString(field));


            if (repeat > 0) {                           // repeat & time as benchmark
                Date start = new Date();
                for (int i = 0; i < repeat; i++) {
                    searcher.search(query, null, 100);
                }
                Date end = new Date();
                System.out.println("Time: " + (end.getTime() - start.getTime()) + "ms");
            }

            if (paging) {
                doPagingSearch(in, searcher, query, hitsPerPage, raw, queries == null);
            } else {
                doStreamingSearch(searcher, query);
            }
        }
        reader.close();
    }

    /**
     * This method uses a custom HitCollector implementation which simply prints out
     * the docId and score of every matching document.
     *
     *  This simulates the streaming search use case, where all hits are supposed to
     *  be processed, regardless of their relevance.
     */
    public static void doStreamingSearch(final Searcher searcher, Query query) throws IOException {
        Collector streamingHitCollector = new Collector() {

            private Scorer scorer;
            private int docBase;

            // simply print docId and score of every matching document
            @Override
            public void collect(int doc) throws IOException {
                System.out.println("doc=" + doc + docBase + " score=" + scorer.score());
            }

            @Override
            public boolean acceptsDocsOutOfOrder() {
                return true;
            }

            @Override
            public void setNextReader(IndexReader reader, int docBase)
                    throws IOException {
                this.docBase = docBase;
            }

            @Override
            public void setScorer(Scorer scorer) throws IOException {
                this.scorer = scorer;
            }
        };

        searcher.search(query, streamingHitCollector);
    }

    /**
     * This demonstrates a typical paging search scenario, where the search engine presents
     * pages of size n to the user. The user can then go to the next page if interested in
     * the next hits.
     *
     * When the query is executed for the first time, then only enough results are collected
     * to fill 5 result pages. If the user wants to page beyond this limit, then the query
     * is executed another time and all hits are collected.
     *
     */
    public static void doPagingSearch(BufferedReader in, Searcher searcher, Query query,
            int hitsPerPage, boolean raw, boolean interactive) throws IOException {

        // Collect enough docs to show 5 pages
        TopScoreDocCollector collector = TopScoreDocCollector.create(
                5 * hitsPerPage, false);
        searcher.search(query, collector);
        ScoreDoc[] hits = collector.topDocs().scoreDocs;

        int numTotalHits = collector.getTotalHits();
        System.out.println(numTotalHits + " total matching documents");

        int start = 0;
        int end = Math.min(numTotalHits, hitsPerPage);

        while (true) {
            if (end > hits.length) {
                System.out.println("Only results 1 - " + hits.length + " of " + numTotalHits + " total matching documents collected.");
                System.out.println("Collect more (y/n) ?");
                String line = in.readLine();
                if (line.length() == 0 || line.charAt(0) == 'n') {
                    break;
                }

                collector = TopScoreDocCollector.create(numTotalHits, false);
                searcher.search(query, collector);
                hits = collector.topDocs().scoreDocs;
            }

            end = Math.min(hits.length, start + hitsPerPage);

            for (int i = start; i < end; i++) {
                if (raw) {                              // output raw format
                    System.out.println("doc=" + hits[i].doc + " score=" + hits[i].score);
                    continue;
                }

                Document doc = searcher.doc(hits[i].doc);
                String path = doc.get("path");
                if (path != null) {
                    System.out.println((i + 1) + ". " + path);
                    String title = doc.get("title");
                    if (title != null) {
                        System.out.println("   Title: " + doc.get("title"));
                    }
                } else {
                    System.out.println((i + 1) + ". " + "No path for this document");
                }

            }

            if (!interactive) {
                break;
            }

            if (numTotalHits >= end) {
                boolean quit = false;
                while (true) {
                    System.out.print("Press ");
                    if (start - hitsPerPage >= 0) {
                        System.out.print("(p)revious page, ");
                    }
                    if (start + hitsPerPage < numTotalHits) {
                        System.out.print("(n)ext page, ");
                    }
                    System.out.println("(q)uit or enter number to jump to a page.");

                    String line = in.readLine();
                    if (line.length() == 0 || line.charAt(0) == 'q') {
                        quit = true;
                        break;
                    }
                    if (line.charAt(0) == 'p') {
                        start = Math.max(0, start - hitsPerPage);
                        break;
                    } else if (line.charAt(0) == 'n') {
                        if (start + hitsPerPage < numTotalHits) {
                            start += hitsPerPage;
                        }
                        break;
                    } else {
                        int page = Integer.parseInt(line);
                        if ((page - 1) * hitsPerPage < numTotalHits) {
                            start = (page - 1) * hitsPerPage;
                            break;
                        } else {
                            System.out.println("No such page");
                        }
                    }
                }
                if (quit) {
                    break;
                }
                end = Math.min(numTotalHits, start + hitsPerPage);
            }

        }

    }


    public static int[] doPagingSearch(Searcher searcher, Query query,int hitsPerPage, boolean raw, boolean interactive) throws IOException {
        // Collect enough docs to show 5 pages
        TopScoreDocCollector collector = TopScoreDocCollector.create(5 * hitsPerPage, false);
        searcher.search(query, collector);
        ScoreDoc[] hits = collector.topDocs().scoreDocs;

        int numTotalHits = collector.getTotalHits();
        int[] documents = new int[numTotalHits];
        log(numTotalHits + " total matching documents");

        int start = 0;
        int end = Math.min(numTotalHits, hitsPerPage);

        while (true) {
            if (end > hits.length) {
                System.out.println("Only results 1 - " + hits.length + " of " + numTotalHits + " total matching documents collected.");
                System.out.println("Collect more (y/n) ?");
                String line = in.readLine();
                if (line.length() == 0 || line.charAt(0) == 'n') {
                    break;
                }

                collector = TopScoreDocCollector.create(numTotalHits, false);
                searcher.search(query, collector);
                hits = collector.topDocs().scoreDocs;
            }

            end = Math.min(hits.length, start + hitsPerPage);

            for (int i = start; i < end; i++) {
                if (raw) {                              // output raw format
                    System.out.println("doc=" + hits[i].doc + " score=" + hits[i].score);
                    continue;
                }

                Document doc = searcher.doc(hits[i].doc);
                String path = doc.get("path");
                if (path != null) {
                    System.out.println((i + 1) + ". " + path);
                    String title = doc.get("title");
                    if (title != null) {
                        System.out.println("   Title: " + doc.get("title"));
                    }
                } else {
                    System.out.println((i + 1) + ". " + "No path for this document");
                }

            }

            if (!interactive) {
                break;
            }

            if (numTotalHits >= end) {
                boolean quit = false;
                while (true) {
                    System.out.print("Press ");
                    if (start - hitsPerPage >= 0) {
                        System.out.print("(p)revious page, ");
                    }
                    if (start + hitsPerPage < numTotalHits) {
                        System.out.print("(n)ext page, ");
                    }
                    System.out.println("(q)uit or enter number to jump to a page.");

                    String line = in.readLine();
                    if (line.length() == 0 || line.charAt(0) == 'q') {
                        quit = true;
                        break;
                    }
                    if (line.charAt(0) == 'p') {
                        start = Math.max(0, start - hitsPerPage);
                        break;
                    } else if (line.charAt(0) == 'n') {
                        if (start + hitsPerPage < numTotalHits) {
                            start += hitsPerPage;
                        }
                        break;
                    } else {
                        int page = Integer.parseInt(line);
                        if ((page - 1) * hitsPerPage < numTotalHits) {
                            start = (page - 1) * hitsPerPage;
                            break;
                        } else {
                            System.out.println("No such page");
                        }
                    }
                }
                if (quit) {
                    break;
                }
                end = Math.min(numTotalHits, start + hitsPerPage);
            }

        }

    }

    public final static void log(final Object o) {
        System.out.println(new Date().toLocaleString() + "--LOG :" + o);
    }

}
