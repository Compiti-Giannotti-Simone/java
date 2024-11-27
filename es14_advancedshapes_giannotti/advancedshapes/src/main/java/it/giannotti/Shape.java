package it.giannotti;

public abstract class Shape implements Resizable {
    private String colour;

    public Shape(String colour) {
        this.colour = colour;
    }

    public abstract double calculateArea();

    public String getColour() {
        return this.colour;
    }

    @Override
    public String toString() {
        return "Shape: " + colour + " ";
    }

    public abstract void resize(double factor) throws InvalidFactorException;
}
