package it.giannotti;

public class Book extends Readable {

    String author, genre;

    public Book(int pages, String title, String author, String genre) {
        super(pages,title);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book [" + super.toString() + ", author=" + author + ", genre=" + genre + "]";
    }
}
