// p6.java
//*********************************************************************************************
// YOUR NAME: Jerome Gifford
//
// COURSE TITLE: Computer Programming II
//
// COURSE NUMBER: CS216
//
// PROF NAME: Moe Bidgoli
//
// ASSIGNMENT NUMBER: #6
//
// DUE DATE: 10-17-2016
//
// POSSIBLE POINTS: 10 Points
//
// PURPOSE: Create a GPA report that adds data, deletes data, clears all data, and prints the report when asked based on input.
//*********************************************************************************************

import java.util.*;
import  java.io.*;

public class p6 {

    // ~~~~~ 3PIO Comments for Client side code ~~~~~//
    //Purpose: Create a GPA report that adds data, deletes data, clears all data, and prints the report when asked based on input
    //Input: n/a
    //Pre Condition: the file complies
    //Output: n/a
    //Post Condition: The GPA report is created in an array list. Outputs is displayed based on requested input instructions
    //Note: if no printing is requested and there is still data in the ArrayList the report will print it with a special message
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public static void main(String[] args) {
        Scanner inFile = new Scanner(System.in);
        ArrayList<StudType> report = new ArrayList<StudType>();
        ArrayList<StudType> invalid = new ArrayList<StudType>();
        String status = "";
        int numNotprinted = 0;

        while(inFile.hasNext()){
            StudType st = new StudType();
            status = inFile.next();
            if (status.equals("A")) {
                st.setId(inFile.nextInt());
                st.setName(inFile.next());
                st.setGpa(inFile.nextDouble());
                st.setSex(inFile.next());
                if(st.ValidStudType())
                    report.add(new StudType(st.getId(), st.getName(), st.getGpa(), st.getSex()));
                else
                    invalid.add(new StudType(st.getId(), st.getName(), st.getGpa(), st.getSex()));

                numNotprinted ++;
            }
            else if (status.equals("D")){
                if (report.isEmpty())
                    System.out.println("~~> List is empty! No Delete! ");
                else{
                    st.setId(inFile.nextInt());
                    for (int i = 0; i < report.size(); i++){
                        if (report.get(i).getId() == st.getId())
                            report.remove(i);
                    }
                }
            }
            else if (status.equals("P")){
                if (report.isEmpty())
                    System.out.println("~~> List is empty! No Print! ");
                else {
                    printReport(report, invalid);
                }
                numNotprinted = 0;
            }
            else if (status.equals("C")){
                if (report.isEmpty())
                    System.out.println("~~> List is empty! No Clear! ");
                else
                    report.clear();

                numNotprinted = 0;
            }
        }

        if (report.size() > 0 && numNotprinted > 0){
            System.out.println("Some given data was not printed!! As a courtesy please find the none printed data below!\n");
            printReport(report, invalid);
        }
    }

    // ~~~~~ 3PIO Comments for printStart Method ~~~~~//
    //Purpose: print the first line of the Report
    //Input: n/a
    //Pre Condition: the file complies
    //Output: n/a
    //Post Condition: the first line of the Report is printed
    //Note: n/a
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public static void printStart(){
        System.out.println("<~~~~~~~~~~~~~~        GPA Report      ~~~~~~~~~~~~~~~>");
    }

    // ~~~~~ 3PIO Comments for printHeader Method ~~~~~//
    //Purpose: Print the column names for the report
    //Input: n/a
    //Pre Condition: the file compiles
    //Output: n/a
    //Post Condition: the column names for the report are printed
    //Note: n/a
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public static void printHeader(){
        System.out.printf("\n%-3s %-15s %-4s %-3s\n", "Id", "Name", "GPA", "Sex");
        System.out.printf("%-3s %-15s %-4s %-3s\n", "---", "---------------", "----", "---");
    }

    // ~~~~~ 3PIO Comments for printEnd Method ~~~~~//
    //Purpose: Print the end line of the report
    //Input: n/a
    //Pre Condition: the file compiles
    //Output: n/a
    //Post Condition: the end line of the report is printed
    //Note: n/a
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public static void printEnd(){
        System.out.println(">>>*  End  Of GPA Report *<<<\n");
    }

    // ~~~~~ 3PIO Comments for printReport ~~~~~//
    //Purpose: print the report
    //Input: ArrayList<StudType>, ArrayList<StudType>
    //Pre Condition: the ArrayList are divided into valid and invalid.
    //Output: n/a
    //Post Condition: the report is printed
    //Note: n/a
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public static void printReport(ArrayList<StudType> report, ArrayList<StudType> invalid ){
        printStart();
        //print invalid
        for (int i = 0; i < invalid.size(); i++) {
            System.out.println(invalid.get(i).getId() + " " + invalid.get(i).getName() + " " +
                    invalid.get(i).getGpa() + " " + invalid.get(i).getSex() + " **** invalid data");
        }
        printHeader();
        // print valid
        for (int i = 0; i < report.size(); i++) {
            System.out.printf("%3d %-15s %.2f %3s\n", report.get(i).getId(), report.get(i).getName(), report.get(i).getGpa(), report.get(i).getSex());
        }
        printEnd();
    }

}
