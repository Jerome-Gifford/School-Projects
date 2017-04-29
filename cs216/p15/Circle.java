import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class Circle implements Comparable<Circle>
{
  private int id;
  private double radius;

  public Circle() 
  {
    id = -111;
    radius = 0;
  }

  public Circle(int inId) 
  {
    id = inId;
    radius = 0;
  }

  public Circle(int inId, double inRadius) 
  {
    this.id = inId;
    this.radius = inRadius;
  }

  public void getDataFromFile(Scanner inFile)
  {
    id = inFile.nextInt();
    radius = inFile.nextDouble();
    inFile.nextLine();
  }

  public void printCircle()
  {
    System.out.printf("%-6d %-5.2f %-6.2f %-8.2f\n", id, radius,getPerimeter(), getArea());

  }

  public double getRadius() 
  {
    return radius;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int inId) 
  {
    this.id = inId;
  }

  public void setRadius(double inRadius) 
  {
    this.radius = inRadius;
  }

  public double getArea() 
  {
    return radius * radius * Math.PI;
  }
  
  public double getDiameter() 
  {
    return 2 * radius;
  }
  
  public double getPerimeter() 
  {
    return 2 * radius * Math.PI; 
  }

  @Override
  public String toString() 
  {
    return id + " " +  radius;
  }

  @Override
  public int compareTo(Circle c)
  {
    if (this.id > c.id)
       return 1;
   else
       
     if (this.id == c.id)
        return 0;
     else
        return -1;
   }
}

