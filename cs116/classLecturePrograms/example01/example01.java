

import java.util.*;

public class example01 { 
	public static void main(String[] args){
		//-- Grade Calculator w/ IF's --//
		
		/* COMMENTING OUT FOR ANOTHER EXAMPLE TO FOLLOW
		//-- Declare Variables --//
		double score = 0.0;
		char grade = '~'; 
		
		//-- Get user input for score --//
		System.out.print("Please Enter a Score: ");
		Scanner sc = new Scanner(System.in);
		score = sc.nextDouble(); //accepts the input the user provided. 
		
		//-- Validate user input --//
		if (score > 100 || score < 0){
			System.out.println("Error: Please enter a valid score (0 - 100)"); // lets the user know the issue
			System.exit(-1); // Exits the program
		}
		
		//-- Determine grade --//
		if ( score >= 90){
			grade = 'A'; // gives the resulting score an A grade
		}
		else if (score >= 80 && score < 90){
			grade = 'B'; // gives the resulting score an B grade
		}
		else if (score >= 70 && score < 80){
			grade = 'C'; // gives the resulting score an C grade
		}
		else if (score >= 60 && score < 70){
			grade = 'D'; // gives the resulting score an D grade
		}
		else if (score >= 0 && score < 60){
			grade = 'F'; // gives the resulting score an F grade
		}
		
		//-- Print results --//
		System.out.println("Score Entered: " + score);
		System.out.println("Grade: " + grade);
		*/
		
		
		
		//-- Grade Calculator w/ Switch --//
		
		//-- Declare Variables --//
		double userScore = 0;
		char grade = '~'; 
		int score = 0; //notice how the score is now a int to take advantage of int /
		
		//-- Get user input for score --//
		System.out.print("Please Enter a Score: ");
		Scanner sc = new Scanner(System.in);
		userScore = sc.nextDouble(); //accepts the input the user provided. 
		score = (int) userScore; // converts user input to int 
		
		//-- Validate user input --//
		if (score > 100 || score < 0){
			System.out.println("Error: Please enter a valid score (0 - 100)"); // lets the user know the issue
			System.exit(-1); // Exits the program
		}
		
		//-- Determine grade --//
		 score = score / 10; // int division removes fraction
		  switch (score) { 
			case 10:
			case 9:
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7: 
				grade = 'C';
				break;
			case 6:
				grade = 'D';
				break;
			default:
				grade = 'F';
				break;
		  }
		
		//-- Print results --//
		System.out.println("Score Entered: " + userScore);
		System.out.println("Grade: " + grade);
		
	}
}