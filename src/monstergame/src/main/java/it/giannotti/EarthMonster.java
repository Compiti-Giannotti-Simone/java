package it.giannotti;

public class EarthMonster extends Monster {

    private static double CRIT = 0.30;
    
    @Override
    public String getType() {
        return "Earth";
    }

    @Override
    public double getCrit() {
        return CRIT;
    }


}
