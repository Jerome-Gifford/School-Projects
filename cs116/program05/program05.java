/* ==================================
	author: Jerome Gifford
	class: cs116 t/th
	description: Program 05
	input: Read in a file called people.program05 and a user input to search through the file
	process: divide up each line of the file by string and then search for user input in each string 
	output: recombine each line of the file that included the user input and display it. 
	=================================
*/
import java.io.*;
import java.util.*;

public class program05{
	
	public static void main(String[] args) throws IOException{
			
			//-- Ask for input --//
			System.out.println("Please Enter A Search Criteria: ");
			Scanner sc = new Scanner(System.in);
			String input = sc.next();
			
			//-- Get the file --//
			File file = new File("people.program05");
			
			//Creates a FileReader Object
			FileReader fr = new FileReader(file);
			String str1 = ""; //first name
			String str2 = ""; //last name
			String str3 = ""; //address #
			String str4 = ""; //address street
			String str5 = ""; //street type
			int counter = 1;
			char[] a = new char[5000];
			fr.read(a); //reads the content to the array
			for(char c : a)
				if (c== ' ' || c== '\n') {
					//increase the counter until it is at the end of the line in the People file
					if (counter == 1){
						counter = 2;
					}
					else if (counter == 2){
						counter = 3;
					}
					else if (counter == 3){
						counter = 4;
					}
					else if (counter == 4){
						counter = 5;
					}
					else{
						// Test to see if the user input is the same as one of the pieces of a line in the People file
						if (str1.equals(input) || str2.equals(input)  || str3.equals(input)  || str4.equals(input)  || str5.equals(input) ){
							System.out.println(str1 + " " + str2 + " " + str3 + " "+ str4 + " " + str5);
						}
						//reset the counter and the string variables
						counter = 1;
						str1 = "";
						str2 = "";
						str3 = "";
						str4 = "";
						str5 = "";
					}
				}
				else{
					//store each string
					if (counter ==1)
						str1 += c;
					else if (counter == 2)
						str2 += c;
					else if (counter == 3)
						str3 += c;
					else if (counter == 4)
						str4 += c;
					else
						str5 += c;		
				}
			fr.close();
	}
}
