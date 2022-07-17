/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.db;


import com.system.model.CategoryDropDown;
import com.system.model.InsertUpdateItemRes;
import com.system.model.Item;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface IItem {
     /*get all category for display in dropdrown*/
    public List<CategoryDropDown> getCategoryForDropdown();
    /*get all item for display in table*/
    public List<Item> getAllItems();
    
    /*Insert / Update new category*/
    public InsertUpdateItemRes insertUpdateItem(int itemId,String itemName,String itemDesc,int specCode, double price,int catId);
    
    /*delete Item*/
    public InsertUpdateItemRes deleteItem(int itemId);
      
}
