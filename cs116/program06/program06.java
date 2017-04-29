/* ==================================
	author: Jerome Gifford
	class: cs116 t/th
	description: Program 06
	input: patient exam name, scores, and ID
	process: validate input between specified fields,
	then calculate the avg exam and the results of the test
	output: display the outputs of the test for that patient
	=================================
*/
import java.util.*;

public class program06{
	//-- input variables to change later --//
		public static String patientName = "";
		public static int patientID = 0;
		public static String patientGender = "";
		public static float exam1 = -1;
		public static float exam2 = -1;
		public static float exam3 = -1;
	
	public static void main(String[] args){
		
		//-- Declare working variables --//
		String results = "";
		String dataOutput = "";
		float avgExam = 0;
		int numberOfRecords = 0;
		int counter = 0;
		int countRed = 0;
		int countOrange = 0;
		int countYellow = 0;
		int countBlue = 0;
		int countGreen = 0;
		int countMale = 0;
		int countFemale = 0;
		int countValid = 0;
		int countInvalid = 0;
		float max = 0;
		float min = 100;
		
		System.out.println("Number of Records to enter: ");
		Scanner sc = new Scanner(System.in);
		numberOfRecords = sc.nextInt();
		
		while  (counter != numberOfRecords){
		
			readRecord(sc);
			
			//increase counter
			counter = counter + 1;
				
			//-- Validate data -- //
			
			if (patientID < 1111 || patientID > 9999){
				System.out.println("ERROR Invalid data: Please enter a patientID between 1111 and 9999");
				patientID = sc.nextInt();
			}
			if (exam1 > 100f || exam1 < 0f){
				results = "Invalid Data";
				countInvalid += 1;
			}
			else if (exam2 > 100f || exam2 < 0f){
				results = "Invalid Data";
				countInvalid += 1;
			}
			else if (exam3 > 100f || exam3 < 0f){
				results = "Invalid Data";
				countInvalid += 1;
			}
			else{
				
				//-- Count genders  & Valid--//
				if (patientGender.equals("M") || patientGender.equals("m")){
					countMale += 1;
				}
				else if (patientGender.equals("F") || patientGender.equals("f")){
					countFemale += 1;
				}
				
				countValid += 1;
				
				//-- get avergage exam score --//
				avgExam = computeAverage(exam1, exam2, exam3);
			
				//-- Figure out results--//
			
				if (avgExam >= 97){
					results = "RED";
					countRed += 1;
				}
				else if (avgExam > 88){
					results = "ORANGE";
					countOrange += 1;
				}
				else if (avgExam > 78){
					results = "YELLOW";
					countYellow += 1;
				}
				else if (avgExam > 70){
					results = "BLUE";
					countBlue += 1;
				}
				else{
					results = "GREEN";
					countGreen += 1;
				}
				
				//-- Calaculate Min And Max --//
				if (exam1 > max){
					max = exam1;
				}
				if (exam2 > max){
					max = exam2;
				}
				if (exam3 > max){
					max = exam3;
				}
				if (exam1 < min){
					min = exam1;
				}
				if (exam2 < min){
					min = exam2;
				}
				if (exam3 < min){
					min = exam3;
				}
	
			}
			// -- Get output to print --//
			dataOutput = printRecord(dataOutput, patientName, patientID, patientGender, 
									exam1, exam2, exam3, avgExam, results);
		}
		
			// -- Output data to user --//
			printHeader();
			System.out.println(dataOutput);
			printHistogram(countRed, countOrange, countYellow, countBlue, countGreen);
			printPrecentages(countFemale, countMale, countValid, countInvalid, counter);
			printMaxMin(max, min);
	}
	
	public static void printHeader(){
		//-- print the header --//
		String outputHeader = "";
		System.out.println("");
		System.out.println("*~~< Patient Exam Report >~~*");
		System.out.println("");
		outputHeader += "Name" + "          ";
		outputHeader += "Patient ID" + "    ";
		outputHeader += "Gender " + "    ";
		outputHeader += "Exam 1" + "     ";
		outputHeader += "Exam 2" + "     "; 
		outputHeader += "Exam 3" + "     ";
		outputHeader += "AVG" + "     ";
		outputHeader += "Pos/Neg" + "\n";
		outputHeader += "----" + "          ";
		outputHeader += "----------" + "    ";
		outputHeader += "------" + "     ";
		outputHeader += "------" + "     ";
		outputHeader += "------" + "     "; 
		outputHeader += "------" + "     ";
		outputHeader += "---" + "     ";
		outputHeader += "-------";
		System.out.println(outputHeader);
	}
	
	public static void printHistogram(int countRed, int countOrange, int countYellow, int countBlue, int countGreen){
		//-- Print out the histogram for the program --//
		System.out.println("");
		System.out.println("*~~< Summary >~~*");
		System.out.println("");
		System.out.println("RED: " + countRed);
		System.out.println("ORANGE: " + countOrange);
		System.out.println("YELLOW: " + countYellow);
		System.out.println("BLUE: " + countBlue);
		System.out.println("GREEN: " + countGreen);
		System.out.println("");
	}
	
	public static void printPrecentages(int countFemale, int countMale, int countValid, int countInvalid, int counter){
		//--calc percentages --//
		float malePercent = countMale / counter;
		float femalePercent = countFemale / counter;
		float validPercent = countValid / counter;
		float invalidPercent = countInvalid/ counter;
		
		//-- print the percentages of males, females, valid, and invalid data --//
		System.out.println("Female: " + (femalePercent * 100) + "%" + "(" + countFemale + " records)");
		System.out.println("Male: " + (malePercent * 100) + "%" + "(" + countMale + " records)");
		System.out.println("");
		System.out.println("Valid: " + (validPercent * 100) + "%" + "(" + countValid + " records)");
		System.out.println("Invalid: " + (invalidPercent * 100) + "%" + "(" + countInvalid + " records)");
		System.out.println("");
	}
	
	public static void printMaxMin(float max, float min){
		//-- print the max and min values --//
		System.out.println("Max: " + max);
		System.out.println("Min: " + min);
	}
	
	public static float computeAverage(float exam1, float exam2, float exam3){
		//-- calc the average exam and return the value --//
		float avgExam; 
		avgExam = (exam1 + exam2 + exam3) / 3f;
		return avgExam;
	}
	
	public static String printRecord(String dataOutput, String patientName, int patientID, String patientGender, 
										float exam1, float exam2, float exam3, float avgExam, String results){
		//-- prepare output string to be printed --//
		dataOutput += patientName + "  ";
		dataOutput += patientID + "           ";
		dataOutput += patientGender + "         ";
		dataOutput+= exam1 + "        ";
		dataOutput += exam2 + "       "; 
		dataOutput += exam3 + "       ";
		dataOutput += avgExam + "      ";
		dataOutput += results;
		dataOutput += "\n";
		return dataOutput;
	}
	
	public static void readRecord(Scanner sc){
		//-- Ask for user input & store it --//
		System.out.println("Enter Patient Name: ");
		patientName = sc.next();
		System.out.println("Enter Patient ID: ");
		patientID = sc.nextInt();
		System.out.println("Enter Patient Gender: ");
		patientGender = sc.next();
		System.out.println("Enter Exam 1 Results: ");
		exam1 = sc.nextFloat();
		System.out.println("Enter Exam 2 Result: ");
		exam2 = sc.nextFloat();
		System.out.println("Enter Exam 3 Result: ");
		exam3 = sc.nextFloat();
	}
}
