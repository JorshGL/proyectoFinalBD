package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final String dbName;
    private final String user;
    private final String password;

    public DBConnection(String dbName) {
        this.dbName = dbName;
        this.user = System.getenv("dbUser");
        this.password = System.getenv("dbPassword");
    }

    public DBConnection(String dbName, String user, String password) {
        this.dbName = dbName;
        this.user = user;
        this.password = password;
    }

    public Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sourceUrl = "jdbc:mysql:///" + dbName;
            connection = DriverManager.getConnection(sourceUrl, user, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
