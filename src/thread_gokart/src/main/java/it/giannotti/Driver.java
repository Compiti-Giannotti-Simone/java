package it.giannotti;

import static java.lang.Thread.sleep;
import java.util.Random;

public class Driver implements Runnable {

    private String name;
    private Track track = Track.getInstance();
    private ChangingRoom changingRoom = ChangingRoom.getInstance();

    private Random random = new Random(System.nanoTime());

    private int laps = 0;
    private int maxLaps = 15;

    public Driver(String name) {
        this.name = name;
    }

    public void run() {
        try {
            changingRoom.enter(this);
            sleep(random.nextInt(2000) + 1000);
            changingRoom.leave(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            track.enter(this);
            while (laps < maxLaps) {
                laps++;
                System.out.println(name + " is on lap: " + laps);
                sleep(random.nextInt(1000) + 1000);
            }
            track.leave(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            changingRoom.enter(this);
            sleep(random.nextInt(2000) + 1000);
            changingRoom.leave(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

}
