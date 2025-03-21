package it.giannotti;

public class Main {
    public static void main(String[] args) {
        CountUp c1 = new CountUp();
        CountDown c2 = new CountDown();
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        t1.start();
        t2.start();
    }
}