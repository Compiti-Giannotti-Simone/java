package it.giannotti;

import java.util.Random;

public class Waiter implements Runnable {
    private final Tray tray = Tray.getInstance(); // Singleton instance of Tray

    private Random random = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                tray.take();
                Thread.sleep(random.nextInt(2000)+1000); // Simulate time taken to serve a dish
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}
