package jorgcore.entity;

import java.util.HashSet;
import java.util.Set;

public class FileManager {
private final static String fileSeparator = System.getProperty("file.separator");
    public final static Set<File> listFilesAt(final String path) {
        java.io.File dir = new java.io.File(path);
        String[] children = dir.list();
        Set<File> files = new HashSet<File>();
        
        if (children != null) {
            for (int i = 0; i < children.length; i++) {
                String filename = children[i];
                if (new java.io.File(path + fileSeparator + filename).isDirectory()) {
                    files.addAll(listFilesAt(path + fileSeparator + filename));
                } else {
                    files.add(new File(new java.io.File(path + fileSeparator + filename)));
                }
            }
        }
        return files;
    }
}
