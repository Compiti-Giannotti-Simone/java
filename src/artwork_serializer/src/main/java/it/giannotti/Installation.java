package it.giannotti;

public class Installation extends AbstractArtwork {

    double size, duration;

    public Installation() {

    }

    public Installation(String title, String artist, int year, double size, double duration) {
        super(title, artist, year);
        this.size = size;
        this.duration = duration;
    }

    public String getType() {
        return "installation";
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Installation [" + super.toString() + ", size=" + size + ", duration=" + duration + "]";
    }

}
