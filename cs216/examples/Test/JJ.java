public class JJ {

  int i;

  static int s;

 

  public static void main(String[] args) {

    JJ f1 = new JJ();

    System.out.println(f1.i + " " + f1.s);

    JJ f2 = new JJ();

    System.out.println(f2.i + " " + f2.s);

    JJ f3 = new JJ();

    System.out.println(f3.i + " " + f3.s);

  }

 

  public JJ() {

    i++;

    s++;

  }

}

