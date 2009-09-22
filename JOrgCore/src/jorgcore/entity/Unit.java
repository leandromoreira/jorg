package jorgcore.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public class Unit {

    public int id;
    public int id_container;
    public String name;
    public String rented_to;
    public Date rented_date;
    public Date release_date;
    public Date creation_date;
    public String type; //dvd, cd, hd, pendrive, computer, folder
    public String keywords;
    public double capacity;

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
        return "Unit[id="+id+",name="+name+"]";
    }

}
