/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class ExceptionExample2 {

    public static void main(String[] args) {
        try {
            /*Absoulte path provided*/
            //File myObj = new File("D:\\GitHub\\AdvancedProgramming\\Lecture-01\\src\\com\\system\\exception\\Sample.txt");
            File myObj = new File("\\Sample.txt");/*This will give the error*/
            /*If file path wrong or file not exists in that location then this code part will error out*/
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred----------------------->"+e.toString());
            /*printStackTrace() will pinpoint the exact line in which the method raised the exception.*/
            e.printStackTrace();
        }

    }
}
