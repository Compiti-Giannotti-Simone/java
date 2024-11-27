package it.giannotti;

public class Main {

    private static Point p1 = new Point(4,4);
    private static Point p2 = new Point(0,0);

    private static Square s1 = new Square(p1,p2);
    public static void main(String[] args) {
        System.out.println(s1.toString());
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getArea());
    }
}