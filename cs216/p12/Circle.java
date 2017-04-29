import java.io.*;
import java.util.*;

class Circle {
	// ~~~~~ 3PIO Comments for Circle ~~~~~//
		//Purpose: create a circle obj with Area, Radius, Perimeter, and Diameter
		//Input: Various, depending upon method called
		//Pre Condition: the code compiles
		//Output: Various, depending upon method called
		//Post Condition: The circle and fields are created and calculated
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	private int id;
	private double radius;
	
	public Circle(){
		id = 0; 
		radius = 0;
	}
	
	public Circle(int inId, double inRadius){
		id = inId;
		radius = inRadius;
	}
	
	public void getDataFromFile(Scanner inFile){
		id = inFile.nextInt();
		radius = inFile.nextDouble();
	}
	
	public void printCircle(){
		System.out.printf("%-9d %-6.2f %-9.2f  %-5.2f\n", this.getId(), this.getRadius(), this.getPerimeter(), this.getArea());
	}
	
	public double getRadius(){
		return radius;
	}
	
	public int getId(){
		return id;
	}
	
	public void setRadius(double inRadius){
		radius = inRadius;
	}
	
	public void setId (int inId){
		id = inId;
	}
	
	public double getArea(){
		return Math.PI * Math.pow(radius, 2); 
	}
	
	public double getDiameter(){
		return 2 * radius;
	}
	
	public double getPerimeter(){
		return 2 * Math.PI * radius;
	}
	
	public String toString(){
		return  String.valueOf(this.getId()) + String.valueOf(this.getRadius()) + String.valueOf(this.getPerimeter()) + String.valueOf(this.getArea());
	}
}