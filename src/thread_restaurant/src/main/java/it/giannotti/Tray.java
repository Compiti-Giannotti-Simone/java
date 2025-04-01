package it.giannotti;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tray {

    private int dishes = 0;
    private int maxDishes = 5;

    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    private static Tray instance = null;

    private Tray() {
        // Private constructor to prevent instantiation
    }

    public static Tray getInstance() {
        if (instance == null) {
            instance = new Tray();
        }
        return instance;
    }

    public void put() throws InterruptedException {
        lock.lock();
        try {
            while (dishes == maxDishes) {
                notFull.await();
            }
            dishes++;
            System.out.println("Put dish: " + dishes);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void take() throws InterruptedException {
        lock.lock();
        try {
            while (dishes == 0) {
                notEmpty.await();
            }
            dishes--;
            System.out.println("Take dish: " + dishes);
            notFull.signal();
        } finally {
            lock.unlock();
        }
    }
}
