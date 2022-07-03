/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.inheritance;

/**
 *
 * @author Acer
 */
public class B extends A{
    int x = 10;
    public String p(){
        return "My Features";
    }
    
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.age);
        b.m();
        
        System.out.println(b.x);
        String y = b.p();
        System.out.println(y);
        
        /**/
        A obj = new B();
    }
}
