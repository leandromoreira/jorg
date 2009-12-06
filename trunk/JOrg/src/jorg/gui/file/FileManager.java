package jorg.gui.file;

import java.util.ArrayList;
import java.util.Collection;
import jorg.gui.config.Configurator;
import jorgcore.entity.File;

public class FileManager {

    private final static String fileSeparator = System.getProperty("file.separator");

    public final static Collection<File> listFilesAt(final String path, final ListFileListener listener) {
        java.io.File dir = new java.io.File(path);
        String[] children = null;
        try {
            children = dir.list();
        } catch (Exception e) {
            System.out.println("FileManager : " + e);
            children = null;
        }
        Collection<File> files = new ArrayList<File>();

        if (children != null) {
            for (int i = 0; i < children.length; i++) {
                String filename = children[i];
                if (new java.io.File(path + fileSeparator + filename).isDirectory()) {
                    files.addAll(listFilesAt(path + fileSeparator + filename, listener));
                } else {
                    if (Configurator.isIndexable(filename)) {
                        files.add(new File(new java.io.File(path + fileSeparator + filename)));
                        listener.fireChanges(filename);
                    }
                }
            }
        }
        return files;
    }

    public final static String[] getDrives() {
        java.io.File[] roots = java.io.File.listRoots();
        String[] drives = new String[roots.length];
        int index = 0;
        for (java.io.File file : roots) {
            if (!file.getAbsolutePath().equals("A:\\")) {
                drives[index++] = file.getAbsolutePath();
            }
        }
        return drives;
    }
}
