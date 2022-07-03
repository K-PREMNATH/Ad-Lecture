/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class StudentImpl {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            Scanner s = new Scanner(System.in);
            Student student = new Student();
            System.out.println("Name :");
            student.setName(s.next());
            
            System.out.println("Roll-Number :");
            student.setRoll_number(s.next());
            
            System.out.println("Mark :");
            student.setMark(s.nextInt());
            list.add(student);
        }
        
        for (Student student : list) {
            System.out.println(student.getName()+" - "+student.getRoll_number());
        }
        
    }
}
