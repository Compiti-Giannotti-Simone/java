package it.giannotti;

public class Main {
    public static void main(String[] args) {
        Library<Readable> libreria = new Library<>();
        for (int i = 0; i < 15; i++) {
            int pages = Math.round((float) Math.random() * 100);
            String title = "titolo" + i;
            String author = "tizio" + i;
            String genre = "genere" + i;
            libreria.add(new Book(pages, title, author, genre));
        }
        for (int i = 15; i < 30; i++) {
            int pages = Math.round((float) Math.random() * 100);
            String title = "titolo" + i;
            String author = "tizio" + i;
            String genre = "genere" + i;
            libreria.add(new Manga(pages, title, author, genre));
        }
        for (int i = 30; i < 45; i++) {
            int pages = Math.round((float) Math.random() * 100);
            String title = "titolo" + i;
            String type = "tipo" + i;
            libreria.add(new Magazine(pages, title, type));
        }
        System.out.println(libreria.toString());
        libreria.remove("titolo1");
        System.out.println(libreria.toString());
        try {
            libreria.get("titolo104");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}