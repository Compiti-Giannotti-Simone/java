package it.giannotti.books;

public class GraphicNovel extends AbstractBook {
    private String illustrator;

    public GraphicNovel(int pages, int isbn, String title, String author, String illustrator) {
        super(pages, isbn, title, author);
        this.illustrator = illustrator;
    }

    public String getType() {
        return "graphicnovel";
    }

    public String getIllustrator() {
        return illustrator;
    }

    public void setIllustrator(String illustrator) {
        this.illustrator = illustrator;
    }

    @Override
    public String toString() {
        return "GraphicNovel [illustrator=" + illustrator + "]";
    }

    
}
