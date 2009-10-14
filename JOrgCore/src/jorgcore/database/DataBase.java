package jorgcore.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class DataBase {

    private static final String BD_PATH = "db/java";
    private static final String USER = "sa";
    private static final String PWD = "";
    private static final String URL = "jdbc:hsqldb:file:";
    private static final String PARAM = ";shutdown=true";
    private static Connection connection;

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

    public void close() throws SQLException {
        getConnection().createStatement().execute("SHUTDOWN");
        getConnection().close();
    }

    public final Connection getConnection() {
        return connection;
    }
}
