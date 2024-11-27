package it.giannotti;

public class Car extends Vehicle {
    
    public Car(String brand, String model, String plate, int registration_year) {
        super(brand, model, plate, registration_year);
    }

    @Override
    public String toString() {
        return "Car " + super.toString();
    }
}
