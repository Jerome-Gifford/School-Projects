// ~~~~~ 3PIO Comments for Triangle class ~~~~~//
//Purpose: Create a triangle that is a child of the Geometric Object class
//Input: n/a
//Pre Condition: file complies
//Output: n/a
//Post Condition: Various. Depends on the method that is called
//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
public class Triangle extends GeometricObject{
		private int side1;
		private int side2;
		private int side3;
		
		// ~~~~~ 3PIO Comments for no args constructor ~~~~~//
		//Purpose: create a Triangle object
		//Input: n/a
		//Pre Condition: file complies and the constructor is called
		//Output: n/a
		//Post Condition: A Triangle object is created with default sides
		//Note: n/a
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		public Triangle(){
			side1 = 0;
			side2 = 0;
			side3 = 0;
		}
		
		// ~~~~~ 3PIO Comments for three args constructor ~~~~~//
		//Purpose: create a Triangle object
		//Input: int, int, int
		//Pre Condition: file complies and the constructor is called with the three sides
		//Output: n/a
		//Post Condition:  A Triangle object is created with given sides
		//Note: n/a
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		public Triangle(int side1, int side2, int side3){
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}
		
		// ~~~~~ 3PIO Comments for getSide1 ~~~~~//
		//Purpose: Return the length of side 1
		//Input: n/a
		//Pre Condition: the side is set
		//Output: int
		//Post Condition: the length of the side is returned
		//Note: n/a
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		public int getSide1(){
			return side1;
		}
		
		// ~~~~~ 3PIO Comments for getSide2 ~~~~~//
		//Purpose: Return the length of side 2
		//Input: n/a
		//Pre Condition: the side is set
		//Output: int 
		//Post Condition: the length of the side is returned
		//Note: n/a
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		public int getSide2(){
			return side2;
		}
		
		// ~~~~~ 3PIO Comments for getSide3 ~~~~~//
		//Purpose: Return the length of side 3
		//Input: n/a
		//Pre Condition: the side is set
		//Output: int
		//Post Condition: the length of the side is returned
		//Note: n/a
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		public int getSide3(){
			return side3;
		}
		
		// ~~~~~ 3PIO Comments for getArea ~~~~~//
		//Purpose: return the Area of the Triangle
		//Input: n/a
		//Pre Condition: the sides are set
		//Output: double
		//Post Condition: The Area of the Triangle is returned
		//Note: n/a
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		public double getArea(){
			double p = (side1 + side2 + side3) / 2.0;
			return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
		}
		
		// ~~~~~ 3PIO Comments for getPerimeter ~~~~~//
		//Purpose: return the Perimeter of the Triangle
		//Input: n/a
		//Pre Condition: the sides are set
		//Output: int
		//Post Condition: The Perimeter of the Triangle is returned
		//Note: n/a
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		public int getPerimeter(){
			return side1 + side2 + side3;
		}
}