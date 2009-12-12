package jorg.gui;

import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import jorg.gui.config.Configurator;
import jorgcore.entity.Container;
import jorgcore.entity.Unit;

public final class SwingUtil {

    public final static void center(final JFrame frame) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point center = ge.getCenterPoint();
        Rectangle bounds = ge.getMaximumWindowBounds();
        int w = Math.max(bounds.width / 2, Math.min(frame.getWidth(), bounds.width));
        int h = Math.max(bounds.height / 2, Math.min(frame.getHeight(), bounds.height));
        int x = center.x - w / 2, y = center.y - h / 2;
        frame.setBounds(x, y, w, h);
        if (w == bounds.width && h == bounds.height) {
            frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        }
        frame.validate();
    }

    public final static void setupJLblToErrorMessage(final javax.swing.JLabel jlbl, final String text) {
        jlbl.setIcon(new javax.swing.ImageIcon(SwingUtil.class.getResource("/jorg/gui/picture/Stop24 (2).gif")));
        jlbl.setText("ERROR:"+text);
    }

    public final static void setDefaultButton(JFrame container, JButton jBtn) {
        container.getRootPane().setDefaultButton(jBtn);
    }

    public static final String getInternationalizedText(final String key) {
        return Configurator.getInternationlizedText(key);
    }

    public final static void resetMessage(final javax.swing.JLabel jlbl) {
        jlbl.setIcon(null);
        jlbl.setText("");
    }

    public final static void setupJLblToInfoMessage(final javax.swing.JLabel jlbl, final String text) {
        jlbl.setIcon(new javax.swing.ImageIcon(SwingUtil.class.getResource("/jorg/gui/picture/Information24.gif")));
        jlbl.setText(text);
    }

    public final static void initLookAndFeel(final String lookfeel) {
        String lookAndFeel = null;
        if (lookfeel != null) {
            if (lookfeel.equals("Metal")) {
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
            } else if (lookfeel.equals("System")) {
                lookAndFeel = UIManager.getSystemLookAndFeelClassName();
            } else if (lookfeel.equals("Motif")) {
                lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            } else if (lookfeel.equals("GTK")) {
                lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
            } else if (lookfeel.equals("Nimbus")){
                lookAndFeel = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
            }else{
                try {
                    UIManager.setLookAndFeel(lookAndFeel);
                } catch (ClassNotFoundException ex) {
                    lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
                    Logger.getLogger(SwingUtil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
                    Logger.getLogger(SwingUtil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
                    Logger.getLogger(SwingUtil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
                    Logger.getLogger(SwingUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                UIManager.setLookAndFeel(lookAndFeel);
            } catch (ClassNotFoundException e) {
                System.err.println("Couldn't find class for specified look and feel:" + lookAndFeel);
                System.err.println("Did you include the L&F library in the class path?");
                System.err.println("Using the default look and feel.");
                e.printStackTrace();
            } catch (UnsupportedLookAndFeelException e) {
                System.err.println("Can't use the specified look and feel (" + lookAndFeel + ") on this platform.");
                System.err.println("Using the default look and feel.");
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Couldn't get specified look and feel (" + lookAndFeel + "), for some reason.");
                System.err.println("Using the default look and feel.");
                e.printStackTrace();
            }
        }
    }

    public static void populateJTableContainer(JTable tab,int rowCount,Iterator<Container> it){
        if(rowCount>20) rowCount = 20;
        populateJTableContainerNew(tab, rowCount);
        try {
            Container.begin();
        } catch (SQLException ex) {
            Logger.getLogger(SwingUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        int row = 0;
        while (it.hasNext()){
            Container con = it.next();
            tab.setValueAt(con.id , row, 0);
            tab.setValueAt(con.description , row, 1);
            try {
                tab.setValueAt(Container.findParentBy(con.id).description, row, 2);
            } catch (SQLException ex) {
                tab.setValueAt("", row, 2);
            }
            row++;
        }
    }
    public static void populateJTableContainerNew(JTable tab,int rowCount) {
        TableColumnModel tb = new DefaultTableColumnModel();
        TableColumn id =new TableColumn(0, 150);
        id.setPreferredWidth(150);
        id.setResizable(false);
        TableColumn desc =new TableColumn(0, 350);
        desc.setPreferredWidth(350);
        desc.setResizable(false);
        TableColumn idP =new TableColumn(0, 150);
        idP.setPreferredWidth(150);
        idP.setResizable(false);
        tb.addColumn(id);
        tb.addColumn(desc);
        tb.addColumn(idP);

        String[] columnNames = new String[]{
            getInternationalizedText("container.table.id"),
            getInternationalizedText("container.table.description"),
            getInternationalizedText("container.table.id_pai")};
        TableModel tbm = new DefaultTableModel(columnNames, rowCount);
        tab.setColumnModel(tb);
        tab.setModel(tbm);

        tab.getColumnModel().getColumn(0).setResizable(false);
        tab.getColumnModel().getColumn(0).setMaxWidth(55);
        tab.getColumnModel().getColumn(1).setResizable(false);
        tab.getColumnModel().getColumn(1).setMaxWidth(300);
        tab.getColumnModel().getColumn(2).setResizable(false);
        tab.getColumnModel().getColumn(2).setMaxWidth(300);
    }

    public static void populateJTableUnit(JTable tab,int rowCount,Iterator<Unit> it){
        if(rowCount>20) rowCount = 20;
        populateJTableUnitNew(tab, rowCount);
        try {
            Unit.begin();
        } catch (SQLException ex) {
            Logger.getLogger(SwingUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        int row = 0;
        while (it.hasNext()){
            Unit con = it.next();
            tab.setValueAt(con.id , row, 0);
            tab.setValueAt(con.name , row, 1);
            tab.setValueAt(con.type , row, 2);
            row++;
        }
    }

    public static void populateJTableUnitNew(JTable tab,int rowCount) {
        TableColumnModel tb = new DefaultTableColumnModel();
        TableColumn id =new TableColumn(0, 150);
        id.setPreferredWidth(150);
        id.setResizable(false);
        TableColumn name =new TableColumn(0, 250);
        name.setPreferredWidth(350);
        name.setResizable(false);
        TableColumn type =new TableColumn(0, 250);
        type.setPreferredWidth(150);
        type.setResizable(false);
        tb.addColumn(id);
        tb.addColumn(name);
        tb.addColumn(type);

        String[] columnNames = new String[]{
            getInternationalizedText("unit.table.id"),
            getInternationalizedText("unit.table.name"),
            getInternationalizedText("unit.table.type")};
        TableModel tbm = new DefaultTableModel(columnNames, rowCount);
        tab.setColumnModel(tb);
        tab.setModel(tbm);

        tab.getColumnModel().getColumn(0).setResizable(false);
        tab.getColumnModel().getColumn(0).setMaxWidth(55);
        tab.getColumnModel().getColumn(1).setResizable(false);
        tab.getColumnModel().getColumn(1).setMaxWidth(300);
        tab.getColumnModel().getColumn(2).setResizable(false);
        tab.getColumnModel().getColumn(2).setMaxWidth(300);
    }
}