package it.giannotti;

import javafx.application.Platform;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

public class Horse implements Runnable {
    private int progress = 0;
    private final int id;

    private final ArrayList<Horse> leaderboard;
    private final CountDownLatch latch;

    private final PrimaryController controller;

    public Horse(PrimaryController controller, int id, ArrayList<Horse> leaderboard, CountDownLatch latch) {
        this.controller = controller;
        this.id = id;
        this.leaderboard = leaderboard;
        this.latch = latch;
    }

    @Override
    public void run() {
        Random r = new Random();
        while(progress < 100) {
            r.setSeed(System.nanoTime());
            progress += r.nextInt(2)+1;
            Platform.runLater(controller::updateBars);
            try {
                sleep(r.nextInt(500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        leaderboard.add(this);
        latch.countDown();
    }

    public int getProgress() {
        return progress;
    }
    public int getId() {
        return id;
    }
}
