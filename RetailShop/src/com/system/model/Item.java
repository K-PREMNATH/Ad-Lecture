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
public class Item {

    private int itemId;
    private String itemName;
    private String itemDesc;
    private double itemRate;
    private int specifyCode;
    private int categoryId;
    private String categoryName;

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
     * @return the itemDesc
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * @param itemDesc the itemDesc to set
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    /**
     * @return the specifyCode
     */
    public int getSpecifyCode() {
        return specifyCode;
    }

    /**
     * @param specifyCode the specifyCode to set
     */
    public void setSpecifyCode(int specifyCode) {
        this.specifyCode = specifyCode;
    }

    /**
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
