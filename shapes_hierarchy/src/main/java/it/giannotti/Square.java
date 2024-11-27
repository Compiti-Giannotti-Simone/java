package it.giannotti;

public class Square extends Shape{

    double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side; 
    }

    public double getSide() {
        return side;
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
        if (Double.doubleToLongBits(side) != Double.doubleToLongBits(other.side))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Square [side=" + side + "]";
    }

    public void setSide(double side) {
        this.side = side;
    }
}
