package it.giannotti;

import java.time.LocalDate;

public abstract class AbstractProduct {
    private int id;
    private double price;
    private String desc;

    public AbstractProduct(int id, double price, String desc) {
        this.id = id;
        this.price = price;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public abstract Material getMaterial();
    public abstract LocalDate getExpiry();
    
    @Override
    public String toString() {
        return "id= " + id + ", price=" + price + ", desc=" + desc;
    }

    
}
