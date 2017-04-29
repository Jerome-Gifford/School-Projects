import java.io.*;
import java.util.*;

class Student implements Valid, ConstValues{
	public int id; 
	public int exam;
	public String grade;
	
	public Student(){
		id = 0;
		exam = 0;
	}
	
	public Student(int inId, int inExam){
		id = inId;
		exam = inExam;
	}
	
	public void setId(int inId){
		id = inId;
	}
	
	public void setExam(int inExam){
		exam = inExam;
	}
	
	public int getId(){
		return id;
	}
	
	public int getExam(){
		return exam;
	}
	
	public void getDataFromFile(Scanner inFile){
		id = inFile.nextInt();
		exam = inFile.nextInt();
	}
	
	public String getGrade(){
		calcGrade();
		gradePlusMinus();
		return grade;
	}
	
	public void calcGrade(){
		if (exam >=  lowerA && exam <= upperA){
			grade = "A";
		}
		else if (exam >=  lowerB && exam < lowerA){
			grade = "B";
		}
		else if (exam >=  lowerC && exam < lowerB){
			grade = "C";
		}
		else if (exam >=  lowerD && exam < lowerC){
			grade = "D";
		}
		else{
			grade = "F";
		}
	}
	
	// ~~~~~ 3PIO Comments for gradePlusMinus method ~~~~~//
	//Purpose: adds plus or minus to grade
	//Input: n/a
	//Pre Condition: grade is calculated
	//Output: n/a
	//Post Condition: the plus/minus is appended to the grade if necessary.
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void gradePlusMinus(){
		if (exam == 100)
			grade = grade + "+";
		else if (exam % 10  <= upperPlus && exam % 10 >= lowerPlus && !grade.equals("F"))
			grade = grade + "+";
		else if (exam % 10 <= upperMinus && !grade.equals("F"))
			grade = grade + "-";
	}
	
	public boolean isValid(){
		return (id >= lowerID && id <= upperID && exam >= lowerF && exam <= upperA);
	}
	
	public void printInvalidData(){
		System.out.printf("%10d %4d %5s\n", id, exam, "~~~>Invalid Data!");
	}
	
	public void printData(){
		System.out.printf("%10d %4d %5s", id, exam, grade);
	}
	
	
}