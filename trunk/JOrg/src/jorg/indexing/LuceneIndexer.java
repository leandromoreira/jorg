package jorg.indexing;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import jorg.gui.config.Configurator;
import jorgcore.entity.File;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class LuceneIndexer {

    public static final String[] stopWords = Configurator.getStopWords();
    public static final java.io.File INDEX_DIR = new java.io.File("index");
    public final static String ID_FIELD = "id";
    public final static String CONTENTS_FIELD = "contents";


    public final static void Index(final Collection<File> files,final int lastId) throws IOException {
        int actualId = lastId + 1;
        Set<String> setOfStopWords = new HashSet<String>();
        fillUp(setOfStopWords);

        boolean firstTime = !INDEX_DIR.exists();
        if(firstTime){
            INDEX_DIR.mkdir();
        }

        IndexWriter writer = new IndexWriter(FSDirectory.open(INDEX_DIR), new StandardAnalyzer(Version.LUCENE_CURRENT, setOfStopWords), firstTime, IndexWriter.MaxFieldLength.LIMITED);
        log("Indexing to directory '" + INDEX_DIR + "'");
        log("Starts at "+new Date());
        for (File word : files) {
            Document doc = new Document();
            doc.add(new Field(ID_FIELD, Integer.toString(actualId), Field.Store.YES, Field.Index.NOT_ANALYZED));
            doc.add(new Field(CONTENTS_FIELD,cleanString(word),Field.Store.YES,Field.Index.toIndex(true, true)));
            writer.addDocument(doc);
            ++actualId;
        }
        log("Finish at "+new Date());
        log("Optimizing...");
        writer.optimize();
        log("Closing...");
        writer.close();
    }

    public final static void fillUp(Set<String> set) {
        for (String value : stopWords) {
            set.add(value);
        }
    }

    private static String cleanString(File file){
        String full = file.path.replace(java.io.File.separator, " ").replace("_", " ") + " " + file.name.replace(".", " ");
        return full;
    }

    public final static void log(final Object o) {
        System.out.println(new Date().toLocaleString() + "--LOG :" + o);
    }
}
