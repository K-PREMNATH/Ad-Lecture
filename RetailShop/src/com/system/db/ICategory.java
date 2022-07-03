/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.db;

import com.system.model.CategoryModel;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface ICategory {

    /*Insert new category*/
    public boolean insertCategory(String categoryName, String categoryDescription);

    /*update category*/
    public boolean updateCategory(int categoryId, String categoryName, String categoryDescription);

    /*delete category*/
    public boolean deleteCategory(int categoryId);

    /*get a specific category*/
    public CategoryModel getCategory(int categoryId);

    /*get all category for display in table*/
    public List<CategoryModel> getAllCategory();
}
