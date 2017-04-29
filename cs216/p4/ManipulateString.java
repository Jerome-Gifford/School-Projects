import java.io.*;
import java.util.*;

// ~~~~~ 3PIO Comments for ManipulateString Class ~~~~~//
	//Purpose: do all th emanipulations to a string
	//Input: Various depending on method/constructor called
	//Pre Condition: code compiles
	//Output: Various depending on method/constructor called
	//Post Condition: Various depending on method/constructor called
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

public class ManipulateString {	

	private String statement;
	private final String university = "Saginaw Valley State University";
	private final String course = "Computer Science & Information Systems";
	private final String uniAbb = "SVSU";
	private final String courseAbb = "CSIS";
	
	// ~~~~~ 3PIO Comments for No args constructor ~~~~~//
	//Purpose: set statement to blank
	//Input: n/a
	//Pre Condition: code compiles and constructor is called
	//Output: n/a
	//Post Condition: statement is set to blank
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	ManipulateString(){
		statement = "";
	}
	
	// ~~~~~ 3PIO Comments for String args constructor ~~~~~//
	//Purpose: set statement to user input
	//Input: string
	//Pre Condition: code compiles and constructor is called
	//Output: n/a
	//Post Condition: statement is set to user input
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	ManipulateString(String inStatement){
		statement = inStatement.trim();
	}
	
	// ~~~~~ 3PIO Comments for getLength method ~~~~~//
	//Purpose: get the length of the string
	//Input: n/a
	//Pre Condition: statement is set to a value
	//Output: integer	
	//Post Condition: the length of the string is returned
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public int getLength(){
		return statement.length();
	}
	
	// ~~~~~ 3PIO Comments for getFirstChar method ~~~~~//
	//Purpose: get the first character of the string
	//Input: n/a
	//Pre Condition: statement is set to a value
	//Output: char
	//Post Condition: the first character of the string is returned
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public char getFirstChar(){
		return statement.charAt(0);
	}
	
	// ~~~~~ 3PIO Comments for getLastChar method ~~~~~//
	//Purpose: get the last character of the string
	//Input: n/a
	//Pre Condition: statement is set to a value
	//Output: char
	//Post Condition: the last character of the string is returned
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public char getLastChar(){
		return statement.charAt(this.getLength() - 1);
	}
	
	// ~~~~~ 3PIO Comments for getUpperString method ~~~~~//
	//Purpose: get the uppercase version of the string
	//Input: n/a
	//Pre Condition: statement is set to a value
	//Output: string
	//Post Condition: the uppercase version of the string is returned
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public String getUpperString(){
		return statement.toUpperCase();
	}
	
	// ~~~~~ 3PIO Comments for addToString method ~~~~~//
	//Purpose: add university to the end of the string
	//Input: n/a
	//Pre Condition: statement is set to a value
	//Output: n/a
	//Post Condition: the university is set to the end of the string
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void addToString(){
		statement = statement + university + "-" + course;
	}
	
	// ~~~~~ 3PIO Comments for replaceString method ~~~~~//
	//Purpose: replace the university and course with their short hand version
	//Input: n/a
	//Pre Condition: the statement is set to a value
	//Output: n/a
	//Post Condition: the university and course are replaced in the string with the short hand versions
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void replaceString(){
		statement = statement.replaceAll(university, uniAbb);
		statement = statement.replaceAll(course, courseAbb);
	}
	
	// ~~~~~ 3PIO Comments for removeNewLine method ~~~~~//
	//Purpose: remove all of the new line characters from the string
	//Input: n/a
	//Pre Condition: the statement is set to a value
	//Output: n/a
	//Post Condition: all of the new line characters are removed from the string
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void removeNewLine(){
		statement = statement.replaceAll("\n", "");
	}
	
	// ~~~~~ 3PIO Comments for getLastIndexOfUniversity method ~~~~~//
	//Purpose: get the last index of the university short hand
	//Input: n/a
	//Pre Condition: the statement is set to a value and the university short hands are set
	//Output: int
	//Post Condition: the index of the last university short hand is returned
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public int getLastIndexOfUniversity(){
		return statement.lastIndexOf(uniAbb);
	}
	
	// ~~~~~ 3PIO Comments for wordCount method ~~~~~//
	//Purpose: get the number of words in the string
	//Input: n/a
	//Pre Condition: the statement is set to a value
	//Output: int
	//Post Condition: the number of words in the string is returned
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public int wordCount(){
		return statement.trim().split("\\s+").length;
	}
	
	// ~~~~~ 3PIO Comments for reverseString method ~~~~~//
	//Purpose: the string is reversed
	//Input: n/a
	//Pre Condition: the statement is set to a value
	//Output: n/a
	//Post Condition: the string is reversed
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void reverseString(){
		StringBuilder myString = new StringBuilder(statement);
		statement = myString.reverse().toString();
		
	}
	
	// ~~~~~ 3PIO Comments for getString method ~~~~~//
	//Purpose: get the string
	//Input: n/a
	//Pre Condition: the statement is set to a value
	//Output: string
	//Post Condition: the string is returned
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public String getString(){
		return statement;
	}
	
	// ~~~~~ 3PIO Comments for setString method ~~~~~//
	//Purpose: set the string
	//Input: string
	//Pre Condition: constructor is created and method is called
	//Output: n/a
	//Post Condition: the string is set to the given value
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void setString(String inStatement){
		statement = inStatement;
	}
	
	
}