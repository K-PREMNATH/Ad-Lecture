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
public class Demo extends AbstractSale {

    @Override
    public double calcualteGrandTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelTransaction(int transactionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getItemName(int itemId) {
        System.out.println("dfjusdhu");
        return "1 - Hi";
    }
    
    public static void main(String[] args) {
        Demo d = new Demo();
        String name = d.getItemName(1);
        System.out.println(name);
    }

}
