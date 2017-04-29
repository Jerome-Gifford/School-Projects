// Exercise1809.java 
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
//PURPOSE: Print the reverse of a given string
//*********************************************************************************************

import java.io.*;
import java.util.*;

public class Exercise1809 {
	
    public static void main(String[] args) {
			Scanner inFile = new Scanner(System.in);
			String str = "";
			while(inFile.hasNext())
			{
				str = inFile.next();
				str = reverse(str);
				System.out.println(str);
			}

	} //end of main
	
	public static String reverse(String str) {
		if ((null == str) || (str.length() <= 1)) {
			return str;
		}
		return reverse(str.substring(1)) + str.charAt(0);
	}
}