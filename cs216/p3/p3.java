// p3.java 
//*********************************************************************************************
// YOUR NAME: Jerome Gifford
//
// COURSE TITLE: Computer Programming II
//
// COURSE NUMBER: CS216
//
// PROF NAME: Moe Bidgoli
//
// ASSIGNMENT NUMBER: #3
//
// DUE DATE: 09-28-2016
//
// POSSIBLE POINTS: 10 Points
//
// PURPOSE: to evaluate an expression using stacks. Determine if the expression is an Overflow or Underflow if it can not be evaluated. 
// Return the results to the user with evaluation is possible. 
//
//*********************************************************************************************

import java.io.*;
import java.util.*;

public class p3 {
	
	// ~~~~~ 3PIO Comments for Client side code ~~~~~//
		//Purpose: evaluate expressions using stacks
		//Input: n/a
		//Pre Condition: file complies
		//Output: n/a
		//Post Condition:  The stack is evaluated or marked as invalid and printed out
		//Note:  n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
    public static void main(String[] args) {
			Scanner inFile = new Scanner(System.in);
			int numOfOpen = 0;
			int numOfClose = 0;
			String statement = "";
			
			
			while (inFile.hasNext()){
				statement = inFile.next();
				
				// verfiy that the data has equal '(' & ')' characters
				numOfOpen = statement.length() - statement.replace("(", "").length();
				numOfClose = statement.length() - statement.replace(")", "").length();
				
				//cretae stacks
				Stack operandStack = new Stack(5);
				Stack operatorStack = new Stack(5);
				
				if (numOfClose == numOfOpen){
					printHeader(statement);
					System.out.print(" is " +"OK!\n");
					
					//convert string to char array for stacks
					char[] arr = statement.toCharArray();
					int i = 0;
					String lastOperator = "";
					
					while (i < arr.length){
						
						if(arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/' || arr[i] == '%'){
							operatorStack.pushChar(arr[i]);
						}
						else if (arr[i] == ')'){
							//evaluate the expression (assume single digit numbers)
							int operand2 = operandStack.popInt();
							int operand1 = operandStack.popInt();
							lastOperator = String.valueOf(operatorStack.popChar());
							
							if (lastOperator.equals("+")){
								operandStack.pushInt(operand1 + operand2);
							}
							else if (lastOperator.equals("-")){
								operandStack.pushInt(operand1 - operand2);
							}
							else if (lastOperator.equals("*")){
								operandStack.pushInt(operand1 * operand2);
							}
							else if (lastOperator.equals("/")){
								operandStack.pushInt(operand1 / operand2);
							}
							else{
								operandStack.pushInt(operand1 % operand2);
							}
						}
						else if (arr[i] != '(' && arr[i] != ';') {
							operandStack.pushInt(Character.getNumericValue(arr[i]));
						}
						
						i++;
						
					}
					
					System.out.println("\n~~ Evaluation Results: "+ operandStack.popInt());
					
				}
				else{
					printHeader(statement);
					if(numOfOpen > numOfClose){
						// Test if there is more than 5 ( before you evaluate an expression
						statement = statement.substring(0,(statement.indexOf(')'))); 
						numOfOpen = statement.length() - statement.replace("(", "").length();
						if(numOfOpen > 5)
							System.out.print(" ~~~ Stack Overflow!\n");
						else
						System.out.print(" is " +"NOT OK!\n");
					}
					else if (numOfClose > numOfOpen)
						System.out.print(" ~~~ Stack Underflow!\n");	
				}
				
			}
			
			System.out.print("\n<end>");
			
	} //end of main
	
	// ~~~~~ 3PIO Comments for printHeader ~~~~~//
		//Purpose: print the header for output
		//Input: statment to print
		//Pre Condition: statement exists
		//Output: n/a
		//Post Condition: The header is printed
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	public static void printHeader(String statement){
		System.out.print("*** Fully Parenthesized Arthmetic Infix Expression ***\n" + "\n" + statement);
	}
	
}