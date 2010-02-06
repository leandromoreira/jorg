package jorg.gui.statistics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jorg.gui.config.Configurator;
import jorgcore.database.DataBase;

public class Statistics extends javax.swing.JFrame {

    public Statistics() {
        initComponents();
    }

    private void computeGroupByPercent(final Map<String, Double> groupByPercent, final int fileQuantity, final Connection con, PreparedStatement ps, ResultSet rs) {
        compute("Audio", Configurator.getAudioTypes(), groupByPercent, fileQuantity, con, ps, rs);
        compute("Html", Configurator.getHtmlTypes(), groupByPercent, fileQuantity, con, ps, rs);
        compute("Personal", Configurator.getPersonalTypes(), groupByPercent, fileQuantity, con, ps, rs);
        compute("Compression", Configurator.getCompressionTypes(), groupByPercent, fileQuantity, con, ps, rs);
        compute("Disk Image", Configurator.getImageTypes(), groupByPercent, fileQuantity, con, ps, rs);
        compute("Doc", Configurator.getDocTypes(), groupByPercent, fileQuantity, con, ps, rs);
        compute("Picture", Configurator.getPictureTypes(), groupByPercent, fileQuantity, con, ps, rs);
        compute("Video", Configurator.getVideoTypes(), groupByPercent, fileQuantity, con, ps, rs);
    }

    private int createFileCounterReport(ResultSet rs, PreparedStatement ps) throws SQLException {
        int fileQuantity = 0;
        if (rs.next()) {
            fileQuantity = rs.getInt(1);
        }
        ps.close();
        rs.close();
        return fileQuantity;
    }

    private void createJTabPanelTabs() {
        if (jTabPanel.getComponentCount() < 2) {
            jTabPanel.addTab("Group", null);
            jTabPanel.addTab("Extension", null);
        }
    }

    private String[] fileBaseOnItsModifiedDate(Connection con, String sql, PreparedStatement ps, ResultSet rs) throws SQLException {
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        String[] name = new String[2];
        if (rs.next()) {
            name[0] = rs.getString(1);
            name[1] = rs.getString(2);
            if (sql.toLowerCase().contains("min")) {
                olderDate = rs.getDate(3);
            } else {
                newerDate = rs.getDate(3);
            }
        }
        ps.close();
        rs.close();
        return name;
    }

    private Map<String, Integer> top10Extensions(Connection con, String sql, PreparedStatement ps, ResultSet rs) throws SQLException {
        sql = "select extension,count(extension) from file group by extension order by count(extension) desc offset 0 rows fetch next 10 rows only ";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        while (rs.next()) {
            map.put(rs.getString(1), rs.getInt(2));
        }
        ps.close();
        rs.close();
        return map;
    }
    private Date olderDate, newerDate;

    private String[] newerFile(Connection con, String sql, PreparedStatement ps, ResultSet rs) throws SQLException {
        sql = "select name,size,date_last_modified from file where date_last_modified = (select max(date_last_modified) from file)";
        return fileBaseOnItsModifiedDate(con, sql, ps, rs);
    }

    private String[] olderFile(Connection con, String sql, PreparedStatement ps, ResultSet rs) throws SQLException {
        sql = "select name,size,date_last_modified from file where date_last_modified = (select min(date_last_modified) from file)";
        return fileBaseOnItsModifiedDate(con, sql, ps, rs);
    }

    private String[] biggerFile(Connection con, String sql, PreparedStatement ps, ResultSet rs) throws SQLException {
        sql = "select name,size from file where size = (select max(size) from file)";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        String name[] = new String[2];
        if (rs.next()) {
            name[0] = rs.getString(1);
            name[1] = rs.getString(2);
        }
        ps.close();
        rs.close();
        return name;
    }

    private int quantityOfFileFor(Connection con, String[] ext, PreparedStatement ps, ResultSet rs) throws SQLException {
        String sql = "select count(*) from file where extension in (";
        for (String string : ext) {
            sql += "'" + string.trim() + "',";
        }
        sql = sql.substring(0, sql.length() - 1) + ")";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        int totalSize = 0;
        if (rs.next()) {
            totalSize = rs.getInt(1);
        }
        ps.close();
        rs.close();
        return totalSize;
    }

