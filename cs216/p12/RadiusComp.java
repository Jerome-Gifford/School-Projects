import java.io.*;
import java.util.*;

class RadiusComp implements Comparator<Circle>{
 // ~~~~~ 3PIO Comments for Client side code ~~~~~//
		//Purpose: provide comparison for Circle Radi
		//Input: Circle
		//Pre Condition: Circle exists
		//Output: 1, -1
		//Post Condition: Order is determined
		//Note: n/a
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public int compare(Circle c1, Circle c2) {
        if(c1.getRadius() > c2.getRadius()){
            return 1;
        } else {
            return -1;
        }
    }
}