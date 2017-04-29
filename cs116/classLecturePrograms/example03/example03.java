/* filename: example03.java
	author: Jerome Gifford, Cs 116, t/th
	purpose: Demonstrate Concepts in Chapter 4
*/

import java.util.*;

public class example03{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		//-- Math Functions --//
		System.out.println("---- Radians ----");
		System.out.println("PI: " + Math.PI);
		System.out.println("Cosine of 180 degrees (PI):" + Math.cos(Math.PI));
		System.out.println("Sin of 180 degrees (PI) = " + Math.sin(Math.PI));
		System.out.println("Cosine of 90 degrees (PI/2):" + Math.cos(Math.PI / 2));
		
		System.out.println("");
		
		System.out.println("---- Degrees ----");
		System.out.println("PI: " + Math.toDegrees(Math.PI));
		System.out.println("Cosine of 180 degrees (PI):" + Math.toDegrees(Math.cos(Math.PI)));
		System.out.println("Sin of 180 degrees (PI) = " + Math.toDegrees(Math.sin(Math.PI)));
		System.out.println("Cosine of 90 degrees (PI/2):" + Math.toDegrees(Math.cos(Math.PI / 2)));
		
		System.out.println("");
		
		
		System.out.println("---- Rounding ----");
		System.out.println("Cosine of 180 degrees (PI):" + Math.cos(Math.PI));
		System.out.println("Sin of 180 degrees (PI) = " + Math.round(Math.sin(Math.PI)));
		System.out.println("Cosine of 90 degrees (PI/2):" + Math.rint(Math.cos(Math.PI / 2)));
		
		System.out.println("");
		
		/*
		//-- Distance Formula Program --//
		System.out.println("---- Distance Formula ----");
		//working variables
		double x1, x2, y1, y2;
		double distance; 
		
		//get points
		System.out.println("Enter x1: ");
		x1 = sc.nextDouble();
		System.out.println("Enter y1: ");
		y1 = sc.nextDouble();
		System.out.println("Enter x2: ");
		x2 = sc.nextDouble();
		System.out.println("Enter y2: ");
		y2 = sc.nextDouble();
		
		//calc distance
		distance = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
		
		//output distance
		System.out.println("Distance Between Points: " + distance + " units");
		
		System.out.println("");
		*/
		
		//-- Dice Rolling Program --//
		System.out.println("---- Dice Roll ----");
		int dice1, dice2;
		
		dice1  = (int) Math.floor(1 + Math.random() * 6);
		dice2 = (int) Math.floor(1 + Math.random() * 6);
		
		System.out.println("Dice 1 : " + dice1);
		System.out.println("Dice 2 : " + dice2);
		
		System.out.println("");
		
		//-- Angle Calculator --//
		System.out.println("---- Angle Calculator ----");
		//working variables
		double x1, x2, y1, y2, x3, y3; //points
		double a, b, c; //distances between points
		double A, B, C; //angles
		
		//get points
		System.out.println("Enter x1: ");
		x1 = sc.nextDouble();
		System.out.println("Enter y1: ");
		y1 = sc.nextDouble();
		System.out.println("Enter x2: ");
		x2 = sc.nextDouble();
		System.out.println("Enter y2: ");
		y2 = sc.nextDouble();
		System.out.println("Enter x3: ");
		x3 = sc.nextDouble();
		System.out.println("Enter y3: ");
		y3 = sc.nextDouble();
		
		//calc distance
		a = Math.sqrt(Math.pow((x2 - x3),2) + Math.pow((y2 - y3),2));
		b = Math.sqrt(Math.pow((x1 - x3),2) + Math.pow((y1 - y3),2));
		c = Math.sqrt(Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2));
		
		//calc angles
		A = Math.acos((a * a - b * b - c * c) / (-2 * b * c));
		B = Math.acos((b * b - a * a - c * c) / (-2 * a * c));
		C = Math.acos((c * c - b * b - a * a) / (-2 * a * b));
		
		//output angles in radians
		System.out.println("---- Angles in Radians ----");
		System.out.println("Angle A: " + A);
		System.out.println("Angle B: " + B);
		System.out.println("Angle C: " + C);
		
		System.out.println("");
		
		//output angles in degrees
		System.out.println("---- Angles in Degrees ----");
		System.out.println("Angle A: " + Math.round(Math.toDegrees(A)));
		System.out.println("Angle B: " + Math.round(Math.toDegrees(B)));
		System.out.println("Angle C: " + Math.round(Math.toDegrees(C)));
		
		System.out.println("");
	}
}