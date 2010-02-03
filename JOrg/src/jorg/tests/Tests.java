package jorg.tests;

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
            Tests t = new Tests();
            t.field = "a";
            Tests t1 = t.clone();

            log(t1.field==t.field);
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
