package it.giannotti;

import static java.lang.Thread.sleep;

import java.util.Random;

public class Restocker implements Runnable {

    private final Tickets shop = Tickets.getInstance();

    private Random r = new Random(System.currentTimeMillis());

    public void run() {
        while (true) {
            try {
                sleep(100);
                int a = r.nextInt(50);
                System.out.println("restocking " + a + " tickets");
                shop.restockTickets(a);
                sleep(100);
                if(shop.getAmount() > 0) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

