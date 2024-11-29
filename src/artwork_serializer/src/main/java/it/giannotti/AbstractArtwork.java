package it.giannotti;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Sculpture.class, name = "sculpture"),
        @JsonSubTypes.Type(value = Painting.class, name = "painting")
})


public abstract class AbstractArtwork {
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

    public abstract String getType();

    @Override
    public String toString() {
        return "title=" + title + ", artist=" + artist + ", date=" + date;
    }

}
