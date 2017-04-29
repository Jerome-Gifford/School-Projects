/* ==================================
	author: Jerome Gifford
	class: cs116 t/th
	description: Quiz 02
	input: n/a
	process: increament a number and find out when the first digit is greater than the second
	output:print the number only when the first digit is greater
	=================================
*/
import java.util.*;

public class quiz02{
	
	public static void main(String[] args) {
		//-- declare variables --//
		int digit1 = 0;
		int digit2 = 0;
		int number = digit2 * 10 + digit2;
		
		while (number < 100){
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
	}
}