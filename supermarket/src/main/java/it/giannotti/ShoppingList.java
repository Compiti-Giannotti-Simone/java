package it.giannotti;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private List<AbstractProduct> list;
    private Customer customer;

    public ShoppingList() {
        this.list = new ArrayList<>();
    }

    public void addProduct(AbstractProduct p) {
        list.add(p);
    }

    public double calculatePrice() {
        double discount = 1.00;
        double sum = 0;
        for (AbstractProduct abstractProduct : list) {
            if(customer.isMember()) {
                discount -= 0.05;
                if(abstractProduct.getMaterial() == null && abstractProduct.getExpiry().compareTo(LocalDate.now()) < 10) {
                    discount -= 0.05;
                }
                else if(abstractProduct.getMaterial().isRecyclable()) {
                    discount -= 0.15;
                }
            }
            sum += abstractProduct.getPrice();
        }
        return Math.floor(sum*discount*100)/100;
    }
}
