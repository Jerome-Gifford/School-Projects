import java.util.*;

public class example04{
	
	public static int number = 0;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter a number: ");
		number = sc.nextInt();
		
		plusTwo(number);
		divideFive(number);
		timesTwentyFive(number);
		
	}
	
	public static void plusTwo(int zippy){
		System.out.println("Your number plus 2 is:  ");
		System.out.println(number + 2);
	}
	
	public static void divideFive(int number){
		System.out.println("Your number divided by 5 is:  ");
		System.out.println(number / 5.0);
	}
	
	public static void timesTwentyFive(int number){
		System.out.println("Your number times 25 is:  ");
		System.out.println(number * 25);
	}
}