package it.giannotti;

public abstract class Readable {
    int pages;
    String title;
    public Readable(int pages, String title) {
        this.pages = pages;
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "pages=" + pages + ", title=" + title;
    }
}
