package jorgcore.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DataBase {

    private static final String BD_PATH = "db";
    private static final String USER = "";
    private static final String PWD = "";
    private static final String URL = "jdbc:derby:";
    private static final String PARAM = ";";
    private static Connection connection;
    static{
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DataBase() throws SQLException {
        if (connection != null) {
            if (connection.isClosed()) {
                connection = DriverManager.getConnection(URL + BD_PATH + PARAM, USER, PWD);
            }
        } else {
            connection = DriverManager.getConnection(URL + BD_PATH + PARAM, USER, PWD);
        }
    }

    public DataBase(final String url, final String usr, final String pwd) throws SQLException {
        connection = DriverManager.getConnection(url, usr, pwd);
    }

    public final int execute(final String sql) throws SQLException {
        return getConnection().createStatement().executeUpdate(sql);
    }

    public final ResultSet query(final String sql) throws SQLException {
        return getConnection().createStatement().executeQuery(sql);
    }

    @Deprecated
    public void close() throws SQLException {
        //getConnection().createStatement().execute("SHUTDOWN");
        //getConnection().close();
    }

    public static final Connection getConnection() {
        return connection;
    }
}
