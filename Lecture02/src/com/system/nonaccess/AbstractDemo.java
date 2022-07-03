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
public class AbstractDemo {
    /*
    Abstract Modifier

Abstract - We can use with Method, class


1. What is the need of abstract modifier?
2. What is the meaning of abstract?
3. Where you can apply? - Method, Class

Abstract-Method
public class Vehicle{
	public int getNumberOfWeel(){
		return something;-- if we dont know the implementation
	}
	public abstract int getNumberOfWeel(); - only declaration no implementation
}

---> we have several vehicles but 

public class Fruit{
	public abstract String getTaste();
}

--------------------
Programing example
I want to implement of Loan
What is the interest of loan

public class Loan{
	public double getInterest(){
	
	}
}
depend on loan type -> Personal / Housing / professional

the method which has only declaration - child class are responsible for implementation.
Which one valid?

1.public abstract void m1(){} - method declaration as abstract so cannot have body
2. public void m1(); - Invalid missing of abstract
3. public abstract void m1(); -  void
4. public void m1(){}--valid



Abstract-Class (Not complete class/ partially implemented class/-)
abstract public Test{
	public abstract void m1();
	
}

if class implemented as abstract means its not complete info /  no proper implementation
You cant create obj for abstract class

public class Vehicle{
	public int getNumberOfWeel(){
		return something;-- if we dont know the implementation
	}
	public abstract int getNumberOfWeel(); - only declaration no implementation
}


     */
}
