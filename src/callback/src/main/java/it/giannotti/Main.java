package it.giannotti;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //Callback con classe implementata
        Operation o = new Operation();
        MathOperation m = new SumOperation();
        o.run(m,7,2);

        //Callback con classe anonima
        o.run(new MathOperation() {
            @Override
            public int calculate(int a, int b) {
                System.out.println(a+ " - "+b + " = " + (a-b));
                return a - b;
            }
        },10,5);

        //Callback con lambda
        o.run( (a,b) -> {
            System.out.println(a+" * "+b+" = " + (a*b));
            return a*b;
        },10,5);

        //Messaggio con Consumer
        ConsumerOperation o2 = new ConsumerOperation();
        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Messaggio: " + s);
            }
        };
        o2.run(c, "ciao");

        //Supplier
        SupplierOperation o3 = new SupplierOperation();
        Supplier<Integer> s = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random r = new Random(System.currentTimeMillis());
                return r.nextInt(1000);
            }
        };
        o3.run(s);

    }
}