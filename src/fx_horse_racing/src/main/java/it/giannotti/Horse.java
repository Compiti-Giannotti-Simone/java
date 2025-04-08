package it.giannotti;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Horse implements Runnable {
    private int progress = 0;
    private int id;

    private PrimaryController controller;

    public Horse(PrimaryController controller, int id) {
        this.controller = controller;
        this.id = id;
    }

    @Override
    public void run() {
        Random r = new Random();
        while(progress < 100) {
            r.setSeed(System.nanoTime());
            progress += r.nextInt(3);
            controller.updateBars();
            try {
                sleep(r.nextInt(500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return;
    }

    public int getProgress() {
        return progress;
    }
}
