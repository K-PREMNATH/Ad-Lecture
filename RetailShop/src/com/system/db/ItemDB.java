/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.db;

import com.system.model.CategoryDropDown;
import com.system.model.InsertUpdateItemRes;
import com.system.model.Item;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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

    @Override
    public List<Item> getAllItems() {
        Connection connection = null;
        Statement statement = null;
        List<Item> list = null;
        try {
            String query = "select i.ITEM_ID,i.ITEM_NAME,i.ITEM_DESC,i.ITEM_SPECIFY_CODE,"
                    + "(select ir.ITEM_RATE from item_rate ir where ir.RATE_ITEM_ID = i.ITEM_ID "
                    + "order by ir.RATE_CREATED_DATE desc limit 1) ITEM_RATE,"
                    + " c.CATEGORY_ID,       CATEGORY_NAME from item i    "
                    + " inner join category c on i.ITEM_CATEGORY_ID = c.CATEGORY_ID;";
            connection = this.db_connect();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet != null) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    Item model = new Item();
                    model.setItemId(resultSet.getInt("ITEM_ID"));
                    model.setItemName(resultSet.getString("ITEM_NAME"));
                    model.setItemDesc(resultSet.getString("ITEM_DESC"));
                    model.setSpecifyCode(resultSet.getInt("ITEM_SPECIFY_CODE"));
                    model.setItemRate(resultSet.getInt("ITEM_RATE"));
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

    @Override
    public InsertUpdateItemRes insertUpdateItem(int itemId, String itemName, String itemDesc, int specCode, double price, int catId) {
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet resultSet = null;
        InsertUpdateItemRes response = new InsertUpdateItemRes();
        try {
            connection = this.db_connect();
            String INSERT_UPDATE_ITEM_PROC = "{ call insert_update_item_proc(?,?,?,?,?,?,?,?)}";
            statement = connection.prepareCall(INSERT_UPDATE_ITEM_PROC);
            statement.setInt(1, itemId);
            statement.setString(2, itemName);
            statement.setString(3, itemDesc);
            statement.setInt(4, specCode);
            statement.setInt(5, catId);
            statement.setDouble(6, price);
           
            statement.registerOutParameter(7, Types.BOOLEAN);
            statement.registerOutParameter(8, Types.VARCHAR);
            statement.executeUpdate();
            
            response.setRes(statement.getBoolean(7));
            response.setMessage(statement.getString(8));
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
        return response;
    }

    @Override
    public InsertUpdateItemRes deleteItem(int itemId) {
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet resultSet = null;
        InsertUpdateItemRes response = new InsertUpdateItemRes();
        try {
            connection = this.db_connect();
            String INSERT_UPDATE_ITEM_PROC = "{ call delete_item_proc(?,?,?)}";
            statement = connection.prepareCall(INSERT_UPDATE_ITEM_PROC);
            statement.setInt(1, itemId);           
            statement.registerOutParameter(2, Types.BOOLEAN);
            statement.registerOutParameter(3, Types.VARCHAR);
            statement.executeUpdate();
            
            response.setRes(statement.getBoolean(2));
            response.setMessage(statement.getString(3));
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
        return response;
    }
    
}
