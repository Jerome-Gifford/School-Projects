import java.util.*;
import  java.io.*;

public class Pilot extends AirlineEmployee{
	private double salary;
	private int level;
	private String rank;
	private double deductionP;
	private double netPay;
	private final String rank1 = "Captain";
	private final String rank2 = "1st Officer";
	private final double deductionP1 = 0.30;
	private final double deductionP2 = 0.27;
	
	// ~~~~~ 3PIO Comments for Pilot no args~~~~~//
		//Purpose:  create an Pilot object
		//Input: n/a
		//Pre Condition: the code compiles
		//Output: n/a
		//Post Condition: An Pilot object is created with default values
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public Pilot(){
		super();
		level = 0;
		salary = 0;
		rank = "";
		deductionP = 0.0;
		netPay = 0.0;
	}
	
	// ~~~~~ 3PIO Comments for Pilot 7 args constructor ~~~~~//
		//Purpose:  create an Pilot object with given data
		//Input: int. string, string, string, int, int, double
		//Pre Condition: The date is valid
		//Output: n/a
		//Post Condition: An Pilot object is created with given values
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public Pilot(int inId, String inName, String inType, String inSex, int inDate, int inLevel, double inSalary){
		super(inId,inName,inType,inSex,inDate);
		level = inLevel;
		salary = inSalary;
		
		calculateData();
		
	}
	
	// ~~~~~ 3PIO Comments for calculateData ~~~~~//
		//Purpose:  calculate the rank deduction and netPay
		//Input: n/a
		//Pre Condition: level and salary are setDate
		//Output: n/a
		//Post Condition: the rank, deduction and netPay are calculated 
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void calculateData(){
		//determine rank ,deduction, & netPay
		if (level == 1){ 
			rank = rank1;
			deductionP = (salary/25) * deductionP1;
		}
		else{
			rank = rank2;
			deductionP = (salary/25) * deductionP2;
		}
		
		netPay = (salary/25) - deductionP;
	}
	
	public void setId(int inId){
		super.setId(inId);
	}
	
	public void setName (String inName){
		super.setName(inName);
	}
	
	public void setEmployeeType (String inType){
		super.setEmployeeType(inType);
	}
	
	public void setSex(String inSex){
		super.setSex(inSex);
	}
	
	public void setDate(int inDate){
		super.setDate(inDate);
	}
	
	public int getId(){
		return super.getId();
	}
	
	public String getName(){
		return super.getName();
	}
	
	public String getEmployeeType(){
		return super.getEmployeeType();
	}
	
	public String getSex(){
		return super.getSex();
	}
	
	public int getDate(){
		return super.getDate();
	}
	
	public void setSalary(double inSalary){
		salary = inSalary;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public String getRank(){
		calculateData();
		return rank;
	}
	
	public void setLevel(int inLevel){
		level = inLevel;
	}
	
	public double getDeduction(){
		calculateData();
		return deductionP;
	}
	public double getNetPay(){
		calculateData();
		return netPay;
	}
	public void printEmpRd(){
		calculateData();
		System.out.printf("%15s $%.2f $%.2f\n", rank, deductionP, netPay);
	}
	
	
}