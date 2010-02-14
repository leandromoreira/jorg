package jorgcore.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DataBase {
    private final static String ABS_PATH = new File("").getAbsolutePath();
    public static final String BD_PATH = ABS_PATH + File.separator + "db";
    private static final String USER = "";
    private static final String PWD = "";
    private static final String URL = "jdbc:derby:";
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String PARAM = ";";
    private static Connection connection;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private final static void log(final Object o) {
        System.out.println("Database: " + o);
    }

    public static void createDataBase() {
        try {
            final Connection con = DriverManager.getConnection(URL + BD_PATH + PARAM + "create=true;", USER, PWD);
            final String sqlContainer = "create table container( " + "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, " + "description VARCHAR(400), " + "id_pai INTEGER, " + "insert_date DATE, " + "CONSTRAINT fk_container  FOREIGN KEY (id_pai)  REFERENCES container (id) " + ") ";
            final String sqlIndexContainer = "create index container_description on container(description) ";
            final String sqlUnit = "create table unit( " + "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, " + "name VARCHAR(400), " + "rented_to VARCHAR(400), " + "rented_date DATE, " + "capacity DOUBLE, " + "id_container INTEGER, " + "type VARCHAR(30), " + "creation_date DATE, " + "keywords VARCHAR(800), " + "CONSTRAINT fk_unit  FOREIGN KEY (id_container)  REFERENCES container (id) " + ") ";
            final String sqlIndexUnit1 = "create index unit_name on unit(name) ";
            final String sqlIndexUnit2 = "create index unit_keyword on unit(keywords) ";
            final String sqlFile = "create table file( " + "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, " + "name VARCHAR(500), " + "path VARCHAR(500), " + "size DOUBLE, " + "id_unit INTEGER, " + "extension VARCHAR(20), " + "size_in_bytes BIGINT, " + "time_last_modified TIME, " + "date_last_modified DATE " + ") ";
            final String sqlIndexFile1 = "create index file_name on file(name) ";
            final String sqlIndexFile2 = "create index file_path on file(path) ";
            log("creating database...");
            createScheme(sqlContainer, con);
            createScheme(sqlIndexContainer, con);
            createScheme(sqlUnit, con);
            createScheme(sqlIndexUnit1, con);
            createScheme(sqlIndexUnit2, con);
            createScheme(sqlFile, con);
            createScheme(sqlIndexFile1, con);
            createScheme(sqlIndexFile2, con);
            con.close();
        } catch (Exception ex) {
            log(ex);
            ex.printStackTrace();
        }
    }

    private final static void createScheme(final String sql,final Connection con) throws SQLException {
        log("creating scheme...");
        log(sql);
        con.prepareStatement(sql).execute();
        log("scheme created");
    }

    private DataBase() throws SQLException {
        if (connection != null) {
            if (connection.isClosed()) {
                connection = DriverManager.getConnection(URL + BD_PATH + PARAM, USER, PWD);
            }
        } else {
            connection = DriverManager.getConnection(URL + BD_PATH + PARAM, USER, PWD);
        }
    }

    private DataBase(final String url, final String usr, final String pwd) throws SQLException {
        connection = DriverManager.getConnection(url, usr, pwd);
    }

    public static final int execute(final String sql) throws SQLException {
        return getConnection().createStatement().executeUpdate(sql);
    }

    public static final ResultSet query(final String sql) throws SQLException {
        return getConnection().createStatement().executeQuery(sql);
    }

    public static final Connection getConnection() {
        if (connection == null) {
            try {
                new DataBase();
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
}
