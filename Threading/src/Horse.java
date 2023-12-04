import java.util.Random;
//For this class i used implements runnable as 1 of 3 ways to create a thread
public class Horse implements Runnable {
    String name;
    int time;
    Random r = new Random();
//Constructor
    public Horse(String x) {
        name = x;
        time = r.nextInt(2000)+3000;//this creates a random value between 2 set numbers
    }

    public void run() {
        try {
            Thread.sleep(time);//waits the alloted time before printing out the finish message
            System.out.printf("%s finished in %d milliseconds\n", name, time);//prints out how long it took to finish the race
        } catch (Exception e) {
        }
    }
}