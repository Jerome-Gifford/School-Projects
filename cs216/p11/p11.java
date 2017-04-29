// p11.java 
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
//PURPOSE: create a generic array list and print a list of given values and then a list of unique values
// in that list.
//*********************************************************************************************

import java.io.*;
import java.util.*;

public class p11 {
	
    public static void main(String[] args) {
			Scanner inFile = new Scanner(System.in);
			ArrayList<String> list = new ArrayList<>();
			
			
			//load ArrayList
			while(inFile.hasNext())
			{
				list.add(inFile.next());
			}
			
			//print ArrayList
			System.out.println("List with duplicates: " + list);
			
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = list.size() - 1; j > i; j--) {
					if ((list.get(i)).equals(list.get(j))){
						list.remove(i);
						list.remove(j - 1);
					}
				}
			}
			
			//print ArrayList
			System.out.println("Distinct Elements in List: " + list);

	} //end of main
	
}