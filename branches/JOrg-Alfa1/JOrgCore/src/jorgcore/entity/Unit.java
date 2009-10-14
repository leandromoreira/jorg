package jorgcore.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import jorgcore.database.DataBase;

public class Unit {

    public int id;
    public int id_container;
    public String name;
    public String rented_to;
    public Date rented_date;
    public Date release_date;
    public Date creation_date;
    public String type;
    public String keywords;
    public double capacity;
    private static DataBase db;

    public static void begin() throws SQLException {
        db = new DataBase();
    }

    public static void commit() throws SQLException {
        db.close();
    }

    public static void insert(Unit unit) throws SQLException {
        String sql = "insert into unit(" +
                "name,creation_date,type,keywords) values (?,?,?,?)";
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ps.setString(1, unit.name);
        ps.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
        ps.setString(3, unit.type);
        ps.setString(4, unit.keywords);
        ps.executeUpdate();
    }

    public static void insert(Unit unit, int idContainer) throws SQLException {
        String sql = "insert into unit(" +
                "name,creation_date,type,keywords,id_container) values (?,?,?,?,?)";
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ps.setString(1, unit.name);
        ps.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
        ps.setString(3, unit.type);
        ps.setString(4, unit.keywords);
        ps.setInt(5, idContainer);
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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Unit other = (Unit) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public String toString() {
        return "Unit[id=" + id + ",name=" + name + "]";
    }
}