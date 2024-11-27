package it.giannotti;

import java.sql.Date;

public abstract class AbstractArtwork implements Artwork {
    private String title, artist;
    private Date date;

    public AbstractArtwork() {

    }

    public AbstractArtwork(String title, String artist, Date date) {
        this.title = title;
        this.artist = artist;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "title=" + title + ", artist=" + artist + ", date=" + date;
    }

}
