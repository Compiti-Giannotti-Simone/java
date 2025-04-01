package it.giannotti;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(new User("U" + i)).start();
        }

        Thread restock = new Thread(new Restocker());
        restock.start();

    }
}