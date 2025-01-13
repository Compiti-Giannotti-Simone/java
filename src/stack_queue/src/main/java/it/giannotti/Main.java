package it.giannotti;

import java.sql.Date;
import java.time.LocalDate;

import it.giannotti.books.Cookbook;
import it.giannotti.books.Ebook;
import it.giannotti.books.GraphicNovel;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Ebook(17, 2, "Libro elettronico", "Uomo elettronico", "json"));
        library.addBook(new GraphicNovel(999, 6942069, "Ultime lettere di Jacopo Candela", "Ugo Pinolo", "Giovanni"));
        library.addBook(new Cookbook(101010, 7, "Le migliori ricette con Giovanna Pina", "Giovanna Pina", "Tutto"));

        library.addPerson(new Person("Mario", "Rossi", Date.valueOf(LocalDate.now())));
        library.addPerson(new Person("Francesco", "Verdi", Date.valueOf(LocalDate.now())));
        library.addPerson(new Person("Valentino", "Blu", Date.valueOf(LocalDate.now())));

        System.out.println(library.assignBook());
    }
}