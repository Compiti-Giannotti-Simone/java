package it.giannotti;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Track {

    private int maxCars = 4;
    private int cars = 0;

    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();

    private static Track instance = null;

    private Track() {
        // Private constructor to prevent instantiation
    }

    public static Track getInstance() {
        if (instance == null) {
            instance = new Track();
        }
        return instance;
    }

    public void enter(Driver d) throws InterruptedException {
        lock.lock();
        try {
            while (cars >= maxCars) {
                notFull.await();
            }
            cars++;
            System.out.println(d.getName() + " entered track: " + cars);
        } finally {
            lock.unlock();
        }
    }

    public void leave(Driver d) throws InterruptedException {
        lock.lock();
        try {
            cars--;
            System.out.println(d.getName() + " finished race: " + cars);
            notFull.signal();
        } finally {
            lock.unlock();
        }
    }
}
