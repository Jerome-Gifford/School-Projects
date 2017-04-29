// p2.java 
//*********************************************************************************************
// YOUR NAME: Jerome Gifford
//
// COURSE TITLE: Computer Programming II
//
// COURSE NUMBER: CS216
//
// PROF NAME: Moe Bidgoli
//
// ASSIGNMENT NUMBER: #2
//
// DUE DATE: 09-26-2016
//
// POSSIBLE POINTS: 10 Points
//
//PURPOSE: The purpose of this program is to take the input of a studenst Id, sex, and three exams scores and return
// a report by student with the avg of their exams, their grade, as well as a summary by grade tier and gender. This program also
// displays the highest avg and the id that corresponds with it.
//
//
//*********************************************************************************************

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class p2 {
	
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
			float validCounter = 0;
			int validA = 0;
			int validB = 0; 
			int validC= 0;
			int validD = 0;
			int validF = 0;
			int validMale = 0;
			int validFemale = 0;
			String bestID = "";
			double bestAvg = 0;
			
			
			printHeader();
			while(inFile.hasNext())
			{
			   StudExam studExam = new StudExam(); //create studExam object
			   studExam.getDataFromFile(inFile); //call getDataFromFile method to grab the data from the input file.
			   if(studExam.isDataValid()){ // call isDataValid method to determine if data is valid. Then print.
					studExam.setAvg();
					studExam.setGrade();
					if (studExam.getGrade().equals("A"))
						validA ++;
					else if (studExam.getGrade().equals("B"))
						validB ++;
					else if (studExam.getGrade().equals("C"))
						validC ++;
					else if (studExam.getGrade().equals("D"))
						validD ++;
					else if (studExam.getGrade().equals("F"))
						validF ++;
					
					if (studExam.getSex().equals("M"))
						validMale ++;
					else
						validFemale ++;
					
					if (studExam.getAvg() > bestAvg){
						bestAvg = studExam.getAvg();
						bestID = studExam.getStudId();
					}
					studExam.gradePlusMinus();
					studExam.printData();
					validCounter ++;
			   }
			   else{
				   studExam.printInvalidData();
			   }

			} // end of loop
			
			printSummary(validCounter, validA, validB, validC, validD, validF, validFemale, validMale, bestAvg, bestID);
			
				
			
	} //end of main
	
	// ~~~~~ 3PIO Comments for printHeader ~~~~~//
		//Purpose: print the header for the report
		//Input: n/a
		//Pre Condition: the method is called.
		//Output:  n/a
		//Post Condition: Header is printed out.
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public static void printHeader(){
		System.out.println("~~~ Exam Report ~~~");
		System.out.printf("\n%10s %-10s %3s %5s %5s %5s %12s %5s\n", "student ID", "Name", "Sex", "Exam1", "Exam2", "Exam3", "Avg of Exams", "Grade");
		System.out.printf("%10s %-10s %3s %5s %5s %5s %12s %5s\n", "----------", "----", "---", "-----", "-----", "-----", "------------", "-----");
	}
	
	// ~~~~~ 3PIO Comments for printSummary ~~~~~//
		//Purpose: print the summary for the report
		//Input: all of teh validCounters, bestAvg, and bestId
		//Pre Condition: the method is calledmand all dats is valid and calculated
		//Output:  n/a
		//Post Condition: Summary is printed out.
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public static void printSummary(float validCounter, int validA, int validB, int validC, int validD, int validF, int validFemale, int validMale, double bestAvg, String bestID){
		DecimalFormat decimalFormat = new DecimalFormat("##.##%");
		
		//Print % of each grade tier
			System.out.printf("\n%10s %10s %10s %10s %10s\n", "% of A", "% of B", "% of C", "% of D", "% of F");
			System.out.printf("%10s %10s %10s %10s %10s\n", "------", "------", "------", "------", "------");
			if (validCounter > 0)
				System.out.printf("%10s %10s %10s %10s %10s\n", decimalFormat.format(validA/validCounter), decimalFormat.format(validB/validCounter), 
					decimalFormat.format(validC/validCounter), decimalFormat.format(validD/validCounter), decimalFormat.format(validF/validCounter));
			else
				System.out.printf("%10s %10s %10s %10s %10s\n", "0.00", "0.00", "0.00", "0.00", "0.00");
				
			//Print % of each sex
			if (validCounter > 0){
				System.out.println("\n>>> Female: " + decimalFormat.format(validFemale / validCounter));
				System.out.println(">>> Male: " + decimalFormat.format(validMale / validCounter));
			}
			else{
				System.out.println("\n>>> Female: 0.00%");
				System.out.println(">>> Male: 0.00%");
			}
			
			if (validCounter > 0){
			//Print best score
			System.out.println("\n~~~ The best exam performance is done by student with the ID: " + bestID + " with AVG of ");
			System.out.printf("%.2f", bestAvg);
			}
			else 
				System.out.println("\n~~~ NO VALID ENTRIES");
			System.out.println("\n<* End of Report *>");
	}
	
}