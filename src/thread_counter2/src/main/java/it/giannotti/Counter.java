package it.giannotti;

import static java.lang.Thread.sleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private final Lock l = new ReentrantLock();

    private int number = 0;

    public Counter() {

    }

    public void increment() {
        l.lock();
        try {
            if (number < 100) {
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                number++;
            } else
                throw new RuntimeException("Sono arrivato a " + number);
        } finally {
            l.unlock();
        }
    }

    public int getNumber() {
        return number;
    }

}
