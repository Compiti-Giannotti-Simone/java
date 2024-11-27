package it.giannotti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Warehouse<T> {

    private Map<String, T> products;

    public Warehouse() {
        products = new HashMap<>();
    }

    /**
     * Adds a new product in the warehouse
     */
    public void addNew(String name, T e) {
        products.put(name, e);
    }

    /**
     * Returns T element of the corresponding name key
     */
    public T get(String name) {
        return products.get(name);
    }

    public String toString() {
        return ("\nWarehouse\n" + products).replace("],", "]\n"); 
    }

    /**
     * Returns an unordered ArrayList of all the products in the warehouse
     */
    public ArrayList<T> getArray() {
        ArrayList<T> array = new ArrayList<>();
        for(Map.Entry<String, T> entry : products.entrySet()) {
            array.add(entry.getValue());
        }
        return array;
    }
}
