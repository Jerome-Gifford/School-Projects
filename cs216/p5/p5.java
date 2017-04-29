// p5.java 
//*********************************************************************************************
// YOUR NAME: Jerome Gifford
//
// COURSE TITLE: Computer Programming II
//
// COURSE NUMBER: CS216
//
// PROF NAME: Moe Bidgoli
//
// ASSIGNMENT NUMBER: #3
//
// DUE DATE: 10-10-2016
//
// POSSIBLE POINTS: 10 Points
//
// PURPOSE: Determine the Area, Perimeter, and Type of a triangle based on the sides given.  
// Display this information as well as triangle color and filled status for desired output.
//*********************************************************************************************

import java.io.*;
import java.util.*;

public class p5 {
	
	// ~~~~~ 3PIO Comments for Client side code ~~~~~//
		//Purpose: Determine the Area, Perimeter, and Type of a Triangle based on input given
		//Input: n/a
		//Pre Condition: file complies
		//Output: n/a
		//Post Condition:  The Area, Perimeter, and Type are printed to the screen with desired formatting
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
    public static void main(String[] args) {
		Scanner inFile = new Scanner(System.in);
		String type = "";
		
		printHeader();
		
		while (inFile.hasNext()){
			Triangle tr = new Triangle(inFile.nextInt(), inFile.nextInt(), inFile.nextInt());
			tr.setColor(inFile.next());
			if (inFile.next().equals("T"))
			tr.setFilled(true);
			else
			tr.setFilled(false);
	
			if (tr.getSide1() > 0 && tr.getSide2() > 0 && tr.getSide3() > 0){
				if (istr(tr.getSide1(), tr.getSide2(), tr.getSide3())){
					type = trType(tr.getSide1(), tr.getSide2(), tr.getSide3());
					printSummary(tr.getSide1(), tr.getSide2(), tr.getSide3(), 
						type, tr.getPerimeter(), tr.getArea(), tr.getColor(), tr.isFilled());
				}
				else{
					type = "It cannot be a triangle";
					printNontr(tr.getSide1(), tr.getSide2(), tr.getSide3(), type, tr.getColor(), tr.isFilled());
				}
			}
			else{
				type = "*** Invalid Data";
				printNontr(tr.getSide1(), tr.getSide2(), tr.getSide3(), type, tr.getColor(), tr.isFilled());
			}
		}
		
		printEnd();
	}
	
	// ~~~~~ 3PIO Comments for printHeader ~~~~~//
	//Purpose: print the header for the output
	//Input:  n/a
	//Pre Condition: the file complies
	//Output: n/a
	//Post Condition: The desired header for the report is printed
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public static void printHeader(){
		System.out.println("<~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(  Triangle Report  )~~~~~~~~~~~~~~~~~~~~~~~~~~~>");
		System.out.printf("%5s %5s %5s %-24s %9s %-6s %6s %6s\n", "Side1", "Side2", "Side3", "Type of Triangle", "Perimeter", "Area", "Color", "Filled");
		System.out.printf("%5s %5s %5s %-24s %9s %-6s %6s %6s\n", "-----", "-----", "-----", "----------------", "---------", "----", "-----", "------");
	}
	
	// ~~~~~ 3PIO Comments for printEnd ~~~~~//
	//Purpose: print the end for the output
	//Input: n/a
	//Pre Condition: the file complies
	//Output: n/a
	//Post Condition: The desired end for the report is printed
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public static void printEnd(){
		System.out.println(">>>* End Of Report *<<<");
	}
	
	// ~~~~~ 3PIO Comments for istr ~~~~~//
	//Purpose:  Determine if the given sides are valid
	//Input: int, int , int
	//Pre Condition: the sides of the triangle are set
	//Output: boolean
	//Post Condition: The sides are determined to be valid or invaild and returned
	//Note:
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public static boolean istr(int side1, int side2, int side3){
		if ((side1 + side2 > side3) && (side2 + side3 > side1) && (side1 + side3 > side2))
			return true;
		else
			return false;
	}
	
	// ~~~~~ 3PIO Comments for trType ~~~~~//
	//Purpose:  Determine what type of triangle the sides form
	//Input:  int, int, int
	//Pre Condition: the sides are set and they are valid
	//Output: String
	//Post Condition: The type of trinagle the sides form is returned
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public static String trType(int side1, int side2, int side3){
		if (side1 != side2 && side2 != side3 && side1 != side3){
			//tr is Scalene
			return "Scalene";
		}
		else if(side1 == side2 && side2 == side3){
			//tr is Equilateral
			return "Equilateral";
		}
		else{
			//tr is Isosceles
			return "Isosceles";
		}
	}
	
	// ~~~~~ 3PIO Comments for printSummary ~~~~~//
	//Purpose:  print the summary for the report
	//Input: int, int, int, String, int, double, String, boolean
	//Pre Condition: All data is valid
	//Output: n/a
	//Post Condition: The summary for the report is printed
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public static void printSummary(int side1, int side2, int side3, String type, int perimeter, double area, String color, boolean isFilled){
		String filled = "";
		if (isFilled)
			filled = "True";
		else
			filled = "False";
		
		System.out.printf("%-5d %-5d %-5d %-24s %-9d %.4f %-6s %-6s\n", side1, side2, side3, type, perimeter, area, color, filled);
		
	}
	
	// ~~~~~ 3PIO Comments for printNontr ~~~~~//
	//Purpose: print the invaild for the report
	//Input:  int, int, int, String, String, boolean
	//Pre Condition: data is determined to be invalid
	//Output: n/a
	//Post Condition: The invalid data for the report is printed
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public static void printNontr(int side1, int side2, int side3, String type, String color, boolean isFilled){
		String filled = "";
		if (isFilled)
			filled = "True";
		else
			filled = "False";
		System.out.printf("%-5d %-5d %-5d %-24s                  %-6s %-6s\n", side1, side2, side3, type, color, filled);
	}
}

