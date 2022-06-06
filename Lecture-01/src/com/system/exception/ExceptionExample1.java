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
public class ExceptionExample1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        
        try{
             int c = a/b;/*consider this as rishy code or block of code - exception will occur*/
        }catch(ArithmeticException ae){
            System.out.println("Exception---------------->"+ae.toString());
        }
      
    }
    
}
