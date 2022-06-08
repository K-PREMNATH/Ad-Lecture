/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.controlstructure;

/**
 *
 * @author Acer
 */
public class ExampleSwitch2 {

    public static void main(String[] args) {
        String str = "Prem";
        switch (str) {
            case "Prem":
                System.out.println("Number-1");
                break;
            case "Siva":
                System.out.println("Number-2");
                break;
            case "Kumar":
                System.out.println("Number-3");
                break;
            default:
                System.out.println("Default");
        }
    }
}
