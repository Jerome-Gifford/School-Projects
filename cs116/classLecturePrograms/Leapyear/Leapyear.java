import java.util.*; //grabs all of the java  libraries.
class Leapyear {  //Class name must be the same as the file name
	
	//Every java program must have a main method or static
	public static void main(String [] args) {
		
		//Tell the user to enter a year
		System.out.println("Enter a year:");
	
		//Computer grabs the users input
		Scanner sc = new Scanner(System.in);
	
		//Input is stored in memory in the year variable
		int year = sc.nextInt();

		//Print test line for debugging
		System.out.println("This is a test: " + year);

		//--Initial Variables--//
		boolean leapyear = false; 

		//print results
		if (year % 4 == 0){ //is the year evenly divided by 4 with no remained
			leapyear = true;

			//output for debugging
			System.out.println("Leapyear4: " + leapyear);
		}
		if (year % 100 == 0) { //is the year evenly divided by 100 with no 
								// remainders?
			leapyear = false;

			//output for debugging
			System.out.println("Leapyear100: "  + leapyear);
		}
		if (year % 400 ==0) { //is the year evenly divided by 400 witn no
								//remainder?
			leapyear = true;

			//output for debugging
			System.out.println("Leapyear400: " + leapyear);
		}
		if (leapyear == true) { 
			System.out.println(year + " is a leapyear");
		}
		else{
			System.out.println(year + " is not a leapyear");
		}
	}//closes Public main
}//closes  class
