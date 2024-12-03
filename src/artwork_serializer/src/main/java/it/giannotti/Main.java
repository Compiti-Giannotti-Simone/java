package it.giannotti;

import java.io.IOException;

public class Main {

    // public static BufferedReader keyboard = new BufferedReader(new
    // InputStreamReader(System.in));
    public static Museum m = new Museum();

    public static void main(String[] args) throws IOException {

        m.addArtwork(new Painting("t1", "a1", 1999, "s1"));
        m.addArtwork(new Sculpture("t2", "a2", 2025, "m1"));
        m.addArtwork(new Installation("t3", "a1", 1000, 100, 5));

        m.saveToFile();

        m.loadFromFile();

        System.out.println(m.toString());
    }
}