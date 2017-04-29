// Test.java 
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


// ~~~~~ 3PIO Comments for Time class ~~~~~//
	//Purpose: create a Time object when asked to do so with the given input and
		//return the called outputs. 
	//Input: Various. Depends on what constructor/method is being called. For more detail
		//read the 3PIO comments for the called constructor/method
	//Pre Condition: data is in a file.
	//Output: Various. Depends on what constructor/method is being called. For more detail
		//read the 3PIO comments for the called constructor/method
	//Post Condition: a valid output(s)/object is returned/created, depended upon what was called.
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
public class Time {
	
	public static final int LOWSEC = 0; //lower bound for seconds
	public static final int HIGHSEC = 59; //upper bound for seconds
	public static final int LOWMIN = 0; //lower bound for minutes
	public static final int HIGHMIN = 59; //upper bound for minutes
	public static final int LOWHR = 0; //lower bound for hours
	public static final int HIGHHR = 23; //upper bound for hours
	private int hr; //will handle the hours for the given time.
	private int min; //will handle the minutes for the given time.
	private int sec; //will handle the seconds for the given time.

	// ~~~~~ 3PIO Comments for no args constructor Time ~~~~~//
		//Purpose: initialize the hrs, mins, and seconds for calculations later  
		//Input: None.
		//Pre Condition: The constructor is called
		//Output: None.
		//Post Condition: hr, min, and secs are initalized to 0.
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public Time()
	{
		hr  = 0;
		min = 0;
		sec = 0;
	}
  
	// ~~~~~ 3PIO Comments for three args constructor Time ~~~~~//
		//Purpose:  initialize the hrs, mins, and seconds for calculations later.
		//Input: hrs, mins, secs, as an int.
		//Pre Condition: The constructor is called and data is provided.
		//Output: None.
		//Post Condition: hr, min, and secs are initalized to the given values for each.
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	public Time (int hrInput, int minInput, int secInput)
	{
	 hr = hrInput;
	 min = minInput; 
	 sec = secInput;
	}

		// ~~~~~ 3PIO Comments for getDataFromFile method ~~~~~//
		//Purpose:  get the hrs, mins, and seconds for calculations later
		//Input: Scanner inFile object
		//Pre Condition: Time object is created and method is called. 
		// Scanner inFile object is declared and a data file exists.
		//Output: none.
		//Post Condition: hr, min, and secs are initalized to the give values for each.
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void getDataFromFile(Scanner inFile)
	{
		hr  = inFile.nextInt();
		min = inFile.nextInt();
		sec = inFile.nextInt();
		inFile.nextLine();
	}

	// ~~~~~ 3PIO Comments for isDataValid method ~~~~~//
		//Purpose:  Test the input data and verify that it is valid
		//Input: none.
		//Pre Condition: Time object is created and method is called
		//Output: true/false is returned based on whether or not the data is within
		//the desired range
		//Post Condition: data is determined to be valid or invalid for sorting later.
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public boolean isDataValid ()
	{
		
		return (sec >= LOWSEC && sec <= HIGHSEC &&
			min >= LOWMIN && min <= HIGHSEC &&
			hr >= LOWHR && hr <= HIGHHR);
			
	}
  
	// ~~~~~ 3PIO Comments for printInvalidData method ~~~~~//
		//Purpose:  print ot the invaild data to the file
		//Input: a Scanner Outfile object
		//Pre Condition: Time object is created and method is called. A Scanner 
		//outfile object must be created and a new file must be open for writing to.
		//Output: none.
		//Post Condition: The invalid data line is printed into the output file.
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void printInvalidData(PrintWriter outFile)
	{
		outFile.printf("%-4s %-2d %4s %-2d %-3s %-2d %-20s\n", "hr:", hr, "min:", min, "sec:", sec,
					"--->Invalid Data!");
	}

	// ~~~~~ 3PIO Comments for setTime method ~~~~~//
		//Purpose:  change the hr, min, and secs for the Time class
		//Input: an hr, min, and sec integer
		//Pre Condition: Time object is created and method is called. hr, min, and
		// sec fields are created and passed in. 
		//Output: none.
		//Post Condition: the hr, min, and sec data fields in this class
		// are set to the new data.
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void setTime( int inHr, int inMin, int inSec)
	{
		hr = inHr;
		min = inMin; 
		sec = inSec;
	}

	// ~~~~~ 3PIO Comments for increment method ~~~~~//
		//Purpose:  increase the time.
		//Input: none.
		//Pre Condition: Time object is created and method is called. 
		// hr, min, sec is vaild and min and max ranges for each are defined.
		//Output: none.
		//Post Condition: the hr, min, sec are increment accordingly to add 
		// one second to the time.
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void increment()
	{
		if (sec == HIGHSEC){
			sec = 0;
			min ++;
			if (min > HIGHMIN){
				min = 0; 
				hr ++;
				if (hr > HIGHHR){
					hr = 0;
				}
			}
		}
		else
			sec ++;
		
	}
	
    
	// ~~~~~ 3PIO Comments for LessThan method ~~~~~//
		//Purpose:  determine if the given time is earlier than noon.
		//Input:  the current time.
		//Pre Condition: Time object is created and method is called. Given time is passed
		// and the data is valid.
		//Output:  true/false based on whether or not the time is earlier than noon.
		//Post Condition: time is determined to be earlier than noon or not.
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public boolean LessThan(Time otherTime)
	{
		return (hr < otherTime.hr ||
				hr == otherTime.hr && min < otherTime.min ||
				hr == otherTime.hr && min == otherTime.min && sec < otherTime.sec);
	}
	
	// ~~~~~ 3PIO Comments for Equal method ~~~~~//
		//Purpose:  determine if the given time is noon.
		//Input:  the current time.
		//Pre Condition: Time object is created and method is called. Given time is passed
		// and the data is valid.
		//Output:  true/false based on whether or not the time is noon.
		//Post Condition: time is determined to be noon or not.
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public boolean Equal (Time otherTime)
	{
		return(hr == otherTime.hr &&
				min == otherTime.min && sec ==otherTime.sec);
	}
	
	// ~~~~~ 3PIO Comments for printTime method ~~~~~//
		//Purpose:  print the valid data to the output file.
		//Input:  Scanner output file object
		//Pre Condition: Time object is created and method is called.
		// Scanner outfile object is created and output file is open for writing.
		// data is also valid.
		//Output: none.
		//Post Condition: the valid data is written in the output file.
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void printTime(PrintWriter outFile)
	{
		outFile.printf("%02d:%02d:%02d", hr, min, sec);
	}
	
	// ~~~~~ 3PIO Comments for addAMPM method ~~~~~//
		//Purpose:  add if its AM/PM/Noon to the time.
		//Input: Scanner output file object, current time, noon time.
		//Pre Condition: Time object is created and method is called.
		// Scanner outfile object is created and output file is open for writing. 
		// the given time is also valid. 
		//Output: none.
		//Post Condition: AM/PM/Noon tags are printed at the end of the time in the 
		// output file.
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void addAMPM(PrintWriter outFile, Time time, Time noonTime)
	{
		if(time.LessThan(noonTime))
		outFile.printf("%-15s\n", " ~>It is AM time!");
		else
			if(time.Equal(noonTime))
				outFile.printf("%-15s\n", " ~>It is PM & noon time!");
			else
			outFile.printf("%-15s\n", " ~>It is PM time!");
  }
} // end of Time

