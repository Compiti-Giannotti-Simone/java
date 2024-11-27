package it.giannotti;

import java.util.ArrayList;
import java.util.List;

public class ShapeManager {
    private List<Shape> shapes;

    public ShapeManager() {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public double calculateTotalArea() {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.calculateArea();
        }
        return sum;
    }

    public void resizeAll(double factor) throws InvalidFactorException {
        for (Shape shape : shapes) {
            shape.resize(factor);
        }
    }
}
