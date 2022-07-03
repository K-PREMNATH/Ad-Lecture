/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.db;

import com.system.model.CategoryModel;
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
public class CategoryDB extends DBConnection implements ICategory {

    @Override
    public boolean insertCategory(String categoryName, String categoryDescription) {
        Connection connection = null;
        Statement statement = null;
        boolean flag = false;
        try {
            String query = "INSERT INTO CATEGORY(CATEGORY_NAME, CATEGORY_DESC) VALUES ('" + categoryName + "','" + categoryDescription + "');";
            connection = this.db_connect();
            statement = connection.createStatement();
            statement.executeUpdate(query);
            flag = true;
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
        return flag;
    }

    @Override
    public boolean updateCategory(int categoryId, String categoryName, String categoryDescription) {
        Connection connection = null;
        Statement statement = null;
        boolean flag = false;
        try {
            String query = "update category set CATEGORY_NAME = '" + categoryName + "',CATEGORY_DESC = '" + categoryDescription + "' where CATEGORY_ID = '" + categoryId + "';";
            connection = this.db_connect();
            statement = connection.createStatement();
            statement.executeUpdate(query);
            flag = true;
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
        return flag;
    }

    @Override
    public boolean deleteCategory(int categoryId) {
        Connection connection = null;
        Statement statement = null;
        boolean flag = false;
        try {
            String query = "delete from category where CATEGORY_ID = '" + categoryId + "';";
            connection = this.db_connect();
            statement = connection.createStatement();
            statement.executeUpdate(query);
            flag = true;
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
        return flag;
    }

    @Override
    public CategoryModel getCategory(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CategoryModel> getAllCategory() {
        Connection connection = null;
        Statement statement = null;
        List<CategoryModel> list = null;
        try {
            String query = "SELECT * FROM CATEGORY order by CATEGORY_ID desc;";
            connection = this.db_connect();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet != null) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    CategoryModel model = new CategoryModel();
                    model.setCategoryId(resultSet.getInt("CATEGORY_ID"));
                    model.setCategoryName(resultSet.getString("CATEGORY_NAME"));
                    model.setCategoryDesc(resultSet.getString("CATEGORY_DESC"));

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
