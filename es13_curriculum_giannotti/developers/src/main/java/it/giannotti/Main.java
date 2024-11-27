package it.giannotti;

public class Main {
    public static void main(String[] args) {
        Curriculum c1 = new Curriculum(16, "scuola");
        Curriculum c2 = new Curriculum(2555, "altra scuola");
        Curriculum c3 = new Curriculum(16, "scuola");

        Developer d1 = new MobileDeveloper("Crancesco", "Fapezio", "123123123", 500, "Android", true, c1);
        Developer d2 = new CloudDeveloper("Sario", "Mcialpi", "444444444", 3000, "Google cloud", 10, c2);
        Developer d3 = new CloudDeveloper("Balentino", "Vruni", "6942069420", 2000, "AWS", 7, c3);

        d1.learnNewLanguage("linguaggio 1");
        d2.learnNewLanguage("linguaggio 1");
        d3.learnNewLanguage("linguaggio 1");
        d2.learnNewLanguage("linguaggio 2");
        d3.learnNewLanguage("linguaggio 2");
        d2.learnNewLanguage("linguaggio 3");
        d3.learnNewLanguage("linguaggio 3");

        System.out.println(d1.toString());
        System.out.println(d2.toString());
        System.out.println(d3.toString());

    }
}