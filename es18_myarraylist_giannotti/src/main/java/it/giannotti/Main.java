package it.giannotti;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> m1 = new MyArrayList<>();
        MyArrayList<TestClass> m2 = new MyArrayList<>();

        System.out.println("m1 is empty: " + m1.isEmpty());
        m1.add(5);
        m1.add(1);
        m1.add(9);
        m1.add(7);
        m1.add(3);
        
        System.out.println("myarraylist m1: \n" + m1.toString());
        System.out.println("m1 is empty: " + m1.isEmpty());
        System.out.println("m1 size: " + m1.size());
        System.out.println("elemento di m1 in pos 2: " + m1.get(2));
        System.out.println("rimozione elemento in pos 2: " + m1.remove(2));
        System.out.println("rimozione elemento in pos 6: " + m1.remove(6));
        System.out.println("elemento in pos 2 rimosso:\n" + m1.toString());
        System.out.println("index dell'elemento '7': " + m1.indexOf(7));
        m1.set(2, 4);
        System.out.println("set elemento in pos 2 a 4");
        System.out.println(m1.toString());
        m1.add(1, 10);
        System.out.println("aggiungi elemento '10' in pos 1 (tra '5' e '1')");
        System.out.println(m1.toString());
        
        m2.add(new TestClass("Gianni", "Verdi", 20));
        m2.add(new TestClass("Mario", "Rossi", 20));
        m2.add(new TestClass("Marco", "Marchini", 20));
        m2.add(new TestClass("Leonardo", "Da Perdi", 20));
        m2.add(new TestClass("Gabriele", "Gabrieli", 20));

        System.out.println(m2.toString());
        

    }
}
