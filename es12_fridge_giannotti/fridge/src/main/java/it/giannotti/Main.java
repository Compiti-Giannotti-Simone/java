package it.giannotti;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Fridge f = new Fridge();

        f.readFromFile();

        // Product p1 = new Product(1, 100, "a", Date.valueOf(LocalDate.now()));
        // Product p2 = new Product(2, 255, "b", Date.valueOf(LocalDate.ofYearDay(2024 + (int)Math.round(Math.random()*5), (int)Math.round(Math.random()*365))));
        // Product p3 = new Product(3, 1231, "c", Date.valueOf(LocalDate.ofYearDay(2024 + (int)Math.round(Math.random()*5), (int)Math.round(Math.random()*365))));
        // Product p4 = new Product(1, 100, "a", Date.valueOf(LocalDate.ofYearDay(2024 + (int)Math.round(Math.random()*5), (int)Math.round(Math.random()*365))));
        // Product p5 = new Product(3, 1231, "c", Date.valueOf(LocalDate.ofYearDay(2024 + (int)Math.round(Math.random()*5), (int)Math.round(Math.random()*365))));

        // f.addProduct(p1);
        // f.addProduct(p2);
        // f.addProduct(p3);
        // f.addProduct(p4);
        // f.addProduct(p5);
        // f.saveToFile();

        System.out.println(f.getProduct(1, Date.valueOf(LocalDate.now())).toString());
        System.out.println("Prodotti scaduti:" + f.getExpiredProducts().toString().replace("]", "").replace("[", ""));
        System.out.println(f.toString().replace("]", "").replace("[", ""));

        System.out.println("Ci sono " + f.getProductTotal(1) + " prodotti con id 1");
    }
}