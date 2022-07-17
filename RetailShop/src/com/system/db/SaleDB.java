/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.db;

import com.system.model.GetItem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Acer
 */
public class SaleDB extends DBConnection implements ISale {

    @Override
    public GetItem getItemBySpecificCode(int code) {
        Connection connection = null;
        Statement statement = null;
        GetItem item = null;
        try {
            String query = "select ITEM_ID,ITEM_NAME,(select ir.ITEM_RATE from item_rate ir where ir.RATE_ITEM_ID = i.ITEM_ID order by ir.RATE_CREATED_DATE desc limit 1) ITEM_RATE from item i where i.ITEM_SPECIFY_CODE = '" + code + "';";
            connection = this.db_connect();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet != null) {
                item = new GetItem();
                while (resultSet.next()) {
                    item.setItemId(resultSet.getInt("ITEM_ID"));
                    item.setItemName(resultSet.getString("ITEM_NAME"));
                    item.setItemRate(resultSet.getDouble("ITEM_RATE"));
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
        return item;
    }

}
