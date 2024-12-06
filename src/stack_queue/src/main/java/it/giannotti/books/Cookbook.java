package it.giannotti.books;

public class Cookbook extends AbstractBook {
    private String cuisine_type;

    public Cookbook() {
    }

    public Cookbook(int pages, int isbn, String title, String author, String cuisine_type) {
        super(pages, isbn, title, author);
        this.cuisine_type = cuisine_type;
    }

    public String getType() {
        return "cookbook";
    }

    public String getCuisine_type() {
        return cuisine_type;
    }

    public void setCuisine_type(String cuisine_type) {
        this.cuisine_type = cuisine_type;
    }

    @Override
    public String toString() {
        return "Cookbook [" + super.toString() + ", cuisine_type=" + cuisine_type + "]";
    }

    
}
