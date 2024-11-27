package it.giannotti;

public class Manga extends Readable {

    String author, genre;

    public Manga(int pages, String title, String author, String genre) {
        super(pages,title);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Manga [" + super.toString() + ", author=" + author + ", genre=" + genre + "]";
    }

    
}
