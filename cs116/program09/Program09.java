/*=========================
author: Jerome Gifford
file: Program09.java
Program: Program09
Description: Create a program that has a StopWatch class and calculated
time between the start and finish of sorting some amount of numbers
Class: CS116 t/th
Input: input.data for number of numbers to generate
Process: 
	1. Declare Variables
	2. Generate array of 100000 numbers
	3. start stop watch
	4. sort numbers
	5. stop stop watch
	6. Print Elapsed Time
Output: Print Elapsed Time
============================*/

import java.io.*;
import java.util.*;

public class Program09 {
	
	public static int number;
		
    /**
     * @param args the command line arguments
	 * 	precondition: input.data must exist in the same subdirectory where
	 * 	program is executed 
	 * 	postcondition: the screen is displaying the elapsed time
     */
    public static void main(String[] args) throws IOException{
        // 1. Declare Variables
        StopWatch sw = new StopWatch();
		Scanner sc = new Scanner(new File("input.data"));
		number = sc.nextInt();
        int[] array = new int [number];
        // 2. Generate array of 100000 numbers
        array = generate100000();
        
        // 3. start stop watch
        sw.start();
        // 4. sort numbers
        doSelectionSort(array);
        // 5. stop stop watch
        sw.stop();
       
        // 6. Print Elapsed Time
        System.out.println("Time to generate " + number + " numbers: " +  sw.getElapsedTime() + "ms");
                
    }
    
    /**
     *  Generate an array of 100000 random integers
     *  @param
	 * 	precondition: Empty Array
	 * 	postcondition: Array popluated with random numbers 1 to user input
     */
    public static int[] generate100000(){
        int[] array = new int [number];
        for (int i = 0; i < number; i++){
            array[i] = (int)(number * Math.random());
        }
        return array;
    }
    
     /**
     *  @author http://www.java2novice.com/java-sorting-algorithms/selection-sort/
     *  @param arr
	 * 	precondition: unsorted Array
	 * 	postcondition: Array is sorted
     */
    public static int[] doSelectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index]; 
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }
    
} //end class Program09

class StopWatch{
    private static long startTime;
    private static long endTime;
    
    StopWatch(){
        startTime = System.currentTimeMillis();
    }
    
    public static long getStartTime(){
        return startTime;
    }
    
    public static long getEndTime(){
        return endTime;
    }
    
    public static void start(){
        startTime = System.currentTimeMillis();
    }
    
    public static void stop(){
        endTime = System.currentTimeMillis();
    }
    
    public static long getElapsedTime(){
        return endTime - startTime;
    }
    
}