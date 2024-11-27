package it.giannotti;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Museum m = new Museum();

        // m.addArtwork(new Painting("t1", "a1", Date.valueOf(LocalDate.now()), "s1"));
        // m.addArtwork(new Sculpture("t2", "a2", Date.valueOf(LocalDate.now()), "m1"));

        // m.saveToFile();

        m.loadFromFile();

        m.toString();

    }
}