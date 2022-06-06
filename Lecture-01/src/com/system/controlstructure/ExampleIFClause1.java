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
public class ExampleIFClause1 {

    public static void main(String[] args) {

        /*case 1  : Simple IF Clause*/
        if (true) {
            System.out.println("Simple IF Clause");
        }

        /*case 2  : Simple IF ELSE Clause*/
        if (true) {
            System.out.println("IF");
        } else {
            System.out.println("ELSE");
        }

        /*case 3  : Multiple IF ELSE IF Clause*/
        if (true) {
            System.out.println("IF");
        } else if (true) {
            System.out.println("ELSE-IF");
        } else if (true) {
            System.out.println("ELSE-IF");
        } else {
            System.out.println("ELSE");
        }

    }
}
