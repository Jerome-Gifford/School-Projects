import java.io.*;
import java.util.*;

public class IllegalTriangleException extends Exception{
	public IllegalTriangleException(){
		
	}
	
	public IllegalTriangleException(String message){
		super(message);
	}
}