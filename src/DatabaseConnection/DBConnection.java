package DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DBConnection {
    private final String dbName;
    private final String user;
    private final String pwd;

    public DBConnection(String dbName, String user, String pwd) {
        this.dbName = dbName;
        this.user = user;
        this.pwd = pwd;
    }

    public DBConnection(String dbName) {
        this.dbName = dbName;
        this.user = System.getenv("DBuser");
        this.pwd = System.getenv("DBpwd");
    }

    public String getDbName() {
        return dbName;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }

    private Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String srcUrl = "jdbc:mysql:///" + dbName;
            return DriverManager.getConnection(srcUrl, user, pwd);
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int executeSQL(String sql) {
        try (Connection connection = connect()) {
            Statement stm = connection.createStatement();
            return stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<HashMap<String, Object>> executeQuery(String query) {
        ArrayList<HashMap<String, Object>> arr = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement stm = connection.createStatement();
            ResultSet res = stm.executeQuery(query);
            ResultSetMetaData resMtd = res.getMetaData();
            while (res.next()) {
                HashMap<String, Object> map = new HashMap<>();
                for (int i = 1; i <= resMtd.getColumnCount(); i++) {
                    map.put(resMtd.getColumnName(i), res.getString(i));
                }
                arr.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
