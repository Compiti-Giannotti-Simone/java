package it.giannotti;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            new Thread(new Driver("D" + i)).start();
        }
    }
}