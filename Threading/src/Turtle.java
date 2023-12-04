import java.util.Random;
//For this class i used extends Thread as 1 of 3 ways to create a thread
public class Turtle extends Thread {
    String name;
    int time;
    Random r = new Random();
//Constructor
    public Turtle(String x) {
        name = x;
        time = r.nextInt(4000)+6000;//this creates a random value between 2 set numbers
    }

    public void run() {
        try {
            Thread.sleep(time);//waits the alloted time before printing out the finish message
            System.out.printf("%s finished in %d milliseconds\n", name, time);//prints out how long it took to finish the race
        } catch (Exception e) {
        }
    }
}