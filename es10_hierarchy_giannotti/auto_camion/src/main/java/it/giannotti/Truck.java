package it.giannotti;

public class Truck extends Vehicle {

    public Truck(String brand, String model, String plate, int registration_year) {
        super(brand, model, plate, registration_year);
    }

    @Override
    public String toString() {
        return "Truck " + super.toString();
    }


}
