// p4.java 
//*********************************************************************************************
// YOUR NAME: Jerome Gifford
//
// COURSE TITLE: Computer Programming II
//
// COURSE NUMBER: CS216
//
// PROF NAME: Moe Bidgoli
//
// ASSIGNMENT NUMBER: #4
//
// DUE DATE: 10-3-16
//
// POSSIBLE POINTS: 10 Points
//
// PURPOSE: A string is read in from a file and manipulated in various ways, including getting its Length
// 1st and last char, converting it to upper case, replacing and adding substrings, getting the word count of the string, 
// and reversing the string.
//
//*********************************************************************************************

import java.io.*;
import java.util.*;
import java.lang.*;

public class p4 {

	// ~~~~~ 3PIO Comments for Client side code ~~~~~//
		//Purpose: print out modifications to a string
		//Input: n/a
		//Pre Condition: the code compiles
		//Output: n/a
		//Post Condition: the manipulated strings are printed out as needed.
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	public static void main(String[] args) {
		Scanner inFile = new Scanner(System.in);
		String statement = "";
		
		while (inFile.hasNextLine()){
			if (statement.equals(""))
				statement = inFile.nextLine() + "\n";
			else
			statement = statement + inFile.nextLine() + "\n";
		}
			System.out.print(statement);
			ManipulateString modify = new ManipulateString(statement);
			System.out.println("Length: " + modify.getLength());
			System.out.println("1st Char: " + modify.getFirstChar());
			System.out.println("Last Char: " + modify.getLastChar());
			System.out.println(modify.getUpperString());
			modify.addToString();
			modify.replaceString();
			modify.removeNewLine();
			System.out.println(modify.getString());
			System.out.println("Last Index of SVSU: " + modify.getLastIndexOfUniversity());
			System.out.println("Word Count: " + modify.wordCount());
			modify.reverseString();
			System.out.println("Reverse: " + modify.getString());
			System.out.println("Length: " + modify.getLength());
	 
	}
}
	
