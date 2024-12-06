package it.giannotti.books;

public abstract class AbstractBook {
    private int pages, isbn;
    private String title, author;

    public AbstractBook() {

    }
    
    public AbstractBook(int pages, int isbn, String title, String author) {
        this.pages = pages;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public int getIsbn() {
        return isbn;
    }
    
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    
    @Override
    public String toString() {
        return "title=" + title + ", author=" + author + ", pages=" + pages + ", isbn=" + isbn;
    }

}
