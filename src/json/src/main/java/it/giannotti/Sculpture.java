package it.giannotti;

import java.sql.Date;

public class Sculpture extends AbstractArtwork {
    private String material;

    public Sculpture(String title, String artist, Date date, String material) {
        super(title,artist,date);
        this.material = material;
    }

    @Override
    public String toString() {
        return "Sculpture ["+ super.toString() + ", material=" + material + "]";
    }
}
