/* ==================================
	author: Jerome Gifford
	class: cs116 t/th
	description: Quiz 02 Extra Credit
	input: 
	process: 
	output: 
	=================================
*/
import java.util.*;

public class quiz02Extra{
	
	public static void main(String[] args) {
		//-- declare variables --//
		int digit1 = 0;
		int digit2 = 0;
		int number = 0;
		
		//-- ask for number --//
		Scanner sc = new Scanner(System.in);
		System.out.println ("Please enter a lower range: ");
		int lowerLimit = sc.nextInt();
		System.out.println ("Please enter a upper range: ");
		int upperLimit = sc.nextInt();
		
		//-- set number --//
		number = lowerLimit;
		while (number > 99){
		System.out.println (number % 10);
		}
		/*
		while (number > lowerLimit && number < upperLimit){
			
			
			//initial number is tested
			if (digit1 > digit2){
				System.out.println(number) ;
			}
			
			
			if (number % 10 == 9){
			// if digit 1 is larger than digit 2 in 0 to 99
			// then digit 1 will never be great than digit 2
			// again before at least 10 new numbers
			digit1 += 1 ;
			digit2 = 0;
			}
			else{
				//increase number
				digit2 += 1; 
			}
			number = digit1 * 10 + digit2;
		}
		*/
	}
}