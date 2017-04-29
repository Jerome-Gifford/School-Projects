import java.io.*;
import java.util.*;


// ~~~~~ 3PIO Comments for Stack class ~~~~~//
	//Purpose: Create a stack for the numbers/operators
	//Input: Various. Depends on what method is called
	//Pre Condition: The object is created
	//Output: Various. Depends on what method is called
	//Post Condition: Depended upon what method is called
	//Note: n/a
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
public class Stack{
	
	private int[] numbers;
	private char[] elements; 
	private int size;
	public static final int DEFAULT_CAPACITY = 16;
	
	/** Construct a stack with the default capacity 16 */
	public Stack(){
		this (DEFAULT_CAPACITY);
	}
	
	/** Construct a stack with the specified maxium capacity */
	public Stack(int capacity){
		elements = new char[capacity];
		numbers = new int[capacity];
	}
	
	/** Push a new integer to the top of the stack */
	public void pushChar(char value){
		if (size >= elements.length){
			char[] temp = new char [elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}
		
		elements[size++] = value;
	}
	
	/** Return and remove the top element from the stack */
	public char popChar(){
		return elements[--size];
	}
	
	/** Return the top element from the stack */
	public char peekChar(){
		return elements[size - 1];
	}
	
	/** Push a new integer to the top of the stack */
	public void pushInt(int value){
		if (size >= numbers.length){
			int[] temp = new int [numbers.length * 2];
			System.arraycopy(numbers, 0, temp, 0, numbers.length);
			numbers = temp;
		}
		
		numbers[size++] = value;
	}
	
	/** Return and remove the top element from the stack */
	public int popInt(){
		return numbers[--size];
	}
	
	/** Return the top element from the stack */
	public int peekInt(){
		return numbers[size - 1];
	}
	
	/** Test whether the stack is empty */ 
	public boolean empty(){
		return size == 0;
	}
	
	/** Return the number of elements in the stack */
	public int getSize(){
		return size;
	}
	
}