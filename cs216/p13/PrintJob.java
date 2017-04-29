import java.io.*;
import java.util.*;

class PrintJob{
	// ~~~~~ 3PIO Comments for PrintJob ~~~~~//
		//Purpose: hold the information for a print job
		//Input: Various. Depends on the method called
		//Pre Condition: the code compiles.
		//Output: Various. Depends on the method called
		//Post Condition: The Print Job is created and the information is stored
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	private String studName;
	private String courseName;
	private int numOfPage;
	private int priority;
	
	public PrintJob(){
		studName = "";
		courseName = "";
		numOfPage = 0;
		priority = 0;
	}
	
	public PrintJob(String inStudName, String inCourseName, int inNumOfPage, int inPriority){
		studName = inStudName;
		courseName = inCourseName;
		numOfPage = inNumOfPage;
		priority = inPriority;
	}
	
	public void getDataFromFile(Scanner inFile){
		studName = inFile.next();
		courseName = inFile.next();
		numOfPage = inFile.nextInt();
		priority = inFile.nextInt();
	}
	
	public void printPQJob(){
		System.out.printf("%-9s %-11s %-11d %-8d\n",studName,courseName,numOfPage, priority);
	}
	
	public String getStudName(){
		return studName;
	}
	
	public String getCourseName(){
		return courseName;
	}
	
	public int getNumOfPage(){
		return numOfPage;
	}
	
	public int getPriority(){
		return priority;
	}
	
	public void setStudName(String inStudName){
		studName = inStudName;
	}
	
	public void setCourseName(String inCourseName){
		courseName = inCourseName;
	}
	
	public void setNumOfPage(int inNumOfPage){
		numOfPage = inNumOfPage;
	}
	
	public void setPriority(int inPriority){
		priority = inPriority;
	}
	
	public String toString(){
		return  String.format("%-9s %-11s %-11d %-8d", studName, courseName, numOfPage, priority);
	}
	
	
}