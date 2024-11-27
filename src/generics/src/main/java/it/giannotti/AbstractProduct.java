package it.giannotti;

public abstract class AbstractProduct implements ProductOperations {

    private String name;
    private double price;
    private int stock;
    
    public AbstractProduct(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void restock(int amount) {
        this.stock += amount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "name=" + name + ", price=" + price + ", stock=" + stock;
    }

}
