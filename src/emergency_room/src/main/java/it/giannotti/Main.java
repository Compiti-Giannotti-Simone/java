package it.giannotti;

public class Main {
    public static void main(String[] args) {
        EmergencyRoom room = new EmergencyRoom();
        room.addPatient(new Patient("gino", "primo", Codes.RED));
        room.addPatient(new Patient("gino", "secondo", Codes.YELLOW));
        room.addPatient(new Patient("paolo", "sassi", Codes.RED));
        room.addPatient(new Patient("marco", "verdi", Codes.WHITE));
        
        System.out.println(room.getMostUrgent());
        System.out.println(room.getMostUrgent());
        System.out.println(room.getMostUrgent());
        System.out.println(room.getMostUrgent());
    }
}