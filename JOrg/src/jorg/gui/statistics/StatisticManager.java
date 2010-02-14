package jorg.gui.statistics;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jorg.gui.config.Configurator;
import jorgcore.database.DataBase;

public class StatisticManager implements Runnable {

    private final Statistics listener;

    public StatisticManager(Statistics listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        String initText = listener.getjLblInfo().getText();
        try {
            listener.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            listener.getJtxtAreaGeneral().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            listener.getjPrgStatistics().setIndeterminate(true);
            listener.updateInfo(Configurator.getInternationlizedText("statistics.initiating"));
            final Connection con = DataBase.getConnection();
            String sql = "select count(*) from file";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            listener.updateInfo(Configurator.getInternationlizedText("statistics.file.qtd"));
            final int fileQuantity = createFileCounterReport(rs, ps);
            listener.updateInfo(Configurator.getInternationlizedText("statistics.unit.qtd"));
            final int unitQuantity = createUnitCounterReport(con, sql, ps, rs);
            listener.updateInfo(Configurator.getInternationlizedText("statistics.rented.unit.qtd"));
            final int rentedUnitQuantity = createRentedUnitCounterReport(con, sql, ps, rs);
            listener.updateInfo(Configurator.getInternationlizedText("statistics.total.size"));
            final double totalSize = createSumarizeOfSize(con, sql, ps, rs);
            listener.updateInfo(Configurator.getInternationlizedText("statistics.bigger.file"));
            final String[] biggerFile = biggerFile(con, sql, ps, rs);
            listener.updateInfo(Configurator.getInternationlizedText("statistics.older.file"));
            final String[] olderFile = olderFile(con, sql, ps, rs);
            listener.updateInfo(Configurator.getInternationlizedText("statistics.newer.file"));
            final String[] newerFile = newerFile(con, sql, ps, rs);
            try {
                listener.updateInfo(Configurator.getInternationlizedText("statistics.tab.top10.title"));
                final Map<String, Integer> topExtensions = top10Extensions(con, sql, ps, rs);
                final Map<String, Double> groupByPercent = new LinkedHashMap<String, Double>();
                listener.updateInfo(Configurator.getInternationlizedText("statistics.tab.grouping.title"));
                computeGroupByPercent(groupByPercent, fileQuantity, con, ps, rs);
                listener.updateInfo(Configurator.getInternationlizedText("graphs"));
                GraphGenerator g = new GraphGenerator();
                listener.updateInfo(Configurator.getInternationlizedText("grouping.graph"));
                g.generateGroupGraph(groupByPercent);
                listener.getjTabPanel().setComponentAt(1, g.getGroupChart());
                listener.updateInfo(Configurator.getInternationlizedText("extensions.graph"));
                g.generateExtensionGraph(topExtensions);
                listener.getjTabPanel().setComponentAt(2, g.getPopularExtensionChart());
            } catch (Exception e) {
                e.printStackTrace();
            }

            listener.getJtxtAreaGeneral().setText(Configurator.getInternationlizedText("statistics.file.qtd") + ": " + fileQuantity +
                    "\n" + Configurator.getInternationlizedText("statistics.unit.qtd") + ": " + unitQuantity +
                    "\n" + Configurator.getInternationlizedText("statistics.rented.unit.qtd") + ": " + rentedUnitQuantity +
                    "\n" + Configurator.getInternationlizedText("statistics.total.size") + ": " + NumberFormat.getInstance().format(totalSize / 1024) + " TB (" + NumberFormat.getInstance().format(totalSize) + " GB)" + "\n" + Configurator.getInternationlizedText("statistics.bigger.file") + ": " + biggerFile[0] + " " + NumberFormat.getInstance().format(Double.parseDouble(biggerFile[1])) + " MB" +
                    "\n" + Configurator.getInternationlizedText("statistics.newer.file") + ": " + newerFile[0] + " " + NumberFormat.getInstance().format(Double.parseDouble(newerFile[1])) + " MB " + new SimpleDateFormat().format(listener.getNewerDate()) +
                    "\n" + Configurator.getInternationlizedText("statistics.older.file") + ": " + olderFile[0] + " " + NumberFormat.getInstance().format(Double.parseDouble(olderFile[1])) + " MB " + new SimpleDateFormat().format(listener.getOlderDate()));
            listener.getJtxtAreaGeneral().moveCaretPosition(0);
        } catch (Exception ex) {
            listener.getJtxtAreaGeneral().setText(ex.toString());
        } finally {
            listener.getjPrgStatistics().setIndeterminate(false);
            listener.getjLblInfo().setText((initText));
            listener.setCursor(Cursor.getDefaultCursor());
            listener.getJtxtAreaGeneral().setCursor(Cursor.getDefaultCursor());
        }
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

    private int createFileCounterReport(ResultSet rs, PreparedStatement ps) throws SQLException {
        int fileQuantity = 0;
        if (rs.next()) {
            fileQuantity = rs.getInt(1);
        }
        ps.close();
        rs.close();
        return fileQuantity;
    }

    private int createUnitCounterReport(Connection con, String sql, PreparedStatement ps, ResultSet rs) throws SQLException {
        int unitCounter = 0;
        sql = "select count(*) from unit";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            unitCounter = rs.getInt(1);
        }
        ps.close();
        rs.close();
        return unitCounter;
    }

