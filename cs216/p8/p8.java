// p8.java
//*********************************************************************************************
// YOUR NAME: Jerome Gifford
//
// COURSE TITLE: Computer Programming II
//
// COURSE NUMBER: CS216
//
// PROF NAME: Moe Bidgoli
//
// ASSIGNMENT NUMBER: #8
//
// DUE DATE: 10-31-2016
//
// POSSIBLE POINTS: 10 Points
//
// PURPOSE:
//*********************************************************************************************

import java.util.*;
import  java.io.*;

public class p8 {
	// ~~~~~ 3PIO Comments for Client side code ~~~~~//
		//Purpose: Determine the Net Pay and Deductions for a biweekly rate for different Airline Employees
		//Input: n/a
		//Pre Condition: The code complies
		//Output: n/a
		//Post Condition: The Net Pay and Deductions are determined and printed
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public static void main(String[] args) {
        Scanner inFile = new Scanner(System.in);
		AirlineEmployee filler = new Pilot();
		Pilot pl = new Pilot();
		Steward st = new Steward();
		CoPilot cp = new CoPilot();
		double pilotAVG = 0.0;
		double copilotAVG = 0.0;
		double stewardAVG = 0.0;
		int numPilot  = 0;
		int numCopilot = 0;
		int numSteward = 0;
		
		printHeader();
		
		while (inFile.hasNext()){
			filler.setId(inFile.nextInt());
			filler.setName(inFile.next());
			filler.setEmployeeType(inFile.next());
			if ((filler.getEmployeeType()).equals("Piolet")){
				pl.setId(filler.getId());
				pl.setName(filler.getName());
				pl.setEmployeeType(filler.getEmployeeType());
				pl.setSex(inFile.next());
				pl.setDate(inFile.nextInt());
				pl.setLevel(inFile.nextInt());
				pl.setSalary(inFile.nextDouble());
				pl.calculateData();
				pl.printRd();
				pl.printEmpRd();
				pilotAVG += pl.getNetPay();
				numPilot += 1;
			}
			else if((filler.getEmployeeType()).equals("CoPiolet") || (filler.getEmployeeType()).equals("CoPiolrt")){
				cp.setId(filler.getId());
				cp.setName(filler.getName());
				cp.setEmployeeType(filler.getEmployeeType());
				cp.setSex(inFile.next());
				cp.setDate(inFile.nextInt());
				cp.setLevel(inFile.nextInt());
				cp.setSalary(inFile.nextDouble());
				cp.calculateData();
				cp.printRd();
				cp.printEmpRd();
				copilotAVG += cp.getNetPay();
				numCopilot += 1;
			}
			else{
				st.setId(filler.getId());
				st.setName(filler.getName());
				st.setEmployeeType(filler.getEmployeeType());
				st.setSex(inFile.next());
				st.setDate(inFile.nextInt());
				st.setHrs(inFile.nextInt());
				st.setRate(inFile.nextDouble());
				st.calculateData();
				st.printRd();
				st.printEmpRd();
				stewardAVG += st.getNetPay();
				numSteward += 1;
			}
		}

		printSummary(pilotAVG, copilotAVG, stewardAVG, numPilot, numCopilot, numSteward);
	}
	// ~~~~~ 3PIO Comments for printHeader ~~~~~//
		//Purpose: print the header for the report
		//Input: n/a
		//Pre Condition: the code  compiles
		//Output: n/a
		//Post Condition: The header to the report is printed
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public static void printHeader(){
		System.out.println("<<* Biweekly Pay Report *>>");
		System.out.printf("%4s %10s %10s %3s %6s %15s %-9s %-7s\n", "ID", "Name", "Title", "Sex", "Year", "Rank ", "Deduction", "Net Pay");
		System.out.printf("%4s %10s %10s %3s %6s %15s %-9s %-7s\n", "--", "----", "-----", "---", "----", "---- ", "---------", "-------");
	}
	// ~~~~~ 3PIO Comments for printSummary ~~~~~//
		//Purpose: print the summary to the report
		//Input: double, double, double, int, int, int
		//Pre Condition:the sum of the netpay for each employee type is calculated as well as the number of each employee type.
		//Output: n/a
		//Post Condition: The summary of the report is printed
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public static void printSummary(double pilotAVG, double copilotAVG, double stewardAVG, int numPilot, int numCopilot, int numSteward){
		System.out.println("----------------------------------------------------------------");
		System.out.println();
		System.out.println("Average Net Pay for Pilot: $" + pilotAVG / numPilot);
		System.out.println("Average Net Pay for CoPilot: $" + copilotAVG / numCopilot);
		System.out.println("Average Net Paf for Steward: $" + stewardAVG / numSteward);
		System.out.println();
		System.out.println("Pilot: %" + ((double)numPilot / (numPilot + numCopilot + numSteward))  * 100);
		System.out.println("CoPilot: %" + ((double)numCopilot / (numPilot + numCopilot + numSteward))  * 100);
		System.out.println("Steward: %" + ((double)numSteward / (numPilot + numCopilot + numSteward))  * 100);
		System.out.println();
		System.out.println("<* End of Report *>");
	}
}