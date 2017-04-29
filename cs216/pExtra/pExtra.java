// pExtra.java 
//*********************************************************************************************
// YOUR NAME: Jerome Gifford
//
// COURSE TITLE: Computer Programming II
//
// COURSE NUMBER: CS216
//
// PROF NAME: Moe Bidgoli
//
// ASSIGNMENT NUMBER: #Extra
//
// DUE DATE: 10-3-16
//
// POSSIBLE POINTS: Extra Points
//
// PURPOSE: generate Rectangles and print out their widths, heights, colors, Areas, and Perimeters. 
// Also print out the largest and smallest Areas
//*********************************************************************************************

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class pExtra {
	
	// ~~~~~ 3PIO Comments for Client side code ~~~~~//
		//Purpose: generate Rectangles and print out their details
		//Input: n/a
		//Pre Condition: the code compiles
		//Output: n/a
		//Post Condition: the Rectangles are printed out as needed.
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	public static void main(String[] args) {
		Scanner inFile = new Scanner(System.in);
		int num = inFile.nextInt();
		// run the code mulitple times based on a give number of times
		while (num > 0){
			
			//create array of objects
			Rectangle[] arr = new Rectangle[10];
			int i = 0;
			final double widthMin = 0.0;
			final double widthMax = 10.0;
			final double heightMin = 10.0;
			final double heightMax = 50.0;
			String color = "";
			double sumArea = 0;
			double sumPerimeter = 0;
			double maxArea = Double.MIN_VALUE;
			double minArea = Double.MAX_VALUE;
			String maxColor = "";
			String minColor = "";
			Random r = new Random();
			DecimalFormat decimalFormat = new DecimalFormat("##.##");
			
			printHeader();
			
			while (i < 10){
				//get random width, height, and color
				double width = Double.valueOf(decimalFormat.format(widthMin + (widthMax - widthMin) * r.nextDouble()));
				double height = Double.valueOf(decimalFormat.format(heightMin + (heightMax - heightMin) * r.nextDouble()));
				if (r.nextDouble() >= .5)
				color = "Red";
				else 
				color = "Yellow";
			
				// fill Rectangle with data
				arr[i] = new Rectangle(width, height, color);
				
				// print the rectangle
				arr[i].printRec(width < height & width > 0);
				
				if (width < height & width > 0){
					//get sums
					sumArea = sumArea + arr[i].getArea();
					sumPerimeter = sumPerimeter + arr[i].getPerimeter();
					
					// get min and max
					if (arr[i].getArea() > maxArea){
						maxArea = arr[i].getArea();
						maxColor = arr[i].getColor();
					}
					else if (arr[i].getArea() < minArea){
						minArea = arr[i].getArea();
						minColor = arr[i].getColor();
					}
				}
				
				i++;
			}
			printSummary(sumArea, sumPerimeter, maxArea, minArea, maxColor, minColor);
			
			num --;
		}
	}
	
	// ~~~~~ 3PIO Comments for printHeader ~~~~~//
		//Purpose: print the header for output
		//Input: n/a
		//Pre Condition: The code complies and the method is called
		//Output: n/a
		//Post Condition: The header is printed
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public static void printHeader(){
		System.out.println("=========================================================================\n" +  "~~~ Rectangle Report ~~~");
		System.out.printf("%5s %6s %6s %9s %7s\n", "Width", "Height", "Color", "Perimeter", "A r e a");
		System.out.printf("%5s %6s %6s %9s %7s\n", "-----", "------", "-----", "---------", "-------");
	}
	
	// ~~~~~ 3PIO Comments for printSummary ~~~~~//
	//Purpose: print the summary for the report
	//Input: double, double, double, double, string, string
	//Pre Condition: the method is called and all data is valid and calculated
	//Output:  n/a
	//Post Condition: Summary is printed out.
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public static void printSummary(double sumArea, double sumPerimeter, double maxArea, double minArea, String maxColor, String minColor){
		DecimalFormat df = new DecimalFormat("##.##");
		System.out.printf("%5s %6s %6s %9s %7s\n", "-----", "------", "-----", "---------", "-------\n");
		System.out.println("\nSum of Area: " + df.format(sumArea) + "\nSum of Perimeter: " + df.format(sumPerimeter));
		System.out.println("\nMax Area: " + maxArea + " " + maxColor + "\nMin Area: " + minArea +  " " + minColor);
		System.out.println("~~~ End Report ~~~" + "\n=========================================================================\n");
	}

}