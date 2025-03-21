package it.giannotti;

import static java.lang.Thread.sleep;

public class CountUp implements Runnable {

    public void run() {
        for (int i=1; i <= 10; i++) {
            System.out.println(i);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
