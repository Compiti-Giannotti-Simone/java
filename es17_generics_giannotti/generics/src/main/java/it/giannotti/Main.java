package it.giannotti;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Warehouse<FoodProduct> foodWarehouse = new Warehouse<>();
        Warehouse<ElectronicProduct> electronicWarehouse = new Warehouse<>();

        foodWarehouse.addNew("fp1", new FoodProduct("fp1", 10, 7, LocalDate.ofYearDay(2025, 169)));
        foodWarehouse.addNew("fp2", new FoodProduct("fp2", 7, 3, LocalDate.ofYearDay(2025, 16)));
        foodWarehouse.addNew("fp3", new FoodProduct("fp3", 3, 15, LocalDate.ofYearDay(2025, 97)));
        foodWarehouse.addNew("fp4", new FoodProduct("fp4", 5, 21, LocalDate.ofYearDay(2025, 122)));
        foodWarehouse.addNew("fp5", new FoodProduct("fp5", 9, 14, LocalDate.ofYearDay(2025, 300)));
        System.out.println(foodWarehouse.toString());

        electronicWarehouse.addNew("ep1", new ElectronicProduct("ep1", 70, 12, 12));
        electronicWarehouse.addNew("ep2", new ElectronicProduct("ep2", 150, 9, 20));
        electronicWarehouse.addNew("ep3", new ElectronicProduct("ep3", 50, 4, 6));
        electronicWarehouse.addNew("ep4", new ElectronicProduct("ep4", 250, 3, 10));
        electronicWarehouse.addNew("ep5", new ElectronicProduct("ep5", 500, 1, 24));
        System.out.println(electronicWarehouse.toString());

        System.out.println("Ristocca fp1 di 10");
        foodWarehouse.get("fp1").restock(10);

        System.out.println(foodWarehouse.toString());

        System.out.println("Prezzo di ep5: " + electronicWarehouse.get("ep5").getPrice());
    }
}