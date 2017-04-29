//Java HasNext example

import java.util.*;
public class HasNext{
	public static void main(String[] args){
		int a = 123;
		boolean b = true;
		char c = 'C';
		double d = 12300000.456789;
		float f = 123.456f;
		String s = ""; //print string
		String n = "name";
		
		
		for (int i = 0; i < 5; i++){
		System.out.printf("%10d %8.4f \n",a,d);
		}
		
		//Scanner sc = new Scanner(System.in);
		//String name = "";
		//char gender = ' ';
		//int id = 0;
		//float score = 0.0f;
		//while (sc.hasNext()){
		//	name = sc.next();
		//	gender = sc.next();
		//	id = sc.nextInt();
		//	score = sc.nextFloat();
		//	System.out.printf("Last name: %-10s score: %8.2f \n", name, score);
		//}
	}
}