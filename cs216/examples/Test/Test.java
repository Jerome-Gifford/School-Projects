public class Test{	
	public static void main(String[] args){
	xMethod(5);
		
	}
 public static void xMethod(int length) {

    while (length > 1) {

      System.out.print((length - 1) + " ");

      xMethod(length - 1);

    }

  }

}
