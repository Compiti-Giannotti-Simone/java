package it.giannotti;

public class Operation {
    public void run(MathOperation m, int a, int b) {
        System.out.println("iniziata operazione");
        System.out.println("fine operazione");
        System.out.println("inizio callback");
        m.calculate(a,b);

    }
}
