package views;

import DatabaseConnection.DBConnection;

import java.util.ArrayList;
import java.util.HashMap;

public class TestDBMethods {
    public TestDBMethods(){}

    public static void main(String[] args) {
        DBConnection c = new DBConnection("bd_sqlcorte2_2022_2211358", "root", "root");
        ArrayList<HashMap<String, Object>> result = c.executeQuery(
                "SELECT * FROM CONSULTORIAS"
        );
        for (HashMap<String, Object> map : result) {
            System.out.print(map);
        }
    }
}
