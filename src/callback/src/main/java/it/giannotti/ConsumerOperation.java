package it.giannotti;

import java.util.function.Consumer;

public class ConsumerOperation {

    public void run(Consumer<String> c, String s) {
        System.out.println("inizio operazione");
        System.out.println("fine operazione");
        System.out.println("inizio callback");
        c.accept(s);
    }
}
