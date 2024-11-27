package it.giannotti;

public class Main {
    public static void main(String[] args) {

        Dictionary d = new Dictionary();

        d.addWord("Tavolo", "Table");
        d.addWord("Gatto", "Cat");
        d.addWord("Cane", "Dog");
        d.addWord("Casa", "House");

        System.out.println(d.toString().replace(", ", "\n").replace("{", "{\n").replace("}", "\n}"));

        System.out.println(d.translateWord("Gatto"));
        System.out.println(d.translateWord("Ciao"));
    }
}