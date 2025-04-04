package it.giannotti;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //array summer
        ArraySum a = new ArraySum(10);
        a.generateNums();
        for (int i = 0; i < 5; i++) {
            new Thread(new Summer(a,5,i)).start();
        }
        sleep(1000);
        System.out.println("Array: " + a.toString());
        System.out.println("Totale:" + a.getTotal());

        //prime finder
        System.out.println("Numeri primi fino a 100:");
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(new PrimeFinder(primes,100,i,10)).start();
        }
        sleep(1000);
        primes.sort( (n1,n2) -> {return n1-n2;});
        System.out.println(primes.toString());
    }
}