package it.giannotti;

import java.sql.Date;

public class Sculpture extends AbstractArtwork {
    private String material;

    public Sculpture() {

    }

    public Sculpture(String title, String artist, Date date, String material) {
        super(title, artist, date);
        this.material = material;
    }

    @Override
    public String toString() {
        return "Sculpture [" + super.toString() + ", material=" + material + "]";
    }

    public String getType() {
        return "sculpture";
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

}
