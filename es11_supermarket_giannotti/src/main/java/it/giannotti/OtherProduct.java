package it.giannotti;

import java.time.LocalDate;

public class OtherProduct extends AbstractProduct {
    private Material material;

    public OtherProduct(int id, double price, String desc, Material material) {
        super(id, price, desc);
        this.material = material;
    }

    @Override
    public String toString() {
        return "OtherProduct [" + super.toString() + ", material=" + material + "]";
    }

    public LocalDate getExpiry() {
        return null;
    }

    public Material getMaterial() {
        return material;
    }
}
