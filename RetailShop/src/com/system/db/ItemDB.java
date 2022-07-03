/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.db;

import com.system.model.CategoryDropDown;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class ItemDB extends DBConnection implements IItem {

    @Override
    public List<CategoryDropDown> getCategoryForDropdown() {
        Connection connection = null;
        Statement statement = null;
        List<CategoryDropDown> list = null;
        try {
            String query = "SELECT * FROM CATEGORY order by CATEGORY_ID desc;";
            connection = this.db_connect();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet != null) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    CategoryDropDown model = new CategoryDropDown();
                    model.setCategoryId(resultSet.getInt("CATEGORY_ID"));
                    model.setCategoryName(resultSet.getString("CATEGORY_NAME"));
                    list.add(model);
                }
            }

        } catch (SQLException exception) {
            System.out.println("Error : " + exception.toString());
        } catch (Exception exception) {
            System.out.println("Error : " + exception.toString());
        } finally {
            try {
                if (statement != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
        return list;
    }
}
