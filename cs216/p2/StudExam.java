import java.io.*;
import java.util.*;


// ~~~~~ 3PIO Comments for StudExam class ~~~~~//
	//Purpose: Calcuate the avg and grade of valid students exams and display information by gender and grade tier groups
	//Input: Various. Depends on what method is called
	//Pre Condition: The object is created
	//Output: Various. Depends on what method is called
	//Post Condition: Depended upon what method is called
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
public class StudExam {
	
	private int stdId;
	private String studName;
	private String sex;
	private int exam1;
	private int exam2;
	private int exam3;
	private int sumOfExams;
	private double examAvg;
	private String studGrade;
	private final int NUM_OF_EXAMS = 3;
	private final int LOWER_ID = 1111;
	private final int UPPER_ID = 9999;
	private final int LOWER_EXAM = 0;
	private final int UPPER_EXAM = 100;
	private final int LOWER_A = 90;
	private final int LOWER_B = 80;
	private final int LOWER_C = 70;
	private final int LOWER_D = 60;
	
	
	// ~~~~~ 3PIO Comments for StudExam constructor (no args)~~~~~//
	//Purpose: set the defaults for the StudExam class
	//Input: n/a
	//Pre Condition: Object is created and constructor is called
	//Output: n/a
	//Post Condition: user input fields are set to 0 or null.
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	public StudExam(){
		stdId = 0;
		studName = "";
		sex = "";
		exam1 = 0;
		exam2 = 0;
		exam3 = 0;
		
	}
	
	// ~~~~~ 3PIO Comments for StudExam constructor (6 args)~~~~~//
	//Purpose: set the user data for the Class
	//Input: studID, studName, sex, exam1, exam2, exam3
	//Pre Condition: Object is created and class if called
	//Output: n/a
	//Post Condition: user input fields are set to given user input
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	public StudExam(int studIdInput, String studNameInput, String sexInput, int exam1Input, int exam2Input, int exam3Input){
		stdId = studIdInput;
		studName = studNameInput;
		sex = sexInput;
		exam1 = exam1Input;
		exam2 = exam2Input;
		exam3 = exam3Input;
	}
	
	// ~~~~~ 3PIO Comments for isDataValid Method ~~~~~//
	//Purpose:  determine if teh entered data is valid
	//Input: n/a
	//Pre Condition: The user inputs have been set
	//Output: true/false
	//Post Condition: The data is determined valid or invalid for use later
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	public boolean isDataValid(){
		return(exam1 >= LOWER_EXAM && exam1 <= UPPER_EXAM && exam2 >=LOWER_EXAM && exam2 <= UPPER_EXAM && exam3 >= LOWER_EXAM && exam3 <= UPPER_EXAM && 
		(sex.equals("M") || sex.equals("F")) && stdId >= LOWER_ID && stdId <= UPPER_ID);
	}
	
	// ~~~~~ 3PIO Comments for getDataFromFile method ~~~~~//
	//Purpose: get user data from a file
	//Input: Scanner object that is reading a file
	//Pre Condition: Scanner object is created and file exists
	//Output: n/a
	//Post Condition: user input fields are set to data from file
	//Note: without SubmitJ the "file" is just user input
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	public void getDataFromFile (Scanner inFile){
		stdId  = inFile.nextInt();
		studName = inFile.next();
		sex = inFile.next();
		exam1 = inFile.nextInt();
		exam2 = inFile.nextInt();
		exam3 = inFile.nextInt();
		inFile.nextLine();
		
	}
	
	// ~~~~~ 3PIO Comments for printInvalidData method ~~~~~//
	//Purpose:  print out Invalid Data
	//Input: n/a
	//Pre Condition: User input fields are set and data is validated
	//Output: n/a
	//Post Condition: Invalid data is printed out with correct formatting.
	//Note:
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	public void printInvalidData(){
		System.out.printf("%-10d %-10s %-3s %-5d %-5d %-5d ~~~> Invalid Data!\n", stdId, studName, sex, exam1, exam2, exam3);
	}
	
	// ~~~~~ 3PIO Comments for examsAvg method ~~~~~//
	//Purpose: calculate the Avg of the 3 exams
	//Input: n/a
	//Pre Condition: method is called and setSum method exists.
	//Output: double of the Avg
	//Post Condition: the Avg is calculated and returned
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	public double examsAvg(){
		this.setSum();
		examAvg = (double)sumOfExams / NUM_OF_EXAMS;
		return examAvg;
		
	}
	
