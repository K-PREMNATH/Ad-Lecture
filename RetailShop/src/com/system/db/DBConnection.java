/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class DBConnection {

    Connection connection = null;

    public Connection db_connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String connectionURL = "jdbc:mysql://localhost:3306/adv_prgm_retail?autoReconnect=true&useSSL=false";
            String connectionUser = "root";
            String connectionPasswod = "root";
            connection = DriverManager.getConnection(connectionURL, connectionUser, connectionPasswod);
            System.out.println("Connected Successfully!!!");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("Error : " + e.toString());
        }
        return connection;
    }

    public static void main(String[] args) {
         DBConnection dbc = new DBConnection();
         dbc.db_connect();
    }
}
