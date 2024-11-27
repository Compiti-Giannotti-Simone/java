package it.giannotti;

public class Main {

    private static Point p1 = new Point(3,4);
    private static Point p2 = new Point(p1);
    private static Point p3 = new Point(0,0);
    public static void main(String[] args) {
        System.out.println("" + p1.equals(p2));
        System.out.println("" + p1.distance(p3));
    }
}