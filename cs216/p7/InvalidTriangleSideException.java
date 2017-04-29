import java.io.*;
import java.util.*;

public class InvalidTriangleSideException extends Exception{
	public InvalidTriangleSideException(){
		
	}
	
	public InvalidTriangleSideException(String message){
		super(message);
	}
}