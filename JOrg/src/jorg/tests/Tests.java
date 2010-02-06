package jorg.tests;

import jorg.gui.statistics.GraphGenerator;
import jorgcore.entity.Unit;

public class Tests implements Cloneable {

    

    private int id;

    @Override
    protected void finalize() throws Throwable {
        log("finalizando " + id);
    }
    public String field;

    @Override
    protected Tests clone() throws CloneNotSupportedException {
        return (Tests) super.clone();
    }

    public static void main(String[] args) {
        try {
            Unit.begin();
            Unit unit = new  Unit();
            unit.name = "s";
            Unit.insert(unit);
            unit.id = Unit.lastId();
            unit.name = String.valueOf(unit.id);
            Unit.update(unit);
            Unit.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

    private static void a(short a) {
    }

    private static void log(Object o) {
        System.out.println(o);
    }
}
