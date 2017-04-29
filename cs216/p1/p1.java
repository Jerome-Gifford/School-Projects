// p1.java 
//*********************************************************************************************
// YOUR NAME: Jerome Gifford
//
// COURSE TITLE: Computer Programming II
//
// COURSE NUMBER: CS216
//
// PROF NAME: Moe Bidgoli
//
// ASSIGNMENT NUMBER: #1
//
// DUE DATE: 09-12-2016
//
// POSSIBLE POINTS: 10 Points
//
// PURPOSE: Create a program that reads a file for hrs, mins, and secs. The program then
// 	determines if the data is valid and prints invalid data to a file. Then valid times are printed
//	with desired formatting and and AM/PM/Noon tags to a file. Then the valid times are incremented and displayed 
// 	again with desired formatting and AM/PM/Noon tagas in the output file. Finally, a summary of valid and 
// invalid test are printed at the bottom of the file. 
//
//*********************************************************************************************

import java.io.*;
import java.util.*;

public class p1 {
	
	// ~~~~~ 3PIO Comments for Client side code ~~~~~//
		//Purpose: read in files with times, call methods to perform task on times, 
		// and create output file with results.
		//Input: none.
		//Pre Condition: program compiles.
		//Output:  none.
		//Post Condition: output file is created with results. 
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
    public static void main(String[] args) {
		int numOfValidRd = 0;
		int numOfInvalidRd = 0;

		try
		{
			File inputFile = new File(args[0]); // for submittobidgolij
			Scanner inFile = new Scanner(inputFile);
			PrintWriter outFile = new PrintWriter(args[1]); //for submitobidgolij
			
			//~~~~~~~~~~~~  Scanner inFile = new Scanner(System.in); ~~~~~~~~~~~~~~~~~~~~~~NEW LINE FOR INPUT WITH SUMBITJ


			printHeader(outFile);
			Time noonTime = new Time(12, 0, 0);

			while(inFile.hasNextLine())
			{
			   Time time = new Time(); //create time object
			   time.getDataFromFile(inFile); //call getDataFromFile method to grab the data from the input file.
			   if(time.isDataValid()){ // call isDataValid method to determine if data is valid. Then print.
				   time.printTime(outFile);
				   time.addAMPM(outFile, time, noonTime);
				   time.increment();
				   time.printTime(outFile);
				   time.addAMPM(outFile, time, noonTime);
				   numOfValidRd ++;
			   }
			   else{
				   time.printInvalidData(outFile);
				   numOfInvalidRd ++;
			   }

			} // end of loop

			// print invaild/valid data summary.
			outFile.printf("\n%-29s %-2d\n", "The number of invalid rd(s): ", numOfInvalidRd);
			outFile.printf("%-27s %-2d\n", "The number of valid rd(s): ", numOfValidRd);
			outFile.printf("\n<* End Of Report *>\n");

			inFile.close();
			outFile.close();
		} // end of try

		catch (FileNotFoundException e)
		{
			System.out.println("File not found!");
			System.exit(1);
		}
	} //end of main

	// ~~~~~ 3PIO Comments for Client side code ~~~~~//
		//Purpose: print out the title to the output file.
		//Input: Scanner output file object.
		//Pre Condition: Scanner output file object is created. File is open for
		// writing. 
		//Output:  none.
		//Post Condition: The title is printed to the output file. 
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	public static void printHeader(PrintWriter outFile){
		outFile.println("~~~ Time Report ~~~");
	}

}