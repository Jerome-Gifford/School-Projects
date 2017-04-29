import java.util.*;
import  java.io.*;

public class Steward extends AirlineEmployee{
	private double rate;
	private double hrs;
	private double pay;
	private double netPay;
	private double deductionS;
	private final double deductionS1 = 0.10;
	private final double deductionS2 = 0.15;
	private final double deductionS3 = 0.15;
	private final double deductionS4 = 0.15;
	private final double deductionS1Upper = 1600.00;
	private final double deductionS2Upper = 2400.00;
	private final double deductionS3Upper = 3200.00;
	private final double maxHrs = 80.0;
	private final double overtimeRate = 1.5;
	
	// ~~~~~ 3PIO Comments for Steward no args~~~~~//
		//Purpose:  create an Steward object
		//Input: n/a
		//Pre Condition: the code compiles
		//Output: n/a
		//Post Condition: An Steward object is created with default values
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public Steward(){
		super();
		hrs = 0;
		rate = 0;
		deductionS = 0.0;
		pay = 0.0;
		netPay = 0.0;
	}
	
	// ~~~~~ 3PIO Comments for Steward 7 args constructor ~~~~~//
		//Purpose:  create an Steward object with given data
		//Input: int. string, string, string, int, int, double
		//Pre Condition: The date is valid
		//Output: n/a
		//Post Condition: An Steward object is created with given values
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public Steward(int inId, String inName, String inType, String inSex, int inDate, int inHrs, double inRate){
		super(inId,inName,inType,inSex,inDate);
		hrs = inHrs;
		rate = inRate;
		
		calculateData();
		
	}
	
	// ~~~~~ 3PIO Comments for calculateData ~~~~~//
		//Purpose:  calculate the deduction and netPay
		//Input: n/a
		//Pre Condition: hrs and rate are set
		//Output: n/a
		//Post Condition: the deduction and netPay are calculated
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void calculateData(){
		if (hrs <= maxHrs){
		pay = rate * hrs;
		}
		else{
		pay = rate * maxHrs;
		pay += (rate * overtimeRate) * (hrs - maxHrs);
		}
		if (pay < deductionS1Upper){
			deductionS = pay * deductionS1;
		}
		else if (pay >= deductionS1Upper && pay < deductionS2Upper) {
			deductionS = pay * deductionS2;
		}
		else if (pay >= deductionS2Upper && pay < deductionS3Upper){
			deductionS = pay * deductionS3;
		}
		else{
			deductionS = pay * deductionS4;
		}
		
		netPay = pay - deductionS;
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
	
	public void setRate(double inRate){
		rate = inRate;
	}
	
	public String getRank(){
		return "None";
	}
	
	public double getSalary(){
		return pay;
	}
	
	public double getRate(){
		return rate;
	}
	
	public void setHrs(double inHrs){
		hrs = inHrs;
	}
	
	public void setPay(double inRate){
		rate = inRate;
	}
	
	public double getDeduction(){
		calculateData();
		return deductionS;
	}
	public double getNetPay(){
		calculateData();
		return netPay;
	}
	public void printEmpRd(){
		calculateData();
		System.out.printf("%15s $%.2f $%.2f\n", "None", deductionS, netPay);
	}
	
	
}