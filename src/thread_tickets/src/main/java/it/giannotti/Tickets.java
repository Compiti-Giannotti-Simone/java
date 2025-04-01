package it.giannotti;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Tickets {

    private static Tickets instance;

    private Lock l = new ReentrantLock();
    private Condition yesTickets = l.newCondition();
    private Condition noTickets = l.newCondition();

    private int amount = 100;

    public static Tickets getInstance() {
        if (instance == null)
            instance = new Tickets();
        return instance;
    }

    private Tickets() {
    }

    public ReturnMessage sellTicket(User user, boolean buyTwo) throws InterruptedException {
        l.lock();
        if(buyTwo) {
            while(amount < 2) {
                noTickets.signal();
                yesTickets.await();
            }
            amount -= 2;
            sleep((long) Math.random() * 100);
        } else {
            while (amount <= 0) {
                noTickets.signal();
                yesTickets.await();
            }
            amount--;
            sleep((long) Math.random() * 100);
        }
        l.unlock();
        System.out.println("Ci sono " + amount + " biglietti rimanenti");
        return new ReturnMessage(0, "Biglietto comprato con successo");
    }

    public void restockTickets(int n) throws InterruptedException {
        l.lock();
        while (amount > 0) {
            noTickets.awaitNanos(100000000);
        }
        amount += n;
        yesTickets.signalAll();
        l.unlock();
    }

    public int getAmount() {
        return amount;
    }
}