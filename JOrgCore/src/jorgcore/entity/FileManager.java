package jorgcore.entity;

import java.util.HashSet;
import java.util.Set;

public class FileManager {

    public final static Set<String> listFilesAt(final String path) {
        java.io.File dir = new java.io.File(path);
        String[] children = dir.list();
        Set<String> files = new HashSet<String>();
        String fileSeparator = System.getProperty("file.separator");
        if (children != null) {
            for (int i = 0; i < children.length; i++) {
                String filename = children[i];
                if (new java.io.File(path + fileSeparator + filename).isDirectory()) {
                    files.addAll(listFilesAt(path + fileSeparator + filename));
                } else {
                    files.add((path + fileSeparator + filename));
                }
            }
        }
        return files;
    }
}
