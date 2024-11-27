package it.giannotti;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    private static Registry r = new Registry(200);

    public static void main(String[] args) {
        while(true) {
            switch (menu()) {
                case 1:
                    r.generateSensors(1);
                    break;
                case 2:
                    r.generateSensors(inputNumber());
                    break;
                case 3:
                    r.deleteSensor(inputIp());
                    break;
                case 4:
                    r.findByIp(inputIp());
                    break;
                case 5:
                    findInArea();
                    break;
                case 6:
                    r.purgeSensors();
                    break;
                case 7:
                    r.printAllSensors();
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }

    public static String inputIp() {
        System.out.println("Inserisci IP: ");
        return scanner.nextLine();
    }

    public static int inputNumber() {
        System.out.println("Inserisci numero sensori: ");
        return scanner.nextInt();
    }

    public static void findInArea() {
        double lat_min,lat_max,lon_max,lon_min;
        System.out.println("Inserisci latitudine iniziale: ");
        lat_min = scanner.nextDouble();
        System.out.println("Inserisci latitudine finale: ");
        lat_max = scanner.nextDouble();
        System.out.println("Inserisci longitudine iniziale: ");
        lon_min = scanner.nextDouble();
        System.out.println("Inserisci longitudine finale: ");
        lon_max = scanner.nextDouble();
        r.printAllSensorsInArea(lat_min,lon_min,lat_max,lon_max);
    }

    public static int menu() {
        System.out.println("1. Aggiungi 1 sensore");
        System.out.println("2. Genera N sensori");
        System.out.println("3. Elimina sensore via IP");
        System.out.println("4. Ricerca sensore via IP");
        System.out.println("5. Ricerca tutti i sensori in un'area");
        System.out.println("6. Elimina sensori oltre 365 giorni di sostituzione");
        System.out.println("7. Stampa tutti i sensori");
        System.out.println("0. Esci");
        return scanner.nextInt();
    }
}