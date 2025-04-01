package it.giannotti;

import java.util.Random;

public class User implements Runnable {
    private String username;
    private Random random = new Random(System.nanoTime());

    private final Tickets shop = Tickets.getInstance();

    public User(String name) {
        username = name;
    }

    public void run() {
        if(random.nextBoolean()) {
            try {
                shop.sellTicket(this, true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            shop.sellTicket(this, false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
    
}
