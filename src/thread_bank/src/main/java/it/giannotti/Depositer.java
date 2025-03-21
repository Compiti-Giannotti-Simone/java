package it.giannotti;

import static java.lang.Thread.sleep;

public class Depositer implements Runnable {
    private BankAccount b = BankAccount.getInstance();

    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
                int amount = (int) (Math.random() * 40) + 10;
                b.deposit(amount);
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
