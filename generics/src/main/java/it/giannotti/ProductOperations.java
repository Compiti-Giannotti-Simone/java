package it.giannotti;

public interface ProductOperations {

    public String getName();
    public double getPrice();
    public int getStock();
    public void restock(int amount);
}
