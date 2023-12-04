import java.util.Random;
/*
Dhruv Chaudhary
Period 8 3/15/21
Threading Assignment
 */
public class Main {
    /*
    This Program uses threads to run multiple races at the same time. it uses 3 different animals that all have different speeds and starts their race
    at the same time. It randomly generates how fast each animal goes between a set field of numbers. The whole point is to showcase how threading lets
    you run multiple things all at the same time without them interfering with each other.
     */
    public static void main(String[] args) {
        Random r = new Random();//used later when setting speed for animals
        Thread h1 = new Thread(new Horse("Horse 1"));//creates all the instances of the classes for horses and turtles since they use their own seperate class
        Thread h2 = new Thread(new Horse("Horse 2"));
        Thread h3 = new Thread(new Horse("Horse 3"));
        Thread h4 = new Thread(new Horse("Horse 4"));
        Thread t1 = new Thread(new Turtle("Turtle 1"));
        Thread t2 = new Thread(new Turtle("Turtle 2"));
        Thread t3 = new Thread(new Turtle("Turtle 3"));
        Thread t4 = new Thread(new Turtle("Turtle 4"));
        Thread c1 = new Thread() {//Each Cheetah is created within the actual main method by calling the thread class which is 1 of 3 ways of creating a thread
            public void run() {
                try {
                    int time = r.nextInt(500)+1000;
                    Thread.sleep(time);
                    System.out.println("Cheetah 1 finished in "+time+" milliseconds");
                } catch (Exception e) {
                }
            }
        };
        Thread c2 = new Thread() {
            public void run() {
                try {
                    int time = r.nextInt(500)+1000;
                    Thread.sleep(time);
                    System.out.println("Cheetah 2 finished in "+time+" milliseconds");
                } catch (Exception e) {
                }
            }
        };
        Thread c3 = new Thread() {
            public void run() {
                try {
                    int time = r.nextInt(500)+1000;
                    Thread.sleep(time);
                    System.out.println("Cheetah 3 finished in "+time+" milliseconds");
                } catch (Exception e) {
                }
            }
        };
        Thread c4 = new Thread() {
            public void run() {
                try {
                    int time = r.nextInt(500)+1000;
                    Thread.sleep(time);
                    System.out.println("Cheetah 4 finished in "+time+" milliseconds");
                } catch (Exception e) {
                }
            }
        };
        System.out.println("Start!");//prints out the start message as the threads all start
        c1.start();//all the threads are started at the same time
        c2.start();
        c3.start();
        c4.start();
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
