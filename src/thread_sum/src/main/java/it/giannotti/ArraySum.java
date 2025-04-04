package it.giannotti;

import java.util.Random;

public class ArraySum {

    private Integer[] a;

    private int total;

    public ArraySum(int size) {
        a = new Integer[size];
    }

    public void generateNums() {
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(10);
        }
    }

    public void calculate(int iA, int iB) {
        total += a[iA] + a[iB];
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < a.length-1; i++) {
            s += a[i] + ", ";
        }
        s += a[a.length-1] + "]";
        return s;
    }

    public int getTotal() {
        return total;
    }

    public Integer[] getArray() {
        return a;
    }
}
