package jorg.gui.file;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import jorg.gui.config.Configurator;
import jorg.indexing.LuceneIndexer;
import jorgcore.database.DataBase;
import jorgcore.entity.File;
import jorgcore.entity.Unit;

public class IndexingThread extends Thread {

    private JLabel lbl;
    private JProgressBar prg;
    private String path;
    private String id_unit;
    private List<String> filesRejected = new ArrayList<String>();
    private static boolean stop = false;
    private static final int COMMIT_AT = 2000;

    public static void log(Object o) {
        System.out.println(new Date().toLocaleString() + "--LOG :" + o);
    }

    public void safetyStop() {
        stop = true;
    }

    public boolean isStoped() {
        return stop;
    }

    public IndexingThread(JLabel lbl, JProgressBar prg, String path, String id_unit) {
        this.lbl = lbl;
        this.prg = prg;
        this.path = path;
        this.id_unit = id_unit;
    }

    @Override
    public void run() {
        prg.setIndeterminate(true);
        prg.setString(Configurator.getInternationlizedText("list.of.files"));
        try {
            log("Starting to list all files on " + path);
            Collection<File> files = FileManager.listFilesAt(path, new ListFileListener(lbl), this);
            log("Done! They are " + files.size() + " files.");
            boolean showPopup = false;
            long unitId = 0l;
            if (files.size() != 0) {
                prg.setIndeterminate(false);
                prg.setMaximum(files.size() + 1);
                log("Starting to insert all files on the list");
                File.setupBatch();
                if (id_unit.equals("")) {
                    long id = mockingAUnit();
                    indexWithALinkedUnit(files, id);
                    showPopup = true;
                    unitId = id;
                } else {
                    long id = 0L;
                    String[] terms = id_unit.split("-");
                    id = Long.parseLong(terms[0].trim());
                    indexWithALinkedUnit(files, id);
                }
                File.finishBatch();
                Thread.sleep(500);
                int lastIdBefore = File.lastId() - files.size();
                log("lastIdBefore =" + lastIdBefore);
                luceneIndexationOf(files, lastIdBefore);
            }else{
                prg.setIndeterminate(false);
            }
            lbl.setText(Configurator.getInternationlizedText("finish"));
            prg.setValue(prg.getMinimum());
            log("Done!");
            if (filesRejected.size() > 0) {
                JOptionPane.showMessageDialog(null, createMessage(filesRejected), "Files that were not indexed.", JOptionPane.INFORMATION_MESSAGE);
            }
            form.enableEverything();
            if (showPopup) {
                JOptionPane.showMessageDialog(null, Configurator.getInternationlizedText("labeled.msg") + " [" + unitId + "]");
            }
        } catch (Exception ex) {
            form.enableEverything();
            lbl.setText(ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                DataBase.getConnection().setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(IndexingThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private final String createMessage(List<String> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------------------------------------------------\n");
        for (String item : list) {
            sb.append(item + "\n");
        }
        sb.append("--------------------------------------------------------------------");
        return sb.toString();
    }

    private void indexWithALinkedUnit(Collection<File> files, Long id) throws SQLException, NumberFormatException {
        long count = 0;
        filesRejected.clear();
        for (File file : files) {
            if (stop) {
                throw new SQLException("someone has stopped");
            }
            try {
                File.insert(file, id);
            } catch (SQLException e) {
                filesRejected.add(file.path + file.name + " - " + e);
                e.printStackTrace();
            } catch (Exception e) {
                filesRejected.add(file.path + file.name + " - " + e);
                e.printStackTrace();
            }
            prg.setValue(prg.getValue() + 1);
            lbl.setText(file.name);
            count++;
            if (count >= COMMIT_AT) {
                File.finishBatch();
                count = 0L;
            }
        }
    }
    private FileIndexing form;

    public void setDelegate(FileIndexing aThis) {
        form = aThis;
    }

    private void luceneIndexationOf(Collection<File> files, int lastIdBefore) throws IOException {
        LuceneIndexer.Index(files, lastIdBefore);
    }

    private long mockingAUnit() throws SQLException {
        Unit.begin();
        Unit unit = new Unit();
        unit.name = "s";
        Unit.insert(unit);
        unit.id = Unit.lastId();
        unit.name = String.valueOf(unit.id);
        Unit.update(unit);
        Unit.commit();
        long id = unit.id;
        return id;
    }
}