	// ~~~~~ 3PIO Comments for grade method ~~~~~//
	//Purpose: determine the letter grade of the avg
	//Input: n/a
	//Pre Condition: the avg is set.
	//Output: String of letter grade
	//Post Condition: The letter grade is determined and returned
	//Note:
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public String grade(){
		if (Math.ceil(examAvg) >=  LOWER_A && Math.ceil(examAvg) <= UPPER_EXAM){
			studGrade = "A";
			return studGrade;
		}
		else if (Math.ceil(examAvg) >=  LOWER_B && Math.ceil(examAvg) < LOWER_A){
			studGrade = "B";
			return studGrade;
		}
		else if (Math.ceil(examAvg) >=  LOWER_C && Math.ceil(examAvg) < LOWER_B){
			studGrade = "C";
			return studGrade;
		}
		else if (Math.ceil(examAvg) >=  LOWER_D && Math.ceil(examAvg) < LOWER_C){
			studGrade = "D";
			return studGrade;
		}
		else{
			studGrade = "F";
			return studGrade;
		}
	}
	
	// ~~~~~ 3PIO Comments for gradePlusMinus method ~~~~~//
	//Purpose: adds plus or minus to grade
	//Input: n/a
	//Pre Condition: studGrade is calculated
	//Output: n/a
	//Post Condition: the plus/minus is appended to the grade if necessary.
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void gradePlusMinus(){
		if (examAvg % 10 <= 3 && !studGrade.equals("F")){
			studGrade = studGrade + "-";
		}
		else if (examAvg % 10 <= 9 && examAvg >= 7 && !studGrade.equals("A") && !studGrade.equals("F")){
			studGrade = studGrade + "+";
		}
		else if (examAvg == 100){
			studGrade = studGrade + "+";
		}
	}
	// ~~~~~ 3PIO Comments for setSum method ~~~~~//
	//Purpose:  calculate the sum of the exams for the avg methods
	//Input: n/a
	//Pre Condition: the exams are set to a value
	//Output: n/a
	//Post Condition: the sum is calculated and stored for use later
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void setSum(){
		
		sumOfExams = exam1 + exam2 + exam3;
		
	}
	
	// ~~~~~ 3PIO Comments for setAvg method ~~~~~//
	//Purpose: set the Avg of the students exams
	//Input: n/a
	//Pre Condition: Method is called; examsAvg method exists
	//Output: n/a
	//Post Condition: The Avg is calculated
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void setAvg(){
		this.examsAvg();
		
	}
	
		// ~~~~~ 3PIO Comments for getAvg method ~~~~~//
	//Purpose: return the Avg
	//Input: n/a
	//Pre Condition: the Avg is calculated
	//Output: double of the Avg
	//Post Condition: the Avg is returned as a double
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public double getAvg(){
		return examAvg;
		
	}
	
	// ~~~~~ 3PIO Comments for setGrade method ~~~~~//
	//Purpose: set the students grade
	//Input: n/a
	//Pre Condition: the avg is calculated
	//Output: n/a
	//Post Condition: The grade determined
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void setGrade(){
		this.grade();
	}
	
	// ~~~~~ 3PIO Comments for getGrade method ~~~~~//
	//Purpose: return the students grade
	//Input: n/a
	//Pre Condition: The grade is determined
	//Output: String of the grade
	//Post Condition: the grade is returned without the plus/minus
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public String getGrade(){
		return studGrade;
	}
	
	// ~~~~~ 3PIO Comments for printData method ~~~~~//
	//Purpose: print the valid data 
	//Input: n/a
	//Pre Condition: the data is determined to be valid
	//Output: n/a
	//Post Condition: the valid data is printed out in the correct formatting
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void printData(){
		
		System.out.printf("%-10d %-10s %-3s %-5d %-5d %-5d %.2f         %-5s\n", stdId, studName, sex, exam1, exam2, exam3, examAvg, studGrade);
		
	}
	
	// ~~~~~ 3PIO Comments for getSex method ~~~~~//
	//Purpose: return the students sex
	//Input: n/a
	//Pre Condition: the students sex is set
	//Output: String of the students sex
	//Post Condition: The students sex is returned for use later
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public String getSex(){
		return sex;
	}
	
	// ~~~~~ 3PIO Comments for getStudId method ~~~~~//
	//Purpose:  return the students id
	//Input: n/a
	//Pre Condition: the students id is set
	//Output: String of the students id
	//Post Condition: The students id is returned for use later
	//Note:
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public String getStudId(){
		return Integer.toString(stdId);
	}

} // end of StudExam