    private int createRentedUnitCounterReport(Connection con, String sql, PreparedStatement ps, ResultSet rs) throws SQLException {
        int lentCount = 0;
        sql = "select count(*) from unit where rented_to is not null";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            lentCount = rs.getInt(1);
        }
        ps.close();
        rs.close();
        return lentCount;
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

    private String[] newerFile(Connection con, String sql, PreparedStatement ps, ResultSet rs) throws SQLException {
        sql = "select name,size,date_last_modified from file where date_last_modified = (select max(date_last_modified) from file)";
        return fileBaseOnItsModifiedDate(con, sql, ps, rs);
    }

    private String[] olderFile(Connection con, String sql, PreparedStatement ps, ResultSet rs) throws SQLException {
        sql = "select name,size,date_last_modified from file where date_last_modified = (select min(date_last_modified) from file)";
        return fileBaseOnItsModifiedDate(con, sql, ps, rs);
    }

    private String[] fileBaseOnItsModifiedDate(Connection con, String sql, PreparedStatement ps, ResultSet rs) throws SQLException {
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        String[] name = new String[2];
        if (rs.next()) {
            name[0] = rs.getString(1);
            name[1] = rs.getString(2);
            if (sql.toLowerCase().contains("min")) {
                listener.setOlderDate(rs.getDate(3));
            } else {
                listener.setNewerDate(rs.getDate(3));
            }
        }
        ps.close();
        rs.close();
        return name;
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

    private void computeGroupByPercent(final Map<String, Double> groupByPercent, final int fileQuantity, final Connection con, PreparedStatement ps, ResultSet rs) {
        compute(Configurator.getInternationlizedText("config.audio"), Configurator.getAudioTypes(), groupByPercent, fileQuantity, con, ps, rs);
        compute(Configurator.getInternationlizedText("config.html"), Configurator.getHtmlTypes(), groupByPercent, fileQuantity, con, ps, rs);
        compute(Configurator.getInternationlizedText("config.personal"), Configurator.getPersonalTypes(), groupByPercent, fileQuantity, con, ps, rs);
        compute(Configurator.getInternationlizedText("config.compression"), Configurator.getCompressionTypes(), groupByPercent, fileQuantity, con, ps, rs);
        compute(Configurator.getInternationlizedText("config.disk.image"), Configurator.getImageTypes(), groupByPercent, fileQuantity, con, ps, rs);
        compute(Configurator.getInternationlizedText("config.docs"), Configurator.getDocTypes(), groupByPercent, fileQuantity, con, ps, rs);
        compute(Configurator.getInternationlizedText("config.picture"), Configurator.getPictureTypes(), groupByPercent, fileQuantity, con, ps, rs);
        compute(Configurator.getInternationlizedText("config.video"), Configurator.getVideoTypes(), groupByPercent, fileQuantity, con, ps, rs);
    }

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
}
