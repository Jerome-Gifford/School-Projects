// Exercise1821.java 
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
//PURPOSE: convert a given decimal number to binary
//*********************************************************************************************

import java.io.*;
import java.util.*;

public class Exercise1821 {

    public static void main(String[] args) {
			Scanner inFile = new Scanner(System.in);
			int i = 0;
			while(inFile.hasNext())
			{
				i = inFile.nextInt();
				System.out.print(i + " in Binary: ");
				intToBinary(i);
				System.out.println();
			}

	} //end of main
	
	public static void intToBinary(int num) {
		if (num < 2) {
			System.out.print(num);
			return;
		} else {
			intToBinary(num / 2);
			intToBinary(num % 2);
		}
	}
	
}