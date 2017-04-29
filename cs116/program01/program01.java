//filename: program01.java
//author: Jerome Gifford, cs 116, t/th
//description: This program prints 5 population levels
//based on Problem 1.11 from the textbook

import java.util.*; //imports the java library

public class program01{  //class name must match file name
	public static void main(String[] args){  // must have main method
		//--Ask the user for the population--//
		System.out.println("Please enter a population:  ");
		
		//create the scanner to read in the users keyboard input
		Scanner sc = new Scanner(System.in); 
		
		//store the users input in the population variables
		int population = sc.nextInt();
	
		//---- Declare variables & Assign values ----//
		//---- other than for user input ----//
		
		//a new child is born ever 7 seconds
		double birthRatePerSecond = 1.0 / 7.0;
		
		//seconds per minute * minutes per hour
		// * hours per day * days per year
		int secondsPerYear = 60 * 60 * 24 * 365; 
	
		// births per second divided by second per year
		// (int) typecast to force the birthsPerYear to be a integer
		int birthsPerYear = (int)(birthRatePerSecond * secondsPerYear);
		
		//Print a blank line to seperate output from user input
		System.out.println("");
		
		//Output formatting
		System.out.println("==== Rates Per Year ====");
		
		//Prints out the number of births per year. Helps for Debugging Purpuses.
		System.out.println("Births Per Year: " + birthsPerYear);
		
		//a person dies every 13 seconds
		double deathRatePerSecond = 1.0 / 13.0;
		
		// deaths per second divided by second per year
		// (int) typecast to focre the deathsPerYear to be an integer
		int deathsPerYear = (int)(deathRatePerSecond * secondsPerYear);
		
		//Prints out the number of deaths per year. Helps for Debugging
		System.out.println("Deaths Per Year: " + deathsPerYear);
		
		//a new immigrant moves to the use every 45 seconds
		double immigrationRatePerSecond = 1.0 / 45.0;
		
		// immirgrants moved to the US per second divided by 
		// seconds per year. (int) typecast to force the immgrationPerYear
		// to be an integer
		int immgrationPerYear = (int)(immigrationRatePerSecond * secondsPerYear);
		
		//Prints out the number of immirgrants per year. Helps for Debugging
		System.out.println("Immgrants Per Year: " + immgrationPerYear);
		
		//Output formatting
		System.out.println("");
		
		//-- Calulate population totals for 5 years and output to user --//
		System.out.println("For a starting population of " + population
							+ " The next 5 years are as follows: ");
							
		//Output formatting
		System.out.println("");
		
		//population for first year after initial year
		population = population + birthsPerYear - deathsPerYear + immgrationPerYear;
		System.out.println("Year 1 Population: " + population);
		
		//population for second year after initial year
		population = population + birthsPerYear - deathsPerYear + immgrationPerYear;
		System.out.println("Year 2 Population: " + population);
		
		//population for third year after initial year
		population = population + birthsPerYear - deathsPerYear + immgrationPerYear;
		System.out.println("Year 3 Population: " + population);
		
		//population for foruth year after initial year
		population = population + birthsPerYear - deathsPerYear + immgrationPerYear;
		System.out.println("Year 4 Population: " + population);
		
		//population for fifth year after initial year
		population = population + birthsPerYear - deathsPerYear + immgrationPerYear;
		System.out.println("Year 5 Population: " + population);
	}
}