package it.giannotti;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            new Thread(new Customer(r.nextBoolean(),"U" + i)).start();
        }
    }
}