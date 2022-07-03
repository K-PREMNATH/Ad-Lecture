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
public interface ISale {
    public String getItemName(int itemId);
    public double getItemSubTotal(int itemId,int qty);
    public double getItemStockQty(int itemId);
    public double calcualteGrandTotal();
    public void cancelTransaction(int transactionId);
}
