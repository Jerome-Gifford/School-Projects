public class TestTV {

  public static void main(String[] args) {

    TV tv1 = new TV();

    TV tv2 = new TV();

 

    tv1.turnOn();

    tv1.setChannel(22);

    tv1.setVolume(4);

    tv2.turnOn();

    tv1.volumeUp();

    tv2.channelUp();

    tv2.channelUp();

    tv1.channelUp();

    tv2.channelDown();

    tv1.channelUp();

    tv2.volumeUp();

    tv1.volumeUp();

    tv1.volumeUp();

    tv2.volumeDown();

 

    System.out.println(tv1.channel + " " + tv1.volumeLevel);

    System.out.println(tv2.channel + " " + tv2.volumeLevel);

  }

}
