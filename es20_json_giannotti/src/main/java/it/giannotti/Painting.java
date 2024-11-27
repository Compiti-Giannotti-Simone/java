package it.giannotti;

import java.sql.Date;

public class Painting extends AbstractArtwork {
    private String style;

    public Painting(String title, String artist, Date date, String style) {
        super(title,artist,date);
        this.style = style;
    }

    @Override
    public String toString() {
        return "Painting ["+ super.toString() + ", style=" + style + "]";
    }

    
}
