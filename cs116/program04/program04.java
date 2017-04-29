/* ==================================
	author: Jerome Gifford
	class: cs116 t/th
	description: Program 04
	input: patient exam name, scores, and ID
	process: validate input between specified fields,
	then calculate the avg exam and the results of the test
	output: display the outputs of the test for that patient
	=================================
*/
import java.util.*;

public class program04{
	public static void main(String[] args){
		
		//-- Declare working variables --//
		String results = "";
		String outputHeader = "";
		String subHeader = ""; 
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
		float max = 0f;
		float min = 100f;
		
		System.out.println("Number of Records to enter: ");
		Scanner sc = new Scanner(System.in);
		numberOfRecords = sc.nextInt();
		
		while  (counter != numberOfRecords){
		
			//-- Ask for user input & store it --//
			System.out.println("Enter Patient Name: ");
			String patientName = sc.next();
			System.out.println("Enter Patient ID: ");
			int patientID = sc.nextInt();
			System.out.println("Enter Patient Gender: ");
			String patientGender = sc.next();
			System.out.println("Enter Exam 1 Results: ");
			float exam1 = sc.nextFloat();
			System.out.println("Enter Exam 2 Result: ");
			float exam2 = sc.nextFloat();
			System.out.println("Enter Exam 3 Result: ");
			float exam3 = sc.nextFloat();
			
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
				
				// -- Count genders  & Valid--//
				if (patientGender == "M" || patientGender == "m"){
					countMale += 1;
				}
				else if (patientGender == "F" || patientGender == "f"){
					countFemale += 1;
				}
				
				countValid += 1;
				
			// -- Determine Average Exam, valid results --//
			avgExam = (exam1 + exam2 + exam3) / 3f;
			
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
				
				if (avgExam > max){
						max = avgExam;
				}
				else if (avgExam < min){
					min = avgExam;
				}
			}
		
			dataOutput += patientName + "  ";
			dataOutput += patientID + "           ";
			dataOutput += patientGender + "         ";
			dataOutput+= exam1 + "        ";
			dataOutput += exam2 + "       "; 
			dataOutput += exam3 + "       ";
			dataOutput += avgExam + "      ";
			dataOutput += results;
			dataOutput += "\n";
		}
		
			// -- Output data to user --//
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
			outputHeader += "Pos/Neg";
			System.out.println(outputHeader);
			subHeader += "----" + "          ";
			subHeader += "----------" + "    ";
			subHeader += "------" + "     ";
			subHeader += "------" + "     ";
			subHeader += "------" + "     "; 
			subHeader += "------" + "     ";
			subHeader += "---" + "     ";
			subHeader += "-------";
			System.out.println(subHeader);
			System.out.println(dataOutput);
			System.out.println("");
			System.out.println("*~~< Summary >~~*");
			System.out.println("");
			System.out.println("RED: " + countRed);
			System.out.println("ORANGE: " + countOrange);
			System.out.println("YELLOW: " + countYellow);
			System.out.println("BLUE: " + countBlue);
			System.out.println("GREEN: " + countGreen);
			System.out.println("");
			System.out.println("Female: " + countFemale);
			System.out.println("Male: " + countMale);
			System.out.println("");
			System.out.println("Valid: " + countValid);
			System.out.println("Invalid: " + countInvalid);
			System.out.println("");
			System.out.println("Max: " + max);
			System.out.println("Min: " + min);
	}
}
