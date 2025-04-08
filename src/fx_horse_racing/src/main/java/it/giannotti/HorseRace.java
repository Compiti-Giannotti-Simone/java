package it.giannotti;

public class HorseRace {
    private PrimaryController controller;

    private Horse h1 = new Horse(this,1);
    private Horse h2 = new Horse(this,2);
    private Horse h3 = new Horse(this,3);
    private Horse h4 = new Horse(this,4);
    private Horse h5 = new Horse(this,5);

    public HorseRace(PrimaryController controller) {
        this.controller = controller;
    }

    public void startRace() {
        new Thread(h1).start();
        new Thread(h2).start();
        new Thread(h3).start();
        new Thread(h4).start();
        new Thread(h5).start();
    }
}
