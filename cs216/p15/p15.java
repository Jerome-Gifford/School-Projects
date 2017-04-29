// p15.java 
//*********************************************************************************************
// YOUR NAME: Jerome Gifford
//
// COURSE TITLE: Computer Programming II
//
// COURSE NUMBER: CS216
//
// PROF NAME: Moe Bidgoli
//
// ASSIGNMENT NUMBER: #15
//
// DUE DATE:
//
// POSSIBLE POINTS: 10 Points
//
//PURPOSE: create a BST of cicrle and perform modifications to the tree as requested. 
//*********************************************************************************************

import java.io.*;
import java.util.*;

public class p15 {
	
    public static void main(String[] args) {
		Scanner inFile = new Scanner(System.in);
		BST<Circle> tree = new BST<Circle>();
		String status = "";
		
		while (inFile.hasNext()){
			Circle cr = new Circle();
			status = inFile.next();
			if (status.equals("A")){
				cr.getDataFromFile(inFile);
				tree.insert(cr);
			}
			else if (status.equals("D")){
				if(tree.getSize() > 0){
					cr.setId(inFile.nextInt());
					tree.delete(cr);
				}
				else
					System.out.println("Tree is empty! No Print!");
			}
			else if (status.equals("P")){
				if(tree.getSize() > 0){
					System.out.println("\nInorder");
					printHeader();
					tree.inorder();
					System.out.println("\nPreorder");
					printHeader();
					tree.preorder();
					System.out.println("\nPostorder");
					printHeader();
					tree.postorder();
					System.out.println();
				}
				else
					System.out.println("Tree is empty! No Print!");
			}
			else if (status.equals("U")){
				if(tree.getSize() > 0){
					cr.getDataFromFile(inFile);
					tree.update(cr);
				}
				else
					System.out.println("Tree is empty! No Update!");
			}
			else if (status.equals("I")){
				if(tree.getSize() > 0){
					System.out.print("\nNum Of Nodes:");
					System.out.println(tree.getNumOfNodes(tree.getRoot()));
					System.out.print("Num Of Leaves:");
					System.out.println(tree.getNumOfLeaves(tree.getRoot()));
					System.out.print("Tree Height:");
					System.out.println(tree.height(tree.getRoot()));
				}
				else
					System.out.println("Tree is empty! No Information!");
			}
		}
	}
	
	public static void printHeader(){
		System.out.printf("%2s %6s\n", "ID", "Radius");
		System.out.printf("%2s %6s\n", "--", "------");
	}
}