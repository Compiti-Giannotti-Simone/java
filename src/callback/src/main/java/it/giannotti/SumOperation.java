package it.giannotti;

public class SumOperation implements MathOperation {

    public int calculate(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a+b));
        return a+b;
    }
}
