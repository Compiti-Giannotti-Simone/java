package it.giannotti;

public class Vehicle {
    protected String brand, model, plate;
    protected int registration_year;

    public Vehicle(String brand, String model, String plate, int registration_year) {
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.registration_year = registration_year;
    }

    @Override
    public String toString() {
        return " [brand=" + brand + ", model=" + model + ", plate=" + plate + ", registration_year="
                + registration_year + "]";
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getPlate() {
        return plate;
    }

    public int getRegistration_year() {
        return registration_year;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setRegistration_year(int registration_year) {
        this.registration_year = registration_year;
    }

    
    
}
