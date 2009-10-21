package jorgcore.entity;

import java.util.Date;

public class File {

    public long id;
    public String name;
    public String path;
    public double size;
    public long size_in_bytes;
    public Date time_last_modified;
    public String extension;
    public int id_unit;

    public File() {
    }

    public File(java.io.File file) {
        name = file.getName();
        path = file.getParent();
        size = (file.length() / 1024.d / 1024.d);
        size_in_bytes = file.length();
        time_last_modified = new Date(file.lastModified());
        if (file.getName().lastIndexOf(".") != -1) {
            String ext = file.getName().substring(file.getName().lastIndexOf(".") + 1, file.getName().length());
            extension = ext.toLowerCase();
        }else{
            extension = "";
        }
    }
}
