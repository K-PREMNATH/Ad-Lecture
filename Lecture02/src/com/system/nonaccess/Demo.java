/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.nonaccess;

/**
 *
 * @author Acer
 */
public class Demo {
    public static void main(String[] args) {
        StaticDemo obj = new StaticDemo();
        /*for instance variables you have to create an object and access the property*/
        System.out.println("Age : "+obj.age);
        /*for static variables you can access using class reference*/
        System.out.println("Count : "+StaticDemo.count);
        StaticDemo.m1();
    }
    
}
