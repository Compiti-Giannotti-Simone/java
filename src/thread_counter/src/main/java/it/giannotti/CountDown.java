package it.giannotti;

import static java.lang.Thread.sleep;

public class CountDown implements Runnable {
    public void run() {
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
            try {
                sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
