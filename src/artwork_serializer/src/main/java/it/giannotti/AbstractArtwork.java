package it.giannotti;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Sculpture.class, name = "sculpture"),
        @JsonSubTypes.Type(value = Painting.class, name = "painting"),
        @JsonSubTypes.Type(value = Installation.class, name = "installation")
})

public abstract class AbstractArtwork {
    private String title, artist;
    private int year;

    public AbstractArtwork() {

    }

    public AbstractArtwork(String title, String artist, int year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "title=" + title + ", artist=" + artist + ", year=" + year;
    }

}
