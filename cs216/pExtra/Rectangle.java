import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

// ~~~~~ 3PIO Comments for Rectangle Class ~~~~~//
	//Purpose: create a rectangle object and calculate Area and Perimeter
	//Input:  Various. depends on the method/construstor called
	//Pre Condition: the code complies and the class is called
	//Output:  Various. depends on the method/construstor called
	//Post Condition: Varios. depends on the method/construstor called
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

public class Rectangle{	
	private double width;
	private double height;
	private String color;
	DecimalFormat df = new DecimalFormat("##.##");
	
	// ~~~~~ 3PIO Comments for No Args Constructor ~~~~~//
	//Purpose:  create a Rectangle object
	//Input:  n/a
	//Pre Condition: the code complies and the construstor is called
	//Output:  n/a
	//Post Condition: a Rectangle is created with default values
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public Rectangle(){
		width = 0;
		height = 0;
		color = "";
	}
	
	// ~~~~~ 3PIO Comments for Three Args Constructor ~~~~~//
	//Purpose:  create a Rectangle object with given values
	//Input:  double, double, string
	//Pre Condition:  the code complies and the construstor is called 
	//Output:  n/a
	//Post Condition: A Rectangle is created with the given values
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public Rectangle(double newWidth, double newHeight, String newColor){
		width = newWidth;
		height = newHeight;
		color = newColor;
	}
	
	// ~~~~~ 3PIO Comments for setRec method ~~~~~//
	//Purpose: set the values of the Rectangle
	//Input:   double, double, string
	//Pre Condition: A Rectangle object is created and the method is called
	//Output:  n/a
	//Post Condition: The Rectangles values are updated to the new given values
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void setRec(double inWidth, double inHeight, String inColor){
		width = inWidth;
		height = inHeight;
		color = inColor;
	}
	
	// ~~~~~ 3PIO Comments for setWidth method ~~~~~//
	//Purpose:  set the width for the Rectangle
	//Input:   double
	//Pre Condition: A Rectangle object is created and the method is called
	//Output:   n/a
	//Post Condition: The Rectangles width is updated to the given value
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void setWidth(double inWidth){
		width = inWidth;
	}
	
	// ~~~~~ 3PIO Comments for setHeight method ~~~~~//
	//Purpose: set the height of the Rectangle
	//Input:   double
	//Pre Condition: A Rectangle object is created and the method is called
	//Output:  n/a
	//Post Condition: The Rectangles height is updated to the give value
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void setHeight(double inHeight){
		height = inHeight;
	}
	
	// ~~~~~ 3PIO Comments for setColor method ~~~~~//
	//Purpose: set the color of the Rectangle
	//Input:  string
	//Pre Condition: A Rectangle object is created and the method is called
	//Output:  n/a
	//Post Condition: The Rectangles color is updated to the given value
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void setColor(String inColor){
		color = inColor;
	}
	
	// ~~~~~ 3PIO Comments for getWidth method ~~~~~//
	//Purpose: return the Rectangles width
	//Input:  n/a
	//Pre Condition: A Rectangle object is created and the method is called
	//Output:  double
	//Post Condition: the width of the Rectangle is returned
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public double getWidth(){
		return width;
	}
	
	// ~~~~~ 3PIO Comments for getHeight method ~~~~~//
	//Purpose: return the Rectangles height
	//Input:  n/a
	//Pre Condition: A Rectangle object is created and the method is called 
	//Output:  double
	//Post Condition: the height of the Rectangle is returned
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public double getHeight(){
		return height;
	}
	
	// ~~~~~ 3PIO Comments for getColor method ~~~~~//
	//Purpose:  return the Rectangles color
	//Input:  n/a
	//Pre Condition: A Rectangle object is created and the method is called 
	//Output:  string
	//Post Condition: the color of the Rectangle is returned
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public String getColor(){
		return color;
	}
	
	// ~~~~~ 3PIO Comments for getArea method ~~~~~//
	//Purpose: calculate the Rectangles area
	//Input:  n/a
	//Pre Condition: A Rectangle object is created and the method is called 
	//Output:  double
	//Post Condition: the Rectangles area is returned
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public double getArea(){
		return Double.valueOf(df.format(width * height));
	}
	
	// ~~~~~ 3PIO Comments for getPerimeter method ~~~~~//
	//Purpose: calculate the Rectangles perimeter
	//Input:  n/a
	//Pre Condition: A Rectangle object is created and the method is called 
	//Output:  double
	//Post Condition: the Rectangles perimeter is returned
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public double getPerimeter(){
		return Double.valueOf(df.format((2*width) + (2*height)));
	}
	
	// ~~~~~ 3PIO Comments for printRec method ~~~~~//
	//Purpose: print the Rectangles details
	//Input:  boolean
	//Pre Condition: A Rectangle object is created, the method is called, and the width and height are determined to be valid/invalid
	//Output: n/a
	//Post Condition: The Rectangles details are printout out in the format depending if they are valid or invalid.
	//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void printRec(boolean value){
		if (value)
		System.out.printf("%5s %6s %6s %9s %7s\n", df.format(width), df.format(height), color, df.format(this.getPerimeter()), df.format(this.getArea()));
		else
		System.out.printf("%5s %6s %6s ~~~> Check the data!\n", df.format(width), df.format(height), color);
	}
}