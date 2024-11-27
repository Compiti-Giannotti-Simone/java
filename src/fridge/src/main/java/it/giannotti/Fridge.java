package it.giannotti;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Fridge {
    private List<Product> products;

    public Fridge() {
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public Product getProduct(int id, Date expiry) {
        for (Product product : products) {
            if (product.getId() == id && product.getExpiry().equals(expiry)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> getExpiredProducts() {
        List<Product> expired = new ArrayList<>(products);
        expired.removeIf(p -> p.getExpiry().compareTo(Date.valueOf(LocalDate.now())) > 0);
        return expired;
    }

    public int getProductTotal(int id) {
        int count = 0;
        for (Product product : products) {
            if (product.getId() == id)
                count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return "Fridge products:" + products;
    }

    public void saveToFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("save.json");
        try {
            // Serializzazione: scrive l'oggetto nel file JSON
            objectMapper.writeValue(file, products);
            System.out.println("Oggetto serializzato in persona.json");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readFromFile() {
        File file = new File("save.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            products = objectMapper.readValue(file, new TypeReference<List<Product>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
