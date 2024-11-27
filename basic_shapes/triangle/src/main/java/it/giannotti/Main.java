package it.giannotti;

public class Main {

    private static Point p1 = new Point(2, 2);
    private static Point p2 = new Point(6, 3);
    private static Point p3 = new Point(5, 6);
    private static Point p4 = new Point(9,1);
    private static Point p5 = new Point(13, 1);
    private static Point p6 = new Point(11, 5);

    private static Triangle t1 = new Triangle(p1, p2, p3);
    private static Triangle t2 = new Triangle(t1);
    private static Triangle t3 = new Triangle(p4, p5, p6);
    public static void main(String[] args) {
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());

        System.out.println("t1 == t2 -> " + t1.equals(t2));
        System.out.println("t2 == t3 -> " + t1.equals(t3));
        System.out.println("area t1 = " + t1.area());
        System.out.println("area t3 = " + t3.area());
        System.out.println("perimetro t1 = " + t1.perimeter());
        System.out.println("perimetro t3 = " + t3.perimeter());
        
        
    }
}