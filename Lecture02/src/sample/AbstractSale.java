/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

/**
 *
 * @author Acer
 */
public abstract class AbstractSale implements ISale{

    @Override
    public String getItemName(int itemId) {
        return "Hi";
    }

    @Override
    public double getItemSubTotal(int itemId, int qty) {
        return 350.98;
    }

    @Override
    public double getItemStockQty(int itemId) {
        return 1.5;       
    }  
    
}
