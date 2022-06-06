/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.controlstructure;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class StudentGrade {

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter your Mark : ");
            int mark = input.nextInt();

            StudentGrade studentGradeObj = new StudentGrade();
            String result = studentGradeObj.getGradeByMark(mark);
            System.out.println("result : " + result);
        } catch (InputMismatchException exception) {
            System.out.println("Invalid Input...!");
        }
    }

    public String getGradeByMark(int mark) {
        String grade = "";
        if (mark >= 75) {
            grade = "A";
        } else if (mark >= 50 && mark < 75) {
            grade = "B";
        } else if (mark >= 25 && mark < 50) {
            grade = "C";
        } else if (mark < 25) {
            grade = "F";
        }
        return grade;
    }
}
