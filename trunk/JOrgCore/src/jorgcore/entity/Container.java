package jorgcore.entity;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jorgcore.database.DataBase;

public class Container {

    public int id;
    public String description;
    public int id_pai;

    public static void insert(Container con) throws SQLException {
        String sql = "insert into container(description,insert_date) values (?,?)";
        PreparedStatement ps = DataBase.getConnection().prepareStatement(sql);
        ps.setString(1, con.description);
        ps.setDate(2, new Date(new java.util.Date().getTime()));
        ps.executeUpdate();
        ps.close();
    }

    public static void insert(Container con, int id_pai) throws SQLException {
        String sql = "insert into container(description,id_pai,insert_date) values (?,?,?)";
        PreparedStatement ps = DataBase.getConnection().prepareStatement(sql);
        ps.setString(1, con.description);
        ps.setInt(2, id_pai);
        ps.setDate(3, new Date(new java.util.Date().getTime()));
        ps.executeUpdate();
        ps.close();
    }

    public static void update(Container con) throws SQLException {
        String sql = "update container set description = ? where id = ?";
        PreparedStatement ps = DataBase.getConnection().prepareStatement(sql);
        ps.setString(1, con.description);
        ps.setInt(2, con.id);
        ps.executeUpdate();
        ps.close();
    }

    public static void update(Container con, int id_pai) throws SQLException {
        String sql = "update container set description = ?, id_pai = ? where id = ?";
        PreparedStatement ps = DataBase.getConnection().prepareStatement(sql);
        ps.setString(1, con.description);
        ps.setInt(2, id_pai);
        ps.setInt(3, con.id);
        ps.executeUpdate();
        ps.close();
    }

    public static void becomeRoot(Container con) throws SQLException {
        String sql = "update container set id_pai = ? where id = ?";
        PreparedStatement ps = DataBase.getConnection().prepareStatement(sql);
        ps.setNull(1, java.sql.Types.INTEGER);
        ps.setInt(2, con.id);
        ps.executeUpdate();
        ps.close();
    }

    public static void delete(Container con) throws SQLException {
        makeAllSonsRoot(con);
        String sql = "delete from container where id =?";
        PreparedStatement ps = DataBase.getConnection().prepareStatement(sql);
        ps.setInt(1, con.id);
        ps.executeUpdate();
        ps.close();
    }

    public static int count() throws SQLException {
        ResultSet rs = DataBase.query("select count(*) from container ");
        rs.next();
        int count = rs.getInt(1);
        rs.close();
        return count;
    }

    public static List<Container> findAll() throws SQLException {
        List<Container> containers = new ArrayList<Container>();
        ResultSet rs = DataBase.query("select * from container order by id desc offset 0 rows fetch next 20 rows only");
        mapping(rs, containers);
        rs.close();
        return containers;
    }

    public static Container findBy(int id) throws SQLException {
        Container container = new Container();
        ResultSet rs = DataBase.query("select * from container where id=" + id);
        rs.next();
        mappingElement(container, rs);
        rs.close();
        return container;
    }

    public static boolean hasParent(int id) {
        try {
            findParentBy(id);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static Container findParentBy(int id) throws SQLException {
        Container container = new Container();
        ResultSet rs = DataBase.query("select * from container where id=" + id + " and id_pai is not null");
        rs.next();
        mappingElement(container, rs);
        rs.close();
        rs = DataBase.query("select * from container where id=" + container.id_pai);
        rs.next();
        mappingElement(container, rs);
        rs.close();
        return container;
    }

    public static List<Container> findBy(String description) throws SQLException {
        String condition = "";
        if (description.contains("*")) {
            description = description.replace("*", "%");
            condition = "lcase(description) like '" + description.toLowerCase() + "'";
        } else {
            condition = "lcase(description) ='" + description.toLowerCase() + "'";
        }
        return findWhere(condition);
    }

    private static List<Container> findWhere(String where) throws SQLException {
        List<Container> containers = new ArrayList<Container>();
        ResultSet rs = DataBase.query("select * from container where " + where + " order by id  desc");
        mapping(rs, containers);
        rs.close();
        return containers;
    }

    public static List<Container> findAllRoots() throws SQLException {
        return findWhere("id_pai is null");
    }

    public static String giveMeFullAdresOf(Container node) throws SQLException {
        List<Container> list = findParents(node);
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        Iterator<Container> it = list.iterator();
        while (it.hasNext()) {
            sb.append(" >> " + it.next().description);
        }
        String tmp = sb.toString();
        return tmp.substring(4, tmp.length());
    }

    public static List<Container> findParents(Container node) throws SQLException {
        int id_pai_tmp = node.id_pai;
        int id_tmp = node.id;
        List<Container> containers = new ArrayList<Container>();
        containers.add(node);
        Container container = null;
        do {
            ResultSet rsLast = DataBase.query("select * from container where id=" + id_tmp + " and id_pai is null");
            if (rsLast.next()) {
                rsLast.close();
                break;
            }
            ResultSet rs = DataBase.query("select * from container where id=" + id_pai_tmp);
            if (rs.next()) {
                container = new Container();
                mappingElement(container, rs);
                containers.add(container);
                id_tmp = container.id;
                if (id_pai_tmp == container.id_pai) {
                    container = null;
                } else {
                    id_pai_tmp = container.id_pai;
                }
            } else {
                container = null;
            }
        } while (container != null);
        return containers;
    }

    private static void mapping(ResultSet rs, Collection<Container> containers) throws SQLException {
        while (rs.next()) {
            Container container = new Container();
            mappingElement(container, rs);
            containers.add(container);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Container other = (Container) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + (this.description != null ? this.description.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return getClass().getCanonicalName() + " id=" + id + ", desc=" + description;
    }

    private static void mappingElement(Container container, ResultSet rs) throws SQLException {
        container.id = rs.getInt("id");
        container.description = rs.getString("description");
        container.id_pai = rs.getInt("id_pai");
    }

    private static void makeAllSonsRoot(Container con) throws SQLException {
        deleteAllUnitLinks(con);
        String sql = "update container set id_pai = ? where id_pai = ? ";
        PreparedStatement ps = DataBase.getConnection().prepareStatement(sql);
        ps.setNull(1, java.sql.Types.INTEGER);
        ps.setInt(2, con.id);
        ps.executeUpdate();
        ps.close();
    }

    private static void deleteAllUnitLinks(Container con) throws SQLException {
        String sql = "update unit set id_container = ? where id = ? ";
        PreparedStatement ps = DataBase.getConnection().prepareStatement(sql);
        ps.setNull(1, java.sql.Types.INTEGER);
        ps.setInt(2, con.id);
        ps.executeUpdate();
        ps.close();
    }
}
