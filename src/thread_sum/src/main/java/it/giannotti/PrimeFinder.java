package it.giannotti;

import java.util.ArrayList;

public class PrimeFinder implements Runnable {

    private ArrayList<Integer> primes;
    private int n, id, range, startN;

    public PrimeFinder(ArrayList<Integer> primes, int n, int id, int threadAmount) {
        this.primes = primes;
        this.id = id;
        this.n = n;
        this.range = n/threadAmount;
        this.startN = range*id;
    }

    @Override
    public void run() {
        int number = startN;
        while(number <= startN+range && number < n) {
            if(number == 0) number = 2;
            // Assume the number is prime
            boolean isPrime = true; // Is the current number prime?

            // Test if number is prime
            for(int divisor = 2; divisor <= (int)(Math.sqrt(number)); divisor++) {
                if(number % divisor == 0) { // If true, number is not prime
                    isPrime = false; // Set isPrime to false
                    break; // Exit the for loop
                }
            }

            if(isPrime) {
                primes.add(number);
            }
            number++;
        }
    }
}
