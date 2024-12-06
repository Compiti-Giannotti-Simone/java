package it.giannotti.books;

public class Ebook extends AbstractBook {
    private String file_format;

    public Ebook(int pages, int isbn, String title, String author, String file_format) {
        super(pages, isbn, title, author);
        this.file_format = file_format;
    }

    public String getType() {
        return "ebook";
    }

    public String getFile_format() {
        return file_format;
    }

    public void setFile_format(String file_format) {
        this.file_format = file_format;
    }

    @Override
    public String toString() {
        return "Ebook [file_format=" + file_format + "]";
    }

    
}
