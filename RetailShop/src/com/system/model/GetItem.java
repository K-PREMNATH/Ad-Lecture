/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.model;

/**
 *
 * @author Acer
 */
public class GetItem {
    private int itemId;
    private String itemName;
    private double itemRate;

    /**
     * @return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemRate
     */
    public double getItemRate() {
        return itemRate;
    }

    /**
     * @param itemRate the itemRate to set
     */
    public void setItemRate(double itemRate) {
        this.itemRate = itemRate;
    }
  
    
}
