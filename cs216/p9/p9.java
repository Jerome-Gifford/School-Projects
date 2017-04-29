// p9.java 
//*********************************************************************************************
// YOUR NAME: Jerome Gifford
//
// COURSE TITLE: Computer Programming II
//
// COURSE NUMBER: CS216
//
// PROF NAME: Moe Bidgoli
//
// ASSIGNMENT NUMBER: #9
//
// DUE DATE:
//
// POSSIBLE POINTS: 10 Points
//
//PURPOSE: create a student record and determine their grade and what kind of recomendation they get.
//*********************************************************************************************

import java.io.*;
import java.util.*;

public class p9 {
	
	// ~~~~~ 3PIO Comments for Client side code ~~~~~//
		//Purpose: read in files with student information, call methods to perform task on information, 
		// and results are given.
		//Input: none.
		//Pre Condition: program compiles.
		//Output:  none.
		//Post Condition: results are displayed. 
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
    public static void main(String[] args) {
			Scanner inFile = new Scanner(System.in);
			int validCounter = 0;
			int invalidCounter = 0;
			
			printHeader();
			
			while(inFile.hasNext())
			{
			   Student st = new Student(); //create student object
			   st.getDataFromFile(inFile); //call getDataFromFile method to grab the data from the input file.
			   if(st.isValid()){ // call isDataValid method to determine if data is valid. Then print.
					st.getGrade();
					st.printData();
					validCounter ++;
					RecStudent rc = new RecStudent(st.getId(), st.getExam());
					rc.printHowToRecommand();
			   }
			   else{
				   st.printInvalidData();
				   invalidCounter ++;
			   }

			} // end of loop
			
			System.out.println("Num of valid data: " + validCounter);
			System.out.println("Num of invalid data: " + invalidCounter);
			
	} //end of main
	
	public static void printHeader(){
		System.out.printf("%10s %4s %5s\n", "student ID", "Exam", "Grade");
		System.out.printf("%10s %4s %5s\n", "----------", "----", "-----");
	}
}