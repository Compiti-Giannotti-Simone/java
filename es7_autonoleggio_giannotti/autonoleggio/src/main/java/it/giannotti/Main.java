package it.giannotti;

public class Main {
  public static void main(String[] args) {

    Management m = new Management();
    m.addVehicle("1", "b", "modello1", 1);
    m.addVehicle("3", "c", "modello2", 2);
    m.addVehicle("2", "a", "modello3", 3);
    m.addVehicle("1", "b", "modello1", 1);
    m.addVehicle("3", "c", "modello2", 2);
    m.addVehicle("2", "a", "modello3", 3);
    m.addVehicle("1", "b", "modello1", 1);
    m.addVehicle("3", "c", "modello2", 2);
    m.addVehicle("2", "a", "modello3", 3);
    m.addVehicle("1", "a", "modello1", 1);
    m.addVehicle("3", "a", "modello2", 2);
    m.addVehicle("2", "a", "modello3", 3);
    m.saveToFile();
    m.countAllBrands();
  }
}