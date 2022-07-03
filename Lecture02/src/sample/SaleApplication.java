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
public class SaleApplication extends AbstractSale{

    @Override
    public double calcualteGrandTotal() {
        return 3459;
    }

    @Override
    public void cancelTransaction(int transactionId) {
        System.out.println("camcelled");
    }
    
    public static void main(String[] args) {
        SaleApplication sa = new SaleApplication();
        System.out.println(sa.getItemName(0));
        System.out.println(sa.getItemSubTotal(0, 0));
        System.out.println(sa.getItemStockQty(0));
        System.out.println(sa.calcualteGrandTotal());
        
    }

    
   
}
