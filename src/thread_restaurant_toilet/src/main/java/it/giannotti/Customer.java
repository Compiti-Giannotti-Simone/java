package it.giannotti;

public class Customer implements Runnable {

    private boolean isMan;
    private String name;    

    public boolean isMan() {
        return isMan;
    }

    public String getName() {
        return name;
    }

    public Customer(boolean isMan, String name) {
        this.isMan = isMan;
        this.name = name;
    }

    public void run() {
        try {
        if(isMan)
            MenToilet.useToilet(this);
            else WomenToilet.useToilet(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
