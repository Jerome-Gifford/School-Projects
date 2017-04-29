// Exercise1811.java 
//*********************************************************************************************
// YOUR NAME: Jerome Gifford
//
// COURSE TITLE: Computer Programming II
//
// COURSE NUMBER: CS216
//
// PROF NAME: Moe Bidgoli
//
// ASSIGNMENT NUMBER: #10
//
// DUE DATE:
//
// POSSIBLE POINTS: 10 Points
//
//PURPOSE: Sum the digits of a given number
//*********************************************************************************************

import java.io.*;
import java.util.*;

public class Exercise1811 {
	
    public static void main(String[] args) {
			Scanner inFile = new Scanner(System.in);
			int num = 0;
			while(inFile.hasNext())
			{
				num = inFile.nextInt();
				num = getSum(num);
				System.out.println(num);
			}

	} //end of main
	
	public static int getSum(int n) {
		return n == 0 ? 0 : n % 10 + getSum(n/10);
	}
}