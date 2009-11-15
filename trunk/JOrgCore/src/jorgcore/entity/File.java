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
    public String extension;
    public int id_unit;
    private static DataBase db;

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

    public static void begin() throws SQLException {
        db = new DataBase();
    }

    public static void commit() throws SQLException {
        db.close();
    }

    public static void insert(File unit) throws SQLException {
        String sql = "insert into file(" +
                "name,path,size,extension,size_in_bytes, time_last_modified,date_last_modified) " +
                "values (?,?,?,?,?,?,?)";
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ps.setString(1, unit.name);
        ps.setString(2, unit.path);
        ps.setDouble(3, unit.size);
        ps.setString(4, unit.extension);
        ps.setLong(5, unit.size_in_bytes);
        ps.setTime(6, new Time(unit.time_last_modified.getTime()));
        ps.setDate(7, new java.sql.Date(unit.time_last_modified.getTime()));
        //ps.setDate(6, new java.sql.Date());
        ps.executeUpdate();
    }

     public static void insert(File unit,Long unitId) throws SQLException {
        String sql = "insert into file(" +
                "name,path,size,extension,size_in_bytes, time_last_modified,date_last_modified,id_unit) " +
                "values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ps.setString(1, unit.name);
        ps.setString(2, unit.path);
        ps.setDouble(3, unit.size);
        ps.setString(4, unit.extension);
        ps.setLong(5, unit.size_in_bytes);
        ps.setTime(6, new Time(unit.time_last_modified.getTime()));
        ps.setDate(7, new java.sql.Date(unit.time_last_modified.getTime()));
        ps.setLong(8, unitId);
        //ps.setDate(6, new java.sql.Date());
        ps.executeUpdate();
    }


    public static void update(Unit unit) throws SQLException {
        String sql = "update unit set " +
                "name = ?,type = ?,keywords = ?, id_container = ? where id = ?";
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ps.setString(1, unit.name);
        ps.setString(2, unit.type);
        ps.setString(3, unit.keywords);
        ps.setNull(4, java.sql.Types.INTEGER);
        ps.setInt(5, unit.id);
        ps.executeUpdate();
    }

    public static void update(Unit unit, int idContainer) throws SQLException {
        String sql = "update unit set " +
                "name = ?,type = ?,keywords = ?, id_container = ? where id = ?";
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ps.setString(1, unit.name);
        ps.setString(2, unit.type);
        ps.setString(3, unit.keywords);
        ps.setInt(4, idContainer);
        ps.setInt(5, unit.id);
        ps.executeUpdate();
    }

    public static void delete(Unit unit) throws SQLException {
        String sql = "delete from file where id_unit =?";
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ps.setInt(1, unit.id);
        ps.executeUpdate();
        sql = "delete from unit where id =?";
        ps = db.getConnection().prepareStatement(sql);
        ps.setInt(1, unit.id);
        ps.executeUpdate();
    }

    public static int count() throws SQLException {
        ResultSet rs = db.query("select count(*) from unit ");
        rs.next();
        return rs.getInt(1);
    }

    public static boolean hasParent(Unit unit) {
        try {
            findParentBy(unit);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static Container findParentBy(Unit unit) throws SQLException  {
        Container.begin();
        ResultSet rs = db.query("select * from unit where id=" + unit.id+" and id_container is not null");
        rs.next();
        System.out.println(rs.getString(1));
        try {
            return Container.findBy(unit.id_container);
        } finally{
            Container.commit();
        }
    }


    public static List<Unit> findAll() throws SQLException {
        List<Unit> unit = new ArrayList<Unit>();
        ResultSet rs = db.query("select top 20 * from unit order by id desc");
        mapping(rs, unit);
        return unit;
    }

    public static Unit findBy(int id) throws SQLException {
        Unit unit = new Unit();
        ResultSet rs = db.query("select * from unit where id=" + id);
        rs.next();
        mappingElement(unit, rs);
        return unit;
    }

    public static List<Unit> findBy(String name) throws SQLException{
        String condition = "";
        if (name.contains("*")) {
            name = name.replace("*", "%");
            condition = "lcase(name) like '" + name.toLowerCase() + "'";
        } else {
            condition = "lcase(name) ='" + name.toLowerCase() + "'";
        }
        return findWhere(condition);
    }
    private static List<Unit> findWhere(String where) throws SQLException {
        List<Unit> containers = new ArrayList<Unit>();
        ResultSet rs = db.query("select * from unit where " + where + " order by id  desc");
        mapping(rs, containers);
        return containers;
    }

    private static void mapping(ResultSet rs, Collection<Unit> units) throws SQLException {
        while (rs.next()) {
            Unit container = new Unit();
            mappingElement(container, rs);
            units.add(container);
        }
    }

    private static void mappingElement(Unit unit, ResultSet rs) throws SQLException {
        unit.id = rs.getInt("id");
        unit.id_container = rs.getInt("id_container");
        unit.capacity = rs.getDouble("capacity");
        unit.name = rs.getString("name");
        unit.rented_to = rs.getString("rented_to");
        unit.type = rs.getString("type");
        unit.keywords = rs.getString("keywords");
        unit.rented_date = rs.getDate("rented_date");
        unit.release_date = rs.getDate("release_date");
        unit.creation_date = rs.getDate("creation_date");

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
