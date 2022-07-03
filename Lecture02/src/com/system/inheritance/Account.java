package com.system.inheritance;

/**
 *
 * @author Acer
 */
public class Account {
    private double balance;//data hiding

    public double getBalance() {
        // validation -  whhether that person is the right person
        return balance;
    }

    /*change my balance - withdraw/ deposit - update amount*/
    public void setBalance(double bal) {
        // validation -  whhether that person is the right person
        this.balance = bal;
    }
    
    
}
