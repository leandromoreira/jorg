package jorg.tests;

import java.text.DecimalFormat;

public class Tests {

    public static void main(String[] args) {
        try {
          double d = 5454541.0454578645;
          DecimalFormat df = new DecimalFormat("#.##MB");
            System.out.println(df.format(d));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

}
