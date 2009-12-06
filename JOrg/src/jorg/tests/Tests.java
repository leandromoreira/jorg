package jorg.tests;

import java.util.Arrays;
import jorg.gui.config.Configurator;

public class Tests {

    public static void main(String[] args) {
        String[] files = {"queen","Desktop.ini"};
        for (String file : files) {
            System.out.println(file + ": "+Configurator.isIndexable(file));
        }
        System.out.println(Arrays.toString(Configurator.getStopWords()));

        /*try {
            JorgSearchSystem indexer = new JorgSearchSystem();
            indexer.setupSearching();
            Hits r = indexer.search("netbeans");
            for( int i = 0 ; i < r.length() ; i++){
                System.out.println(r.doc(i).get("identity"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }*/
    }

}
