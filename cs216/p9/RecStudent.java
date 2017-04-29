import java.io.*;
import java.util.*;

class RecStudent extends Student implements RecConsts, Recommandable, ConstValues{	
	// ~~~~~ 3PIO Comments for RecStudent no args constructos ~~~~~//
		//Purpose: create constructor with default values
		//Input: none.
		//Pre Condition: program compiles.
		//Output:  none.
		//Post Condition: constructor is created
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public RecStudent(){
		super();
	}
	
	// ~~~~~ 3PIO Comments for RecStudent two args constructos ~~~~~//
		//Purpose: create constructor with given values
		//Input: none.
		//Pre Condition: program compiles.
		//Output:  none.
		//Post Condition: constructor is created
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public RecStudent(int inId, int inExam){
		super.setId(inId);
		super.setExam(inExam);
	}
	
	// ~~~~~ 3PIO Comments for findRecommandation ~~~~~//
		//Purpose: get recomendation
		//Input: none.
		//Pre Condition: data is valid
		//Output:  string
		//Post Condition: recomendation is determined
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public String findRecommandation(){
		if (super.getExam() == upperA)
			return TopRec;
		else if (super.getExam() >= lowerA && super.getExam() < upperA)
			return ExcRec;
		else if (super.getExam() >= lowerB && super.getExam() < lowerA)
			return Rec;
		else
			return WorkHarder;
	}
	
	// ~~~~~ 3PIO Comments forprintHowToRecommand ~~~~~//
		//Purpose: print recomendation
		//Input: none.
		//Pre Condition: data is determined and valid
		//Output:  none.
		//Post Condition: recomendation is printed
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void printHowToRecommand(){
		System.out.printf("    %-20s\n", this.findRecommandation());
	}
}