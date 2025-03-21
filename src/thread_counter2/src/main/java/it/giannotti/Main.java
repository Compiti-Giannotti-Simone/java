package it.giannotti;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread[] threads = new Thread[100];
        for (Thread thread : threads) {
            thread = new Thread(() -> {
                for (;;) {
                    c.increment();
                }
            });
            thread.start();
        }
    }
}