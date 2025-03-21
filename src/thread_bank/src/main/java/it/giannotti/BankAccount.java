package it.giannotti;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lombok.Data;

@Data
public class BankAccount {
    private int balance;
    private static BankAccount instance = null;

    private final Lock l = new ReentrantLock();
    private final Condition balanceAvailable = l.newCondition();

    public static BankAccount getInstance() {
        if (instance == null)
            instance = new BankAccount();
        return instance;
    }

    private BankAccount() {
        balance = 50;
    }

    public void deposit(int amount) {
        l.lock();
        try {
            balance += amount;
            System.out.println("+" + amount + " -> " + balance);
            balanceAvailable.signal();
        } finally {
            l.unlock();
        }
    }

    public void withdraw(int amount) throws InterruptedException {
        l.lock();
        try {
            while (balance < amount) {
                balanceAvailable.await();
            }
            balance -= amount;
            System.out.println("-" + amount + " -> " + balance);
        } finally {
            l.unlock();
        }
    }
}
