package it.giannotti;

import java.text.DecimalFormat;

public class Main {

    private static final DecimalFormat df = new DecimalFormat("#.##");
    public static void main(String[] args) {
        ShapeManager m = new ShapeManager();

        Shape s1 = new Circle(3, "Green");
        Shape s2 = new Rectangle(4, 2, "Red");
        Shape s3 = new Triangle(4, 3, "Blue");

        System.out.println(s1.toString());
        System.out.println("Area: " + df.format(s1.calculateArea()));
        System.out.println(s2.toString());
        System.out.println("Area: " + df.format(s2.calculateArea()));
        System.out.println(s3.toString());
        System.out.println("Area: " + df.format(s3.calculateArea()));

        m.addShape(s1);
        m.addShape(s2);
        m.addShape(s3);

        System.out.println("Area totale: " + df.format(m.calculateTotalArea()));

        try {
            System.out.println("\nProva resize con fattore 2");
            m.resizeAll(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(s1.toString());
        System.out.println("Area: " + df.format(s1.calculateArea()));
        System.out.println(s2.toString());
        System.out.println("Area: " + df.format(s2.calculateArea()));
        System.out.println(s3.toString());
        System.out.println("Area: " + df.format(s3.calculateArea()));

        try {
            System.out.println("\nProva resize con fattore -1");
            m.resizeAll(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}