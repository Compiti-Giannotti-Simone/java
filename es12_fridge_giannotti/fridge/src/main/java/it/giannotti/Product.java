package it.giannotti;

import java.sql.Date;

public class Product {
    
    private int id, calories;
    private String desc;
    private Date expiry;

    public Product() {

    }
    
    public Product(int id, int calories, String desc, Date expiry) {
        this.id = id;
        this.calories = calories;
        this.desc = desc;
        this.expiry = expiry;
    }

    public int getId() {
        return id;
    }

    public int getCalories() {
        return calories;
    }

    public String getDesc() {
        return desc;
    }

    public Date getExpiry() {
        return expiry;
    }

    @Override
    public String toString() {
        return "\nProduct id=" + id + ", calories=" + calories + ", desc=" + desc + ", expiry=" + expiry; 
    }

    
}
