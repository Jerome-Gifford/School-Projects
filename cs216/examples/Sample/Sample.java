import java.io.*;
import java.util.*;

public class Sample{
  public static void main(String[] args) {
  
	Scanner inFile = new Scanner(System.in);
	int num = 0;
	String statement = "";
			
			
	while (inFile.hasNext{
		statement = inFile.next();
		int length = statement.length();
		while(length > 0){
			num = statement.length() - statement.replace(statement.substring(0,1), "").length();
			//calc !
			
			statement = statement.replace(statement.substring(0,1), "");
			length = statement.length();
		}
	}
  }
}