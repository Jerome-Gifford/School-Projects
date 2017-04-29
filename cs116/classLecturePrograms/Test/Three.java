import java.util.*;
public class Three {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter a Byte: ");
		byte var1 = sc.nextByte();
		System.out.println("Enter a Long: ");
		long var2 = sc.nextLong();
		System.out.println("Enter a Float: ");
		float var3 = sc.nextFloat();
		System.out.println("Enter population: ");
		int population = sc.nextInt();
		System.out.println("Enter area: ");
		double area = sc.nextDouble();
		System.out.println("Enter type of government: ");
		String government = sc.next();
		String output;
		output = "Population is: " + population;
		output = output + ", Area is: " + area;
		output = output + ", Government is: " + government;
		output = output + ", Byte is: " + var1;
		output = output + ", Long is: " + var2;
		output = output + ", Float is: " + var3;
        System.out.println(output);
    }
}
