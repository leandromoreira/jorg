package jorg.gui.file;

import javax.swing.JLabel;

public class ListFileListener {

    private JLabel lbl;

    public ListFileListener(JLabel lbl) {
        if (lbl == null) {
            throw new IllegalArgumentException("The object must be valid!");
        }
        this.lbl = lbl;
    }

    public void fireChanges(String value) {
        if (value.length() > 37){
            value = value.substring(0, 34) + "...";
        }
        lbl.setText(value);
    }
}
