package jorg.tests;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import jorg.gui.statistics.GraphGenerator;

public class Tests {

    public static void main(String[] args){
        jorg.gui.statistics.GraphGenerator t1 = new GraphGenerator();
        Tests t = new Tests();
        System.out.println(t.toString(t1));
    }








    public String toString(final Object obj){
        final String nome = obj.getClass().getName()+" ";
        final String inicio = "[";
        final String fim = "]";
        final StringBuilder sb = new StringBuilder();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                sb.append(field.getName() + " = ").append(field.get(obj) + ", ");
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Tests.class.getName())
                      .log(Level.SEVERE, null, ex);
            }
        }
        return nome +  inicio + sb.toString() + fim;
    }
}
