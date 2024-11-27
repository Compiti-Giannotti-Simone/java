package it.giannotti;

public class WaterMonster extends Monster {

    private static double CRIT = 0.40;

    @Override
    public String getType() {
        return "Water";
    }

    @Override
    public double getCrit() {
        return CRIT;
    }

}
