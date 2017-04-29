
/*
=========================================================
			Homework 03
	author: Jerome Gifford
	class: CS166 t/th
	program description: Recreate the popular game
	rock, paper, scissors vs. the computer. More detail
	is in teh READ ME.txt file
	input:
	process:
	output
=========================================================
*/

import java.util.*;

public class hw03{
	public static void main(String[] args){

	boolean playAgain = true;
		
		//allows the user to play the game again
		while (playAgain){
			
			//-- Establish values for rock, paper, and scissors --//
			int rock = 0;
			int paper = 1;
			int scissors = 2;
			
			/*----------------------------------------------
			Generate the random number for the computer
			 this number is 0, 1, or 2 corresponding to rock
			paper scissors respectfully 
			------------------------------------------------
			*/
			
			int computerChoice = -1; //set to invalid choice
			computerChoice = (int) Math.floor(Math.random() * 3); //have computer decide on a integer between 0 and 2 inclusive
			
			//-- Ask the User for a selection --//
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Please make a selection");
			System.out.println("Rock (0), Paper(1), Scissors(2)");
			
			int userChoice = sc.nextInt();
			
			while (userChoice != rock && userChoice != paper && userChoice != scissors){
				System.out.println("User Choice: " + userChoice);
				System.out.println("Please make a valid selection");
				System.out.println("Rock (0), Paper(1), Scissors(2)");
			
				userChoice = sc.nextInt();
			}
			
			//-- Output header --//
			System.out.println("");
			System.out.println("Rock......");
			System.out.println("Paper.....");
			System.out.println("Scissors..");
			System.out.println("....SHOOT!");
			System.out.println("");
			
			//-- Decide who won --//
			if (computerChoice == userChoice) {
				System.out.println("DRAW!");
			}
			if (computerChoice == 0 && userChoice == 1){
				System.out.println("The computer chose rock. You chose paper");
				System.out.println("Paper covers Rock. You WIN!");
			}
			if (computerChoice == 0 && userChoice == 2){
				System.out.println("The computer chose rock. You chose scissors");
				System.out.println("Rock breaks scissors. You LOSE!");
			}
			if (computerChoice == 1 && userChoice == 0){
				System.out.println("The computer chose paper. You chose rock");
				System.out.println("Paper covers Rock. You LOSE!");
			}
			if (computerChoice == 1 && userChoice == 2){
				System.out.println("The computer chose paper. You chose scissors");
				System.out.println("Scissors cut Paper. You WIN!");
			}
			if (computerChoice == 2 && userChoice == 0){
				System.out.println("The computer chose scissors. You chose rock");
				System.out.println("Rock breaks scissors. You WIN!");
			}
			if (computerChoice == 2 && userChoice == 1){
				System.out.println("The computer chose scissors. You chose paper");
				System.out.println("Scissors cut Paper. You LOSE!");
			}
			
			//-- Ask to play again--//
			Scanner again = new Scanner(System.in);
			
			System.out.println("");
			System.out.println("Play Again? (Y = 1 , N = 0)");
			
			int playAgainAnswer = again.nextInt();
			
			//-- test responce and loop or end program --//
			if (playAgainAnswer == 0 || playAgainAnswer == 0){
				playAgain = false;
			}
		}	
	}
}