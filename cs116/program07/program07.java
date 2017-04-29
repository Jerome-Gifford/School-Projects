/* ==================================
	author: Jerome Gifford
	class: cs116 t/th
	description: Program 07
	input:
	process:
	output: 
	=================================
*/
import java.util.*;
import java.io.*;

public class program07{
	public static void main(String[] args) throws IOException{
		//-- Delcare Variables --//
		int[] arr = new int[10];
		int counter = 0;
		int temp;
		boolean swap = true; // allows the loop to go through at least once
		
		//-- Load the input file, input.data --//
		Scanner sc = new Scanner(new File("input.data")); //grabs the file
		while(sc.hasNext()){ 
			arr[counter] = sc.nextInt(); // loads the file into the array 
			counter += 1;
		}
		
		//-- Test Numbers and reorder --//
		while (swap){
			
			swap = false; // set swap to false so we can see if a swap happens

			for (int i = 0; i < arr.length - 1; i++){
				
				if (arr[i] < arr[i + 1]){
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					swap = true;
				}
				
			}
			
		}
		
		//-- Print Results --//
		for (int i = 0; i < arr.length - 1; i++){
			if ((arr[i] % 3) == 0){
			System.out.println(arr[i] + " (divisible by 3)");
			}
			else{
			System.out.println(arr[i]);
			}
		}
	}
}