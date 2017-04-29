/* ==================================
	author: Jerome Gifford
	class: cs116 t/th
	file name: Program 08.java
	input: a data file with 10 number in it
	process:
		1. Declare Variables
		2. Populate Array
		3. Add One to Even Numbers
		4. Add Two to Odd Indexs
		5. Print Array
		6. Find Min/Max
		7. Find Average
		8. Print MaxMinAvg
		9. Print Elements Greater than 100 in Array
		10. Sort Array
		11. Swap Columns and Rows
		12. Print Sorted Array
	output:  A sorted Array with low to high numbered columns
	=================================
*/
import java.util.*;
import java.io.*;

public class program08{
	public static void main(String[] args) throws IOException{
		 /*================================
				1. Declare Variables
		   ================================*/
		 int[][] arr = new int[10][10];
		 Scanner sc = new Scanner(new File("input.data"));
		 int[][] minmax = new int[2][1]; // min is index [0][0], max is index [1][0]
		 minmax[0][0] = 1000000; // allows minimum to be found
		 double avg = 0.0;
		 int low = 0;
		 int high = arr.length - 1;
		 
		
		 /*================================
				2. Populate Array
		   ================================*/
		arr = getData(sc, arr);
		
		/*================================
			3. Add One to Even Numbers
		   ================================*/
		arr = addOne(arr);
		
		/*================================
			  4. Add Two to Odd Indexs
		   ================================*/
		arr = addTwoToOddIndex(arr);
		
		/*================================
				   5. Print Array
		   ================================*/
		System.out.println("Array after Calculations:");
		printArray(arr);
		
		/*================================
				   6. Find Min/Max
		   ================================*/
		minmax = findMinMax(arr, minmax);
		
		System.out.println();
		/*================================
				   7. Find Average
		   ================================*/
		avg = findAvg(avg, arr);	
		
		/*================================
				  8. Print MaxMinAvg
		   ================================*/
		printmaxminavg(minmax, avg);
		
		/*================================
		9. Print Elements Greater than 100 in Array
		   ================================*/
		printMoreThan100(arr);
		/*================================
		10. Sort Array
		   ================================*/
		arr = quickSort(arr);
		/*================================
		11. Swap Columns and Rows
		   ================================*/
		swapRowsAndColumns(arr);
		/*================================
		12. Print Sorted Array
		   ================================*/
		  System.out.println("Sorted Array:");
		  printArray(arr);
	}
	
	
	/*================================
		     METHOD: getData
	================================*/
	public static int[][] getData(Scanner sc, int[][] arr){
		while(sc.hasNext()){ 
			for (int i = 0; i < 10;i++){
				arr[i][0] = sc.nextInt(); // loads the file into the first column of the array
			}			
		}
		
		//load remaining columns with matching data
		for (int i = 0; i < 10; i++){
				 
				 for (int j = 1; j < 10; j++){
					 arr[i][j] = arr[i][j - 1];
				 }
			 }
		return arr;
	}

	/*================================
		     METHOD: addOne
	================================*/
	public static int[][] addOne(int[][] arr){
		 for (int i = 0; i < arr.length; i++){
			   
				 for (int j = 1; j < arr.length; j++){
					 
					  if ((arr[i][j] % 2) == 0){
						  arr[i][j] = arr[i][j] + 1;
					  }
				 }
			 }
		return arr;
	}
	
	/*================================
		 METHOD: addTwoToOddIndex
	================================*/
	public static int[][] addTwoToOddIndex(int[][] arr){
		 for (int i = 1; i < arr.length; i = i + 2){
			for (int j = 0; j < arr.length; j++){
				arr[i][j] = arr[i][j] + 2;
			}
		}
		return arr;
	}
	
	/*================================
		    METHOD: printArray
	================================*/
	public static void printArray(int[][] arr){
		for(int i = 0; i<10; i++)
			{
				for(int j = 0; j<10; j++)
				{	
				System.out.printf("%3d ", arr[i][j]);
				}
			System.out.println();
			}
	}
	
	/*================================
		 METHOD: findMinMax
	================================*/
	public static int[][] findMinMax(int[][] arr, int[][] minmax){
		// min is index [0][0], max is index [1][0] in minmax array
		 for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr.length; j++){
				if (arr[i][j] > minmax[1][0]){
					minmax[1][0] = arr[i][j];
				}
				else if (arr[i][j] < minmax[0][0]){
					minmax[0][0] = arr[i][j];
				}
			}
		}
		return minmax;
	}
	
	/*================================
		 METHOD: findAvg
	================================*/
	public static double findAvg(double avg, int arr[][]){
		int sum = 0;
		 for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr.length; j++){
				sum += arr[i][j];
			}
		}
		avg = sum / 100.0;
		return avg;
	}
	
	/*================================
		 METHOD: pintmaxminavg
	================================*/
	public static void printmaxminavg(int[][]minmax, double avg){
		System.out.println("Min: " + minmax[0][0]);
		System.out.println("Max: " + minmax[1][0]);
		System.out.println("Avg: " + avg);
	}
	
	/*================================
		 METHOD: printMoreThan100
	================================*/
	public static void printMoreThan100(int[][] arr){
		System.out.println("--- Elements Greater than 100 ---");
		 for (int i = 0; i < arr.length; i++){
				if (arr[i][1] > 100){
					System.out.println(arr[i][1]);
				 }
		}
	}
	
	/*================================
		 METHOD: QuickSort
		 Author: http://www.guideforschool.com/649498-how-to-sort-a-two-dimensional-2d-array/
	================================*/
	public static int[][] quickSort(int arr[][]){
		int t=0;
            for(int x=0;x<10;x++)
            {
                for(int y=0;y<10;y++)
                {
                    for(int i=0;i<10;i++)
                    {
                        for(int j=0;j<10;j++)
                        {
                            if(arr[i][j]>arr[x][y])
                            {
                                t=arr[x][y];
                                arr[x][y]=arr[i][j];
                                arr[i][j]=t;
                            }
                        }
                    }
                }
            }

			
			return arr;

	}
	/*================================
		 METHOD: swapRowsAndColumns 
	================================*/
	public static int[][] swapRowsAndColumns(int arr [][]){
        // transpose
		int[][] temp = new int[10][10];
		for (int i = 0; i < arr.length; i++){
				 for (int j = 1; j < arr.length; j++){
					 temp[i][j] = arr[i][j];
				 }
			 }
			 
        if (temp.length > 0) {
            for (int i = 0; i < temp[0].length; i++) {
                for (int j = 0; j < temp.length; j++) {
                    arr[j][i] = temp[i][j];
                }
            }
        }
		
		 for (int j = 0; j < arr.length; j++) {
                    arr[0][j] = arr[1][j];
                }
				
		return arr;
	}
	
}