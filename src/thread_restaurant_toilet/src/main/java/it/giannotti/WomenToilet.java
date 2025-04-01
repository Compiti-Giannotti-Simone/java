package it.giannotti;

import static java.lang.Thread.sleep;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WomenToilet {

    private static Lock l = new ReentrantLock();
    private static Random r = new Random(System.currentTimeMillis());

    public static void useToilet(Customer c) throws InterruptedException {
        l.lock();
        System.out.println("La cliente " + c.getName() + " è entrata nel bagno delle donne");
        sleep(r.nextInt(5000)+2000);
        System.out.println("La cliente " + c.getName() + " è uscita dal bagno");
        l.unlock();
    }
}
