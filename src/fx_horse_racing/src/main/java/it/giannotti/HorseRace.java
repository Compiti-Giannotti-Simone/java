package it.giannotti;

import javafx.application.Platform;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class HorseRace {

    private CountDownLatch latch = new CountDownLatch(5);

    private final PrimaryController controller;

    private final ArrayList<Horse> leaderboard = new ArrayList<>();

    private Horse horse1, horse2, horse3, horse4, horse5;

    public HorseRace(PrimaryController controller) {
        this.controller = controller;
        horse1 = new Horse(controller,1,leaderboard,latch);
        horse2 = new Horse(controller,2,leaderboard,latch);
        horse3 = new Horse(controller,3,leaderboard,latch);
        horse4 = new Horse(controller,4,leaderboard,latch);
        horse5 = new Horse(controller,5,leaderboard,latch);
    }

    public ArrayList<Horse> getLeaderboard() {
        return leaderboard;
    }

    public Horse getHorse2() {
        return horse2;
    }

    public Horse getHorse4() {
        return horse4;
    }

    public Horse getHorse3() {
        return horse3;
    }

    public Horse getHorse1() {
        return horse1;
    }

    public Horse getHorse5() {
        return horse5;
    }

    public void restartRace() {
        leaderboard.clear();
        latch = new CountDownLatch(5);
        horse1 = new Horse(controller,1,leaderboard,latch);
        horse2 = new Horse(controller,2,leaderboard,latch);
        horse3 = new Horse(controller,3,leaderboard,latch);
        horse4 = new Horse(controller,4,leaderboard,latch);
        horse5 = new Horse(controller,5,leaderboard,latch);
    }

    public void startRace() {

        new Thread(horse1).start();
        new Thread(horse2).start();
        new Thread(horse3).start();
        new Thread(horse4).start();
        new Thread(horse5).start();

        new Thread( () -> {
            try {
                latch.await();
                Platform.runLater(controller::endRace);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
