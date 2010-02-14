package jorg.gui;

import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.RootPaneContainer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import jorg.gui.config.Configurator;
import jorg.gui.picture.icons.IconCellRender;
import jorgcore.entity.Container;
import jorgcore.entity.File;
import jorgcore.entity.Unit;

public final class SwingUtil {

    private static int SELECT_ONE_ROW = 0;
    private final static TableCellRenderer ICON_CELL_RENDER = new IconCellRender();

    public final static void center(final Frame frame) {
        final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        final Point center = ge.getCenterPoint();
        final Rectangle bounds = ge.getMaximumWindowBounds();
        int w = Math.max(bounds.width / 2, Math.min(frame.getWidth(), bounds.width));
        final int h = Math.max(bounds.height / 2, Math.min(frame.getHeight(), bounds.height));
        final int x = center.x - w / 2, y = center.y - h / 2;
        frame.setBounds(x, y, w, h);
        if (w == bounds.width && h == bounds.height) {
            frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        }
        frame.validate();
    }

    public final static void setupJLblToErrorMessage(final javax.swing.JLabel jlbl, final String text) {
        jlbl.setIcon(new javax.swing.ImageIcon(SwingUtil.class.getResource("/jorg/gui/picture/Stop24 (2).gif")));
        jlbl.setText("ERROR:" + text);
    }

    public final static void setDefaultButton(final RootPaneContainer container, final JButton jBtn) {
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
            } else if (lookfeel.equals("Nimbus")) {
                lookAndFeel = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
            } else {
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

    public static void populateJTableContainer(final JTable tab, int rowCount, final Iterator<Container> it) {
        if (rowCount > 20) {
            rowCount = 20;
        }
        setupJTableContainerNew(tab, rowCount);
        populateContainer(it, tab);
    }

    public static void setupJTableContainerNew(JTable tab, int rowCount) {
        TableColumnModel tcm = setupTableColumnModelWith(3);
        String[] columnNames = new String[]{
            getInternationalizedText("container.table.id"),
            getInternationalizedText("container.table.description"),
            getInternationalizedText("container.table.id_pai")};
        finalSetup(columnNames, rowCount, tab, tcm);
        setTableColumn(tab.getColumnModel().getColumn(0), 55);
        setTableColumn(tab.getColumnModel().getColumn(1), 300);
        setTableColumn(tab.getColumnModel().getColumn(2), 300);
    }

    private final static void populateJTableFile(final Iterator<File> it, final JTable tab) {
        int row = 0;
        DecimalFormat df = new DecimalFormat("#.##MB");
        while (it.hasNext()) {
            File file = it.next();
            tab.setValueAt(Configurator.getPathFor(file.extension), row, 0);
            tab.setValueAt(file.id, row, 1);
            tab.setValueAt(file.name, row, 2);
            tab.setValueAt(file.path, row, 3);
            tab.setValueAt(df.format(file.size), row, 4);
            row++;
        }
    }

    private final static void populateJTableUnit(final Iterator<Unit> it, final JTable tab) {
        int row = 0;
        while (it.hasNext()) {
            Unit con = it.next();
            tab.setValueAt(con.id, row, 0);
            tab.setValueAt(con.name, row, 1);
            tab.setValueAt(con.type, row, 2);
            if (con.rented_to == null) {
                tab.setValueAt("", row, 3);
            } else {
                tab.setValueAt(con.rented_to + " - " + (con.rented_date == null ? "" : con.rented_date.toLocaleString()), row, 3);
            }
            row++;
        }
    }

    private static void setTableColumn(final TableColumn column, final int width) {
        setTableColumn(column, false, width);
    }

    private static void setTableColumn(final TableColumn column, final int width, final TableCellRenderer cellRender) {
        setTableColumn(column, false, width);
        column.setCellRenderer(cellRender);
    }

    private static void setTableColumn(final TableColumn column, final boolean resizable, final int width) {
        column.setResizable(resizable);
        column.setMaxWidth(width);
    }

    public static void populateJTableFile(final JTable tab, final int rowCount, final Iterator<File> it) {
        TableColumnModel tb = setupTableColumnModelWith(5);
        String[] columnNames = new String[]{"",
            getInternationalizedText("file.id"),
            getInternationalizedText("file.name"),
            getInternationalizedText("file.path"),
            getInternationalizedText("file.size")
        };
        finalSetup(columnNames, rowCount, tab, tb, 48);
        setTableColumn(tab.getColumnModel().getColumn(0), 55, ICON_CELL_RENDER);
        setTableColumn(tab.getColumnModel().getColumn(1), 85);
        setTableColumn(tab.getColumnModel().getColumn(2), 600);
        setTableColumn(tab.getColumnModel().getColumn(3), 300);
        setTableColumn(tab.getColumnModel().getColumn(4), 85);
        populateJTableFile(it, tab);
    }

    public static void populateJTableUnit(final JTable tab, int rowCount, final Iterator<Unit> it) {
        if (rowCount > 20) {
            rowCount = 20;
        }
        setupJTableUnit(tab, rowCount);
        populateJTableUnit(it, tab);
    }

    public static void setupJTableUnit(final JTable tab, final int rowCount) {
        TableColumnModel tb = setupTableColumnModelWith(4);
        String[] columnNames = new String[]{
            getInternationalizedText("unit.table.id"),
            getInternationalizedText("unit.table.name"),
            getInternationalizedText("unit.table.type"),
            getInternationalizedText("unit.table.rented")
        };
        finalSetup(columnNames, rowCount, tab, tb);
        setTableColumn(tab.getColumnModel().getColumn(0), 55);
        setTableColumn(tab.getColumnModel().getColumn(1), 300);
        setTableColumn(tab.getColumnModel().getColumn(2), 300);
        setTableColumn(tab.getColumnModel().getColumn(3), 300);
    }

    private static void finalSetup(final String[] columnNames, final int rowCount, final JTable tab, final TableColumnModel tcm, final int rowHeight) {
        finalSetup(columnNames, rowCount, tab, tcm);
        tab.setRowHeight(rowHeight);
    }

    private static void finalSetup(final String[] columnNames, final int rowCount, final JTable tab, final TableColumnModel tcm) {
        TableModel tbm = new DefaultTableModel(columnNames, rowCount) {

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        tab.setColumnModel(tcm);
        tab.setModel(tbm);
        tab.setSelectionMode(SELECT_ONE_ROW);
        tab.setAutoCreateRowSorter(true);
    }

    private static void populateContainer(final Iterator<Container> it, final JTable tab) {
        int row = 0;
        while (it.hasNext()) {
            Container con = it.next();
            tab.setValueAt(con.id, row, 0);
            tab.setValueAt(con.description, row, 1);
            try {
                tab.setValueAt(Container.findParentBy(con.id).description, row, 2);
            } catch (SQLException ex) {
                tab.setValueAt("", row, 2);
            }
            row++;
        }
    }

    private static TableColumnModel setupTableColumnModelWith(final int howMuchColumns) {
        final TableColumnModel tcm = new DefaultTableColumnModel();
        for (int i = 0; i < howMuchColumns; i++) {
            tcm.addColumn(new TableColumn());
        }
        return tcm;
    }
}
