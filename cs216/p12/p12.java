// p12.java 
//*********************************************************************************************
// YOUR NAME: Jerome Gifford
//
// COURSE TITLE: Computer Programming II
//
// COURSE NUMBER: CS216
//
// PROF NAME: Moe Bidgoli
//
// ASSIGNMENT NUMBER: #12
//
// DUE DATE:
//
// POSSIBLE POINTS: 10 Points
//
//PURPOSE: Create a LinkedList for Circles and pirnt out. Sort teh LinkedList by ID and Radius and divied into 2 speerate LinkedList
// based on those Circles with radius less than 2 and those 2 or greater.
//*********************************************************************************************

import java.io.*;
import java.util.*;

public class p12 {
	
    public static void main(String[] args) {
			Scanner inFile = new Scanner(System.in);
			
			LinkedList<Circle> list = new LinkedList<Circle>();
			
			//load Circles into Linked List
			while (inFile.hasNext()){
				Circle cr = new Circle();
				cr.getDataFromFile(inFile);
				list.add(cr);
			}

			System.out.println("~~~ Java Linked List Report ~~~");
			printList(list);
			
			//Print List Sorted by ID & Radius
			Collections.sort(list, new IdComp());
			System.out.println("\n~< Linked ListA Sort By Id >~");
			printList(list);
			Collections.sort(list, new RadiusComp());
			System.out.println("\n~< Linked ListA Sort By Radius >~");
			printList(list);
			
			LinkedList<Circle> list2 = new LinkedList<Circle>();
			LinkedList<Circle> list3 = new LinkedList<Circle>();
			
			// Divide List to List2 & List3 by Radius size
			for(Circle cr : list){
				if (cr.getRadius() < 2){
					list2.add(cr);
				}
				else{
					list3.add(cr);
				}
			}
			
			//Print List2 & List3
			System.out.println("\n~< Linked ListB >~");
			printList(list2);
			System.out.println("\n~< Linked ListC >~");
			printList(list3);
			
			//Print List2 & List3 sorted by Id
			Collections.sort(list2, new IdComp());
			System.out.println("\n~< Linked ListB Sort By Id >~");
			printList(list2);
			Collections.sort(list3, new IdComp());
			System.out.println("\n~< Linked ListC Sort By Id >~");
			printList(list3);
			System.out.println("~<<< end >>>~");
			
			
			
	} //end of main
	
	public static void printList(LinkedList<Circle> list){
		if (list.size() > 0){
			printHeader();
			for(Circle cr : list){
					cr.printCircle();
			}
		}
		else{
			System.out.println("No Elements in List");
		}
	}
	
	public static void printHeader(){
		System.out.printf("%9s %6s %9s %5s\n", "Circle ID", "Radius", "Perimeter", "Area");
		System.out.printf("%9s %6s %9s %5s\n", "---------", "------", "---------", "----");
	}
	
}