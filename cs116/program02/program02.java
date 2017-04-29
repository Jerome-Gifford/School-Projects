//filename: program01.java
//author: Jerome Gifford, cs 116, t/th
//based on Problem 1.11 from the textbook

import java.util.*; //imports the java library.

public class program02{
	public static void main(String[] args){
	
	//-- Ask the user for the a savings amount --//
	System.out.print("Enter a Savings Amount: ");
	Scanner sc = new Scanner(System.in);
	double savingsAmount = sc.nextDouble();
	
	//-- Decalre Variables --//
	double monthlyInterestRate = (1 + (0.05/12)); //interest compounded montly
	double value = 0; //starts the initial value of the account at 0. will be used as a counter
	double accountBalance = 0; //declare a variable for output later.
	
	//-- Leading Outputs --//
	System.out.println("");
	System.out.println("//--- Account Balance ---//");
	System.out.println("");
	
	//-- First Month --//
	accountBalance = savingsAmount * monthlyInterestRate;
	System.out.println("Month 1: " + (float)accountBalance);
	
	//-- Second Month--//
	accountBalance += savingsAmount; //adds monthly savings 
	accountBalance *= monthlyInterestRate;
	System.out.println("Month 2: " + (float)accountBalance);
	
	//-- Third Month--//
	accountBalance += savingsAmount; //adds monthly savings 
	accountBalance *= monthlyInterestRate;
	System.out.println("Month 3: " + (float)accountBalance);
	
	//-- Fourth Month--//
	accountBalance += savingsAmount; //adds monthly savings 
	accountBalance *= monthlyInterestRate;
	System.out.println("Month 4: " + (float)accountBalance);
	
	//-- Fifth Month--//
	accountBalance += savingsAmount; //adds monthly savings 
	accountBalance *= monthlyInterestRate;
	System.out.println("Month 5: " + (float)accountBalance);
	
	//-- Sixth Month--//
	accountBalance += savingsAmount; //adds monthly savings 
	accountBalance *= monthlyInterestRate;
	System.out.println("Month 6: " + (float)accountBalance);
	}
}