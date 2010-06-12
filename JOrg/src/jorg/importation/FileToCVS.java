package jorg.importation;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jorg.gui.config.Configurator;
import jorgcore.database.DataBase;

public class FileToCVS implements Runnable {

    private static final String sqlCount = Configurator.getSetupProprerty("import.sql.count");
    private static final String sqlAll = Configurator.getSetupProprerty("import.sql.all");
    private static final String enter = "\n";
    private static final String separator = ";";
    private ProgressListener progress;
    public FileToCVS(ProgressListener progress){
        this.progress = progress;
    }

    @Override
    public void run(){
        importFileToCVS();
    }

    private void importFileToCVS() {
        final Connection con = DataBase.getConnection();
        try {
            progress.total = computeTotal(con, sqlCount);
            progress.actual = 1;
            PreparedStatement p = con.prepareStatement(sqlAll);
            ResultSet rs = p.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int numberOfColumns = rsm.getColumnCount();
            boolean firstTime = true;
            StringBuilder sb = new StringBuilder(5000);
            while (rs.next()) {
                if (firstTime) {
                    firstTime = false;
                    for (int col = 0; col < numberOfColumns; ++col) {
                        String name = rsm.getColumnName(col + 1);
                        if ((col + 1) == numberOfColumns) {
                            sb.append(name + enter);
                        } else {
                            sb.append(name + separator);
                        }
                    }
                }
                for (int col = 0; col < numberOfColumns; ++col) {
                    Object valor = rs.getObject(col + 1);
                    String name = (valor==null)?"null":valor.toString();
                    if ((col + 1) == numberOfColumns) {
                        sb.append(name + enter);
                    } else {
                        sb.append(name + separator);
                    }
                }
                progress.actual = progress.actual + 1;
            }
            try {
                File f = new File("files.csv");
                if (f.exists()){
                    f.delete();
                }
                FileWriter fw = new FileWriter(f);
                fw.append(sb.toString());
                fw.flush();
                fw.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                Logger.getLogger(FileToCVS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static long computeTotal(final Connection con, String sqlCount) throws SQLException {
        long total = 0;
        PreparedStatement p = con.prepareStatement(sqlCount);
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            total = rs.getLong(1);
        }
        return total;
    }
}
