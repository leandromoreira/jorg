package jorg.tests;

import java.util.Set;
import jorgcore.entity.File;
import jorgcore.entity.FileManager;

public class Tests {
    public static void main(String[] args) {
        Set<String> m = FileManager.listFilesAt("c:\\tmp\\");
            for (String item : m) {
                java.io.File file = new java.io.File(item);
                File f = new File(file);
                System.out.println("========================================");
                System.out.println(f.name);
                System.out.println(f.extension);
                System.out.println(f.path);
                System.out.println(f.size);
                System.out.println(f.size_in_bytes);
                System.out.println(f.time_last_modified.toLocaleString());
                System.out.println("========================================");
            }
    }
}
