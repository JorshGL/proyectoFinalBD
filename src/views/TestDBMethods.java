package views;

import DatabaseConnection.DBConnection;
import models.Practicante;

import java.util.ArrayList;
import java.util.HashMap;

public class TestDBMethods {
    public TestDBMethods(){}

    public static void main(String[] args) {
        String test = "test1";
        StringBuffer testsb = new StringBuffer(test);
        testsb.deleteCharAt(testsb.length()-1);
        test = new String(testsb);
        System.out.print(test);
    }
}
