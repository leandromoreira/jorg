package jorgcore.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import jorgcore.database.DataBase;

public class File {

    public Long id;
    public String name;
    public String path;
    public double size;
    public long size_in_bytes;
    public Date time_last_modified;
    public Date date_last_modified;
    public String extension;
    public int id_unit;
    private static PreparedStatement psBatch, psBatchLinked;

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
            if (extension.length() >= 20) {
                extension = extension.substring(0, 20);
            }
        } else {
            extension = "";
        }
    }

    @Deprecated
    public static void begin() throws SQLException {
    }

    @Deprecated
    public static void commit() throws SQLException {
    }

    public static void setupBatch() throws SQLException {
        if (psBatch == null | psBatchLinked == null) {
            String sql = "insert into file(" +
                    "name,path,size,extension,size_in_bytes, time_last_modified,date_last_modified) " +
                    "values (?,?,?,?,?,?,?)";
            psBatch = DataBase.getConnection().prepareStatement(sql);
            sql = "insert into file(" +
                    "name,path,size,extension,size_in_bytes, time_last_modified,date_last_modified,id_unit) " +
                    "values (?,?,?,?,?,?,?,?)";
            psBatchLinked = DataBase.getConnection().prepareStatement(sql);
        }
        DataBase.getConnection().setAutoCommit(false);
    }

    public static void finishBatch() throws SQLException {
        psBatch.executeBatch();
        psBatchLinked.executeBatch();
        DataBase.getConnection().commit();
        psBatch.clearBatch();
        psBatchLinked.clearBatch();
    }

    public static void insert(File unit) throws SQLException {
        psBatch.setString(1, unit.name);
        psBatch.setString(2, unit.path);
        psBatch.setDouble(3, unit.size);
        psBatch.setString(4, unit.extension);
        psBatch.setLong(5, unit.size_in_bytes);
        psBatch.setTime(6, new Time(unit.time_last_modified.getTime()));
        psBatch.setDate(7, new java.sql.Date(unit.time_last_modified.getTime()));
        psBatch.addBatch();
    }

    public static void insert(File unit, Long unitId) throws SQLException {
        psBatchLinked.setString(1, unit.name);
        psBatchLinked.setString(2, unit.path);
        psBatchLinked.setDouble(3, unit.size);
        psBatchLinked.setString(4, unit.extension);
        psBatchLinked.setLong(5, unit.size_in_bytes);
        psBatchLinked.setTime(6, new Time(unit.time_last_modified.getTime()));
        psBatchLinked.setDate(7, new java.sql.Date(unit.time_last_modified.getTime()));
        psBatchLinked.setLong(8, unitId);
        psBatchLinked.addBatch();
    }

    public final static Collection<File> listBy(final int[] ids, String where) throws SQLException {

        if (ids.length == 0) {
            return new ArrayList<File>();
        }
        Collection<File> list = new ArrayList<File>();
        if (where == null) {
            where = "";
        }
        String copyOfWhere = where.toLowerCase();
        where = createRestriction(ids, where);

        if (!copyOfWhere.equals("")) {
            where += " and " + copyOfWhere;
        }
        StringBuilder sql = new StringBuilder("select * from file " + where);
        PreparedStatement ps = DataBase.getConnection().prepareStatement(sql.toString());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            File file = new File();
            file.extension = rs.getString("extension");
            file.id = rs.getLong("id");
            file.id_unit = rs.getInt("id_unit");
            file.name = rs.getString("name");
            file.path = rs.getString("path");
            file.size = rs.getFloat("size");
            file.size_in_bytes = rs.getLong("size_in_bytes");
            file.time_last_modified = rs.getTime("time_last_modified");
            file.date_last_modified = rs.getDate("date_last_modified");
            list.add(file);
        }
        return list;
    }

    private final static String createRestriction(final int[] ids, String where) {
        where = "where id in (";
        for (int i = 0; i < ids.length; i++) {
            int id = ids[i];
            where += id + ",";
        }
        where = where.substring(0, where.length()-1) + ")";
        return where;
    }

    public static int lastId() throws SQLException {
        StringBuilder sql = new StringBuilder("select max(id) from file");
        PreparedStatement ps = DataBase.getConnection().prepareStatement(sql.toString());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }

    public static void delete(List<Long> ids) throws SQLException {
        StringBuilder sql = new StringBuilder("delete from file where id_unit in (");
        for (int i = 0; i < ids.size(); i++) {
            Long id = ids.get(i);
            if (i != (ids.size() - 1)) {
                sql.append(id + ",");
            } else {
                sql.append(id + ")");
            }
        }
        PreparedStatement ps = DataBase.getConnection().prepareStatement(sql.toString());
        ps.executeUpdate();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 31 * hash + (this.path != null ? this.path.hashCode() : 0);
        hash = 31 * hash + (int) (this.size_in_bytes ^ (this.size_in_bytes >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final File other = (File) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.path == null) ? (other.path != null) : !this.path.equals(other.path)) {
            return false;
        }
        if (this.size_in_bytes != other.size_in_bytes) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
