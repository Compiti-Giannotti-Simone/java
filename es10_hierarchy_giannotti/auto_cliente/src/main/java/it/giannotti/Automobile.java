package it.giannotti;

public class Automobile {
    private int license_plate;
    private Customer owner;

    public Automobile(int license_plate, Customer owner) {
        this.license_plate = license_plate;
        this.owner = owner;
    }
}
