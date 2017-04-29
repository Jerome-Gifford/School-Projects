import java.util.*;
public class Test2{
	public static void main(String[] args){
		//Declare scanner for use later
		Scanner sc = new Scanner(System.in);
		
		//-- Grab varaible numbers --//
		
		System.out.println("Enter a: ");
		int a = sc.nextInt();
		
		System.out.println("Enter b: ");
		int b = sc.nextInt();
		
		System.out.println("Enter c: ");
		int c = sc.nextInt();
		
		System.out.println("Enter x: ");
		int x = sc.nextInt();
		
		System.out.println("Enter y: ");
		int y = sc.nextInt();
		
		//-- Declare variables --//
		double total = 0.0;
		double result1 = 0.0;
		double result2 = 0.0;
		double result3 = 0.0;
		
		// -- Calculate final --//
		result1 =  ( 3.0 + 4.0 * x) / 5.0;
		result2 = 10.0 * ( y - 5.0 ) * ( a + b + c ) / x;
		result3 = 9.0 * ( 4.0 / x + ( 9.0 + x ) / (y * 1.0)) ;
		total = result1 - result2 + result3;
		
		//--Display results and total --//
		System.out.println("Result 1: " + result1);
		System.out.println("Result 2: " + result2);
		System.out.println("Result 3: " + result3);
		System.out.println("Total: " + total);
	}
}