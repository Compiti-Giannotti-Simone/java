package it.giannotti;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChangingRoom {

    private int maxPeople = 2;
    private int people = 0;

    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();

    private static ChangingRoom instance = null;

    private ChangingRoom() {
        // Private constructor to prevent instantiation
    }

    public static ChangingRoom getInstance() {
        if (instance == null) {
            instance = new ChangingRoom();
        }
        return instance;
    }

    public void enter(Driver d) throws InterruptedException {
        lock.lock();
        while (people == maxPeople) {
            notFull.await();
        }
        people++;
        System.out.println(d.getName() + " is changing: " + people);
        lock.unlock();
    }

    public void leave(Driver d) throws InterruptedException {
        lock.lock();
        people--;
        System.out.println(d.getName() + " finished changing: " + people);
        notFull.signalAll();
        lock.unlock();
    }
}
