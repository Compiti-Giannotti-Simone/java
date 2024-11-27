package it.giannotti;

public class Vehicle {

    private String license, brand, model;
    private int seats, id;
    private static int counter = 0;
    public Vehicle(String license, String brand, String model, int seats) {
        this.license = license;
        this.brand = brand;
        this.model = model;
        this.seats = seats;
        id = counter;
        counter++;
    }
    

    
    @Override
    public String toString() {
        return "Vehicle [license=" + license + ", brand=" + brand + ", model=" + model + ", seats=" + seats + ", id="
                + id + "]";
    }



    public String getLicense() {
        return license;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getSeats() {
        return seats;
    }
    public int getId() {
        return id;
    }

    
}
