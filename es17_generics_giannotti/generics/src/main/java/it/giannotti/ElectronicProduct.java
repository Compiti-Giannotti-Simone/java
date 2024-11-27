package it.giannotti;

public class ElectronicProduct extends AbstractProduct {

    private int insuranceMonths;

    public ElectronicProduct(String name, double price, int stock, int insuranceMonths) {
        super(name, price, stock);
        this.insuranceMonths = insuranceMonths;
    }

    @Override
    public String toString() {
        return "ElectronicProduct [" + super.toString() + ", insuranceMonths=" + insuranceMonths + "]";
    }
}

