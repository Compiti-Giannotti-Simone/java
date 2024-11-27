package it.giannotti;

import java.time.LocalDate;

public class FoodProduct extends AbstractProduct {

    private LocalDate expiry;

    public FoodProduct(String name, double price, int stock, LocalDate expiry) {
        super(name, price, stock);
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "FoodProduct [" + super.toString() + ", expiry=" + expiry + "]";
    }
}
