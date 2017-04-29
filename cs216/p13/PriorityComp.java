import java.io.*;
import java.util.*;

class PriorityComp implements Comparator<PrintJob>{
	// ~~~~~ 3PIO Comments for Client side code ~~~~~//
		//Purpose: provide comparison for Print Job Priority
		//Input: PrintJob
		//Pre Condition: PrintJob exists
		//Output: 1,0,-1
		//Post Condition: Order is determined
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public int compare(PrintJob p1, PrintJob p2) {
        if(p1.getPriority() > p2.getPriority()){
            return 1;
        } 
		else if(p1.getPriority() == p2.getPriority()){
            return 0;
        } 
		else {
            return -1;
        }
    }
}