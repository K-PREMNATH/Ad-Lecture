/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.db;

import com.system.model.CategoryDropDown;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface IItem {
    
    public List<CategoryDropDown> getCategoryForDropdown();
      
}
