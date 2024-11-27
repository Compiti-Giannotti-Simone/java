package it.giannotti;

public class Triangle extends Shape {

    private double base, height;

    public Triangle(double base, double height, String colour) {
        super(colour);
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return (base * height) / 2;
    }

    public void resize(double factor) throws InvalidFactorException {
        if(factor < 0) 
            throw new InvalidFactorException("Il fattore è negativo");
        this.base *= factor;
        this.height *= factor;
    }

    @Override
    public String toString() {
        return super.toString() + "Triangle [base=" + base + ", height=" + height + "]";
    }
    
}
