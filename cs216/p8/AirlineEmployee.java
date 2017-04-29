import java.util.*;
import  java.io.*;

public abstract class AirlineEmployee {
	private int id;
	private String name;
	private String employeeType;
	private String sex;
	private int date;
	
	// ~~~~~ 3PIO Comments for AirlineEmployee no args~~~~~//
		//Purpose:  create an AirlineEmployee object
		//Input: n/a
		//Pre Condition: the code compiles
		//Output: n/a
		//Post Condition: An AirlineEmployee object is created with default values
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	protected AirlineEmployee(){
		id = 0;
		name = "";
		employeeType = "";
		sex = "";
		date = 0;
	}
	// ~~~~~ 3PIO Comments for AirlineEmployee 5 args constructor ~~~~~//
		//Purpose:  create an AirlineEmployee object with given data
		//Input: int. string, string, string, int
		//Pre Condition: The date is valid
		//Output: n/a
		//Post Condition: An ArileineEmployee object is created with given values
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	protected AirlineEmployee(int inId, String inName, String inType, String inSex, int inDate){
		id = inId;
		name = inName;
		employeeType = inType;
		sex = inSex;
		date = inDate;
	}
	
	// ~~~~~ 3PIO Comments for setId ~~~~~//
		//Purpose: set the id to given value
		//Input: int
		//Pre Condition: an AirlineEmployee object is created
		//Output: n/a
		//Post Condition: the id is set to the given value
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void setId(int inId){
		id = inId;
	}
	
	// ~~~~~ 3PIO Comments for setName ~~~~~//
		//Purpose: set the name to given value
		//Input: string
		//Pre Condition: an AirlineEmployee object is created
		//Output: n/a
		//Post Condition: the name is set to the given value
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void setName (String inName){
		name = inName;
	}
	
	// ~~~~~ 3PIO Comments for setEmployeeType ~~~~~//
		//Purpose:  set the employeeType to given value
		//Input: string
		//Pre Condition: an AirlineEmployee object is created
		//Output: n/a
		//Post Condition: the employeeType is set to the given value
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void setEmployeeType (String inType){
		employeeType = inType;
	}
	
	// ~~~~~ 3PIO Comments for setSex ~~~~~//
		//Purpose: set the sex to the given value
		//Input:  string
		//Pre Condition: an AirlineEmployee object is created
		//Output: n/a
		//Post Condition: the sex is set to the given value
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void setSex(String inSex){
		sex = inSex;
	}
	
	// ~~~~~ 3PIO Comments for setDate ~~~~~//
		//Purpose: set the date to the given value
		//Input: int
		//Pre Condition: an AirlineEmployee object is created
		//Output: n/a
		//Post Condition: the date is set to the given value
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void setDate(int inDate){
		date = inDate;
	}
	
	// ~~~~~ 3PIO Comments for getId ~~~~~//
		//Purpose: get the id value
		//Input: n/a
		//Pre Condition: the id is set to a value
		//Output: int
		//Post Condition: the value of the id is returned
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public int getId(){
		return id;
	}
	
	// ~~~~~ 3PIO Comments for getName ~~~~~//
		//Purpose: get the name value
		//Input: n/a
		//Pre Condition: the name is set to a value
		//Output: string
		//Post Condition: the value of the name is returned
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public String getName(){
		return name;
	}
	
	// ~~~~~ 3PIO Comments for getEmployeeType ~~~~~//
		//Purpose: get the employeeType value
		//Input: n/a
		//Pre Condition: the employeeType is set to a value
		//Output: string
		//Post Condition: the value of the employeeType is returned
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public String getEmployeeType(){
		return employeeType;
	}
	
	// ~~~~~ 3PIO Comments for getSex ~~~~~//
		//Purpose: get the sex value
		//Input: n/a
		//Pre Condition: the sex is set to a value
		//Output: string
		//Post Condition: the value of sex is returned
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public String getSex(){
		return sex;
	}
	
	// ~~~~~ 3PIO Comments for getDate ~~~~~//
		//Purpose: get the date value
		//Input:  n/a
		//Pre Condition: the date is set to a value
		//Output: int
		//Post Condition: the value of the date is returned
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public int getDate(){
		return date;
	}
	
	// ~~~~~ 3PIO Comments for printRd ~~~~~//
		//Purpose: print the id name employeeType sex and date
		//Input: n/a
		//Pre Condition: all values are set
		//Output: n/a
		//Post Condition: the id name employeeType sex and date ar printed
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void printRd(){
		System.out.printf("%4d %10s %10s %3s %6d", id, name, employeeType, sex, date);
	}
	
	// the below classes are classes that are overrided and implemented in the subclass
	public abstract double getSalary();
	public abstract double getDeduction();
	public abstract double getNetPay();
	public abstract String getRank();
	public abstract void printEmpRd();
	
}