package it.giannotti;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Player p1 = generatePlayer("n1", "s1");
        Player p2 = generatePlayer("n2", "s2");
        Player p3 = generatePlayer("n3", "s3");

        try {
            printResults(p1.challenge(p2));
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        try {
            printResults(p2.challenge(p3));
        }
        catch (Exception e) {
            System.err.println(e.toString());
        }    
        try {
            printResults(p1.challenge(p3));
        }
        catch (Exception e) {
            System.err.println(e.toString());
        }    
    }

    private static Player generatePlayer(String name, String surname) {
        Random r = new Random();

        switch (r.nextInt(3)) {
            case 0:
                return new Player(name, surname, new WaterMonster());
            case 1:
                return new Player(name, surname, new EarthMonster());
            case 2:
                return new Player(name, surname, new AirMonster());
        }
        return null;
    }

    private static void printResults(ChallengeResults c) {
        for (String attack : c.getAttacks()) {
            System.out.println(attack);
        }
    }
}
