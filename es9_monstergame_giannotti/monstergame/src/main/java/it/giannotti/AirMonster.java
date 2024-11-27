package it.giannotti;

public class AirMonster extends Monster {

    private static double CRIT = 0.20;

    @Override
    public String getType() {
        return "Air";
    }

    @Override
    public double getCrit() {
        return CRIT;
    }


}
