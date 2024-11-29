package it.giannotti;

public class Painting extends AbstractArtwork {
    private String style;

    public Painting() {
        
    }

    public Painting(String title, String artist, int year, String style) {
        super(title,artist,year);
        this.style = style;
    }

    @Override
    public String toString() {
        return "Painting ["+ super.toString() + ", style=" + style + "]";
    }

    public String getType() {
        return "painting";
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    
}
