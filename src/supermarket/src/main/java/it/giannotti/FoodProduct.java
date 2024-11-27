package it.giannotti;

import java.time.LocalDate;

public class FoodProduct extends AbstractProduct {
    private LocalDate expiry;

    public FoodProduct(int id, double price, String desc, LocalDate expiry) {
        super(id,price,desc);
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "FoodProduct [" + super.toString() + ", expiry=" + expiry + "]";
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    public Material getMaterial() {
        return null;
    }
}
