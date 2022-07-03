package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SampleDatabse {

    Connection conn = null;

    public Connection dbconnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String connectionUrl = "jdbc:mysql://localhost:3306/theepanbk?autoReconnect=true&useSSL=false";
            String connectionUser = "root";
            String connectionPassword = "root";
            conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("Error :" + e.toString());
        }
        return conn;
    }

    public void getCategoryList() {
        String query = "SELECT CATEGORY_ID,CATEGORY_NAME FROM SERVICE_CATEGORY;";
        try {
            PreparedStatement getCatStmt = dbconnect().prepareStatement(query, ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet resultSet = getCatStmt.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("CATEGORY_ID"));
                System.out.println(resultSet.getString("CATEGORY_NAME"));

            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        SampleDatabse db = new SampleDatabse();
        db.dbconnect();
        db.getCategoryList();
    }

}
