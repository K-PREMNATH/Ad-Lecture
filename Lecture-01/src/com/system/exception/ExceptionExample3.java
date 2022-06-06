/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.exception;

/**
 *
 * @author Acer
 */
public class ExceptionExample3 {
    int x = 20;

    public static void main(String[] args) {

        try {
            ExceptionExample3 se = new ExceptionExample3();
            se.calculateValue();
        } catch (Exception ex) {
            System.out.println("Exception---------->"+ex.toString());
        }
        
    }

    public void calculateValue() throws ArithmeticException, NullPointerException {
        ExceptionExample3 se = null;
        int a = 5, b = 0;
        if(b == 0){
            throw new ArithmeticException();
        }
        int c = a/b;
        if(se == null){
            throw new NullPointerException();
        }
        System.out.println(se.x);
    }
}
