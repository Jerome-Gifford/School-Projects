/*
Arrays 
*/
 import java.util.Scanner;
 
public class example05{	
	
	public static void main(String[] args){
	
	//declare variables
	int[] arr = new int[100];
	double average = 0;
	int sum = 0;
	int count = 0;
	
	//populate array and compute average
	Scanner sc = new Scanner(System.in);
	
	for (int i = 0; i < arr.length; i++){
		arr[i] = sc.nextInt();
		sum += arr[i];
	}
	
	average = sum / (double) arr.length;
	
	//count the number of array elements above average
	for (int i = 0; i < arr.length; i++){
		if (arr[i] > average){
			count += 1;
		}
	}
	
	//print information
	System.out.println("Average of Numbers: " + average);
	System.out.println("Numbers greater than Average: " + count);
	
	}
}
	