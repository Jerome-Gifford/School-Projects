/* ==================================
	author: Jerome Gifford
	class: cs116 t/th
	description: Program 03
	input: patient exam name, scores, and ID
	process: validate input between specified fields,
	then calculate the avg exam and the results of the test
	output: display the outputs of the test for that patient
	=================================
*/
import java.util.*;

public class program03{
	public static void main(String[] args){
		
		//-- Ask for user input & store it --//
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Patient Name: ");
		String patientName = sc.next();
		System.out.println("Enter Patient ID: ");
		int patientID = sc.nextInt();
		System.out.println("Enter Exam 1 Results: ");
		float exam1 = sc.nextFloat();
		System.out.println("Enter Exam 2 Result: ");
		float exam2 = sc.nextFloat();
		System.out.println("Enter Exam 3 Result: ");
		float exam3 = sc.nextFloat();
		
		//-- Declare working variables --//
		String results = "";
		String outputHeader = "";
		String subHeader = ""; 
		String dataOutput = "";
		float avgExam = 0;
			
		//-- Validate data -- //
		
		if (patientID < 1111){
			System.out.println("ERROR Invalid data: Please enter a patientID between 1111 and 9999");
			patientID = sc.nextInt();
		}
		if (exam1 > 100f || exam1 < 0f){
			results = "Invalid Data";
		}
		else if (exam2 > 100f || exam2 < 0f){
			results = "Invalid Data";
		}
		else if (exam3 > 100f || exam3 < 0f){
			results = "Invalid Data";
		}
		else{
		
		// -- Determine Average Exam, valid results --//
		avgExam = (exam1 + exam2 + exam3) / 3f;
		
			if (avgExam >= 97){
				results = "Pos/RISK";
			}
			else if (avgExam > 70){
				results = "Pos";
			}
			else{
				results = "Neg";
			}
		}
		
		// -- Output data to user --//
		System.out.println("");
		System.out.println("*~~< Patient Exam Report >~~*");
		System.out.println("");
		outputHeader += "Name" + "          ";
		outputHeader += "Patient ID" + "    ";
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
		subHeader += "---" + "     ";
		subHeader += "-------";
		System.out.println(subHeader);
		dataOutput += patientName + "  ";
		dataOutput += patientID + "        ";
		dataOutput+= exam1 + "       ";
		dataOutput += exam2 + "       "; 
		dataOutput += exam3 + "       ";
		dataOutput += avgExam + "      ";
		dataOutput += results;
		System.out.println(dataOutput);
	}
}
