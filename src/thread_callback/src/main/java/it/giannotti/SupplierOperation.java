package it.giannotti;

import java.util.function.Supplier;

public class SupplierOperation {

    public void run(Supplier<Integer> s) {
        System.out.println("inizio operazione");
        System.out.println("fine operazione");
        System.out.println("il numero generato è " + s.get());
    }
}
