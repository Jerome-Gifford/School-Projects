// Exercise1813.java 
//*********************************************************************************************
// YOUR NAME: Jerome Gifford
//
// COURSE TITLE: Computer Programming II
//
// COURSE NUMBER: CS216
//
// PROF NAME: Moe Bidgoli
//
// ASSIGNMENT NUMBER: #10
//
// DUE DATE:
//
// POSSIBLE POINTS: 10 Points
//
//PURPOSE: find the largest number in an array
//*********************************************************************************************

import java.io.*;
import java.util.*;

public class Exercise1813 {
	
    public static void main(String[] args) {
			Scanner inFile = new Scanner(System.in);
			while(inFile.hasNext())
			{
				int i = 0;
				int arr[] = new int[10];
				while (i < 10){
					arr[i] = inFile.nextInt();
					i ++;
				}
				
				System.out.println(findMax(arr, arr.length - 1));
			}

	} //end of main
	
	public static int findMax(int[] a, int index) {
		if (index > 0) {
			return Math.max(a[index], findMax(a, index-1));
		} 
		else {
			return a[0];
		}
	}
}