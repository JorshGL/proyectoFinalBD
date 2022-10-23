package views;

import models.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestView {
    public TestView(){

    }

    public static void main(String[] args) {
        try (Connection database = new DBConnection("bd_sqlcorte2_2022_2211358", "root", "root").connect()) {
            Statement statement = database.createStatement();
            String query  = "SELECT * FROM EMPRESAS";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                System.out.println(rs.getString("localizacion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
