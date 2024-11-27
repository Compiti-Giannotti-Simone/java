package it.giannotti;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class Management {

    private ArrayList<Vehicle> vehicles;

    public Management() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(String license, String brand, String model, int seats) {
        vehicles.add(new Vehicle(license, brand, model, seats));
    }

    public void deleteVehicleById(int id) {
        vehicles.removeIf(vehicle -> vehicle.getId() == id);
    }

    public void deleteVehicleByLicense(String license) {
        vehicles.removeIf(vehicle -> vehicle.getLicense().equals(license));
    }

    public Vehicle findVehicleById(int id) {
        for (Vehicle i : vehicles) {
            if (i.getId() == id)
                return i;
        }
        return null;
    }

    public Vehicle findVehicleByLicense(String license) {
        for (Vehicle i : vehicles) {
            if (i.getLicense().equals(license))
                return i;
        }
        return null;
    }

    public void findVehicleBySeats(int seats) {
        for (Vehicle i : vehicles) {
            if (i.getSeats() == seats)
                System.out.println(i.toString());
        }
    }

    public void saveToFile() {
        File file = new File("filename.txt");
        file.delete();

        try {
            FileWriter writer = new FileWriter("filename.txt");
            for (Vehicle i : vehicles) {
                writer.write(i.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try {
            File file = new File("filename.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                vehicles.add(fromString(data));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public Vehicle fromString(String str) {
        // Rimuove "Vehicle [" e "]"
        str = str.substring(str.indexOf("[") + 1, str.indexOf("]")).trim();
        
        // Divide la stringa in parti
        String[] parts = str.split(", ");
        String license = parts[0].split("=")[1];
        String brand = parts[1].split("=")[1];
        String model = parts[2].split("=")[1];
        int seats = Integer.parseInt(parts[3].split("=")[1]);
    
        return new Vehicle(license, brand, model, seats);
    }

    public void countAllBrands() {
        vehicles.sort((v1, v2) -> v1.getBrand().compareTo(v2.getBrand()));
        int n = 0;
        int pos = 0;
        do {
            do {
                n++;
                pos++;
            } while (pos < vehicles.size() - 1
                    && vehicles.get(pos).getBrand().equals(vehicles.get(pos + 1).getBrand()));
            n++;
            pos++;
            System.out.println(vehicles.get(pos - 1).getBrand() + ", " + n);
            n = 0;
        } while (pos < vehicles.size() - 1);
    }

    @Override
    public String toString() {
        return "Management [vehicles=" + vehicles + "]";
    }

    
}
