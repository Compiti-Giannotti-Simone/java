package it.giannotti;

public class Magazine extends Readable {

    String type;

    public Magazine(int pages, String title, String type) {
        super(pages,title);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Magazine [" + super.toString() + ", type=" + type + "]";
    }
}
