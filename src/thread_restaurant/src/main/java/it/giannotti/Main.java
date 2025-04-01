package it.giannotti;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Cook()).start();
            new Thread(new Waiter()).start();
        }
    }
}