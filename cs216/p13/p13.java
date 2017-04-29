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
// ASSIGNMENT NUMBER: #13
//
// DUE DATE:
//
// POSSIBLE POINTS: 10 Points
//
//PURPOSE: Use a priority queue to display the order of print jobs for a given printer and calculate the
// amount of time it takes to print all of the jobs, including paper refills.
//*********************************************************************************************

import java.io.*;
import java.util.*;

public class p13 {
	
    public static void main(String[] args) {
			Scanner inFile = new Scanner(System.in);
			PriorityQueue<PrintJob> q = new PriorityQueue<PrintJob>(10, new PriorityComp());
			int time = 0;
			int pages = 0;
			
			//add each print job to queue
			while (inFile.hasNext()){
				PrintJob pj = new PrintJob();
				pj.getDataFromFile(inFile);
				q.offer(pj);
			}
			
			printHeader();
			
			time += 2 * (q.size() - 1); // 2 seconds between jobs
			
			//print each PrintJob
			while (q.size() > 0){
				PrintJob pj = q.poll();
				pages += pj.getNumOfPage();
				time += pj.getNumOfPage(); //each page takes 1 sec to print
				
				if( pages > 100){
					System.out.println("~~~~~> Add papers to printer!");
					time += 120; // 2 minutes to add paper
					pages = 0;
					System.out.println(pj);
				}
				else{
				System.out.println(pj);
				}
				
			}
			
			calcTime(time);
			
	} //end of main
	
	public static void printHeader(){
		System.out.printf("%-9s %-11s %-11s %-8s\n","User","Course Name","Num Of Page", "Priority");
		System.out.printf("%-9s %-11s %-11s %-8s\n","----","-----------","-----------", "--------");
	}
	
	public static void calcTime(int time){
		int minutes = 0;
		int seconds = 0;
			
		//calc time and print
		minutes = time / 60;
		seconds = time % 60;
		System.out.println("Total Time: " +  minutes + " minutes " + seconds + " seconds");
	}

	
}