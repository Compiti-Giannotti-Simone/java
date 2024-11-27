package it.giannotti;

public class Square {

    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    private double perimeter;
    private double area;

    public Square(Point p1, Point p3) {
        this.p1 = p1;
        this.p3 = p3;
        this.p2 = findPointX();
        this.p4 = findPointY();
        this.perimeter = this.preimeter();
        this.area = this.area();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Square other = (Square) obj;
        if (p1 == null) {
            if (other.p1 != null)
                return false;
        } else if (!p1.equals(other.p1))
            return false;
        if (p3 == null) {
            if (other.p3 != null)
                return false;
        } else if (!p3.equals(other.p3))
            return false;
        if (Double.doubleToLongBits(perimeter) != Double.doubleToLongBits(other.perimeter))
            return false;
        if (Double.doubleToLongBits(area) != Double.doubleToLongBits(other.area))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Square [p1=" + p1.toString() + ", p2=" + p2.toString() + ", p3=" + p3.toString() + ", p4="
                + p4.toString() + ", perimeter=" + perimeter + ", area="
                + area + "]";
    }

    private Point findPointX() {
        return new Point(this.p1.getX(), this.p3.getY());
    }

    private Point findPointY() {
        return new Point(this.p3.getX(), this.p1.getY());
    }

    private double preimeter() {
        return p1.distance(p3) * Math.sqrt(2) * 2;
    }

    private double area() {
        return (Math.pow(p1.distance(p3), 2)) / 2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    public Point getP4() {
        return p4;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

}
