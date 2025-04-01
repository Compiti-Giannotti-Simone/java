package it.giannotti;

import static java.lang.Thread.sleep;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MenToilet {

    private static Lock l = new ReentrantLock();
    private static Random r = new Random(System.nanoTime());

    public static void useToilet(Customer c) throws InterruptedException {
        l.lock();
        System.out.println("Il cliente " + c.getName() + " è entrato nel bagno degli uomini");
        sleep(r.nextInt(5000) + 2000);
        System.out.println("Il cliente " + c.getName() + " è uscito dal bagno");
        l.unlock();
    }
}
