package it.giannotti;

public class Circle extends Shape {
    
    private double radius;

    public Circle(double radius, String colour) {
        super(colour);
        this.radius = radius;
    }
    
    public double calculateArea() {
        return Math.PI * (Math.pow(radius, 2));
    }

    public void resize(double factor) throws InvalidFactorException {
        if(factor < 0) 
            throw new InvalidFactorException("factor < 0");
        this.radius *= factor;
    }

    @Override
    public String toString() {
        return super.toString() + "Circle [radius=" + radius + "]";
    }
    
}
