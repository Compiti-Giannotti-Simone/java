package it.giannotti;

public class Point {
    private int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }
    
    public boolean equals(Point p) {
        return this.x == p.x && this.y == p.y;
    }

    public double distance(Point p) {
        int a = Math.abs(this.x-p.x);
        int b = Math.abs(this.y-p.y);
        return Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));
    }
}