    private double createSumarizeOfSize(Connection con, String sql, PreparedStatement ps, ResultSet rs) throws SQLException {
        sql = "select sum(size) from file";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        double totalSize = 0;
        if (rs.next()) {
            totalSize = rs.getDouble(1) / 1024;
        }
        ps.close();
        rs.close();
        return totalSize;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabPanel = new javax.swing.JTabbedPane();
        jPnNew = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtAreaGeneral = new javax.swing.JTextArea();
        jLblInfo = new javax.swing.JLabel();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jtxtAreaGeneral.setBackground(new java.awt.Color(0, 0, 0));
        jtxtAreaGeneral.setColumns(20);
        jtxtAreaGeneral.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jtxtAreaGeneral.setForeground(new java.awt.Color(51, 255, 0));
        jtxtAreaGeneral.setRows(5);
        jScrollPane1.setViewportView(jtxtAreaGeneral);

        javax.swing.GroupLayout jPnNewLayout = new javax.swing.GroupLayout(jPnNew);
        jPnNew.setLayout(jPnNewLayout);
        jPnNewLayout.setHorizontalGroup(
            jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnNewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPnNewLayout.setVerticalGroup(
            jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnNewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabPanel.addTab("General", jPnNew);

        jLblInfo.setFont(new java.awt.Font("Tahoma", 0, 32));
        jLblInfo.setForeground(new java.awt.Color(51, 51, 255));
        jLblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblInfo.setText("Statistics");
        jLblInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
                    .addComponent(jLblInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void compute(String key, String[] extensions, Map<String, Double> groupByPercent, int fileQuantity, Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            int xQuantity;
            xQuantity = quantityOfFileFor(con, extensions, ps, rs);
            double xPercent = (100.0d * (double) xQuantity) / (double) fileQuantity;
            groupByPercent.put(key, xPercent);
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            final Connection con = DataBase.getConnection();
            String sql = "select count(*) from file";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            final int fileQuantity = createFileCounterReport(rs, ps);
            final int unitQuantity = createUnitCounterReport(con, sql, ps, rs);
            final int rentedUnitQuantity = createRentedUnitCounterReport(con, sql, ps, rs);
            final double totalSize = createSumarizeOfSize(con, sql, ps, rs);
            final String[] biggerFile = biggerFile(con, sql, ps, rs);
            final String[] olderFile = olderFile(con, sql, ps, rs);
            final String[] newerFile = newerFile(con, sql, ps, rs);
            try {
                final Map<String, Integer> topExtensions = top10Extensions(con, sql, ps, rs);
                final Map<String, Double> groupByPercent = new LinkedHashMap<String, Double>();
                computeGroupByPercent( groupByPercent, fileQuantity, con, ps, rs);
                GraphGenerator g = new GraphGenerator();
                createJTabPanelTabs();
                g.generateGroupGraph(groupByPercent);
                jTabPanel.setComponentAt(1, g.getGroupChart());
                g.generateExtensionGraph(topExtensions);
                jTabPanel.setComponentAt(2, g.getPopularExtensionChart());
            } catch (Exception e) {
                e.printStackTrace();
            }

            jtxtAreaGeneral.setText("File's quantity: " + fileQuantity +
                    "\nUnit's quantity: " + unitQuantity +
                    "\nRented Unit's quantity: " + rentedUnitQuantity +
                    "\nTotal size: " + NumberFormat.getInstance().format(totalSize / 1024) + " TB (" + NumberFormat.getInstance().format(totalSize) + " GB)" + "\nBigger File: " + biggerFile[0] + " " + NumberFormat.getInstance().format(Double.parseDouble(biggerFile[1])) + " MB" +
                    "\nNewer File: " + newerFile[0] + " " + NumberFormat.getInstance().format(Double.parseDouble(newerFile[1])) + " MB " + new SimpleDateFormat().format(newerDate) +
                    "\nOlder File: " + olderFile[0] + " " + NumberFormat.getInstance().format(Double.parseDouble(olderFile[1])) + " MB " + new SimpleDateFormat().format(olderDate));
            jtxtAreaGeneral.moveCaretPosition(0);

        } catch (Exception ex) {
            jtxtAreaGeneral.setText(ex.toString());
        }
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Statistics().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblInfo;
    private javax.swing.JPanel jPnNew;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabPanel;
    private javax.swing.JTextArea jtxtAreaGeneral;
    // End of variables declaration//GEN-END:variables

    private int createUnitCounterReport(Connection con, String sql, PreparedStatement ps, ResultSet rs) throws SQLException {
        sql = "select count(*) from unit";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        ps.close();
        rs.close();
        return 0;
    }

    private int createRentedUnitCounterReport(Connection con, String sql, PreparedStatement ps, ResultSet rs) throws SQLException {
        sql = "select count(*) from unit where rented_to is not null";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        ps.close();
        rs.close();
        return 0;
    }
}
