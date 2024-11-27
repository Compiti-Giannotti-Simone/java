package it.giannotti;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in); 

    private static Product product = new Product(0);
    public static void main(String[] args) {
        while(true) {
        int scelta = menu();
        switch (scelta) {
            case 1:
                Brick brick = createBrick();
                product.addBrick(brick);
                break;
            case 2:
                System.out.println("Inserisci quantita' mattoni da generare");
                int a = scanner.nextInt();
                product.generateBricks(a);
                break;
            case 3:
                int n = product.getBrickCount();
                System.out.println("Il prodotto ha " + n + " mattoni");
                break;
            case 4:
                float w = product.totalWeight();
                System.out.println("Il prodotto pesa " + w + " grammi");
                break;
            case 5:
                System.out.println("Inserisci valore colore rosso");
                int r = colorInput();
                System.out.println("Inserisci valore colore verde");
                int g = colorInput();
                System.out.println("Inserisci valore colore blu");
                int b = colorInput();
                product.listBricksColor(r, g, b);
                break;
            case 6:
                System.out.println("Inserisci id da contare");
                int id = scanner.nextInt();
                product.countBricksWithId(id);
                break;
            case 7:
                product.listBricks();
                break;
            case 0:
                return;
            default:
                break;
        }
        }
    }
    
    public static Brick createBrick() {
        int id,r,g,b,x,y,z;
        float weight;
        System.out.println("Inserisci ID");
        id = scanner.nextInt();
        System.out.println("Inserisci valore colore rosso");
        r = colorInput();
        System.out.println("Inserisci valore colore verde");
        g = colorInput();
        System.out.println("Inserisci valore colore blu");
        b = colorInput();
        System.out.println("Inserisci larghezza");
        x = scanner.nextInt();
        System.out.println("Inserisci altezza");
        y = scanner.nextInt();
        System.out.println("Inserisci lunghezza");
        z = scanner.nextInt();
        System.out.println("Inserisci peso");
        weight = scanner.nextFloat();
        return new Brick(id, r, g, b, x, y, z, weight);
    }

    public static int colorInput() {
        int temp;
        do{
            temp = scanner.nextInt();
        }while(temp > 255 || temp < 0);
        return temp;
    }

    public static int menu() {
        int scelta;
        System.out.println("1. Aggiungi mattone al prodotto");
        System.out.println("2. Genera mattoni casuali");
        System.out.println("3. Conta mattoni");
        System.out.println("4. Totale peso prodotto");
        System.out.println("5. Elenca mattoni per colore specificato");
        System.out.println("6. Conta mattoni con ID specificato");
        System.out.println("7. Elenca mattoni");
        System.out.println("0. Esci");
        scelta = scanner.nextInt();
        return scelta;
    }
}