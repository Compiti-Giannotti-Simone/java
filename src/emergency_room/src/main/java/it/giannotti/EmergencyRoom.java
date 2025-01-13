package it.giannotti;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class EmergencyRoom {
    private HashMap<Codes,ArrayDeque<Patient>> waiting_list = new HashMap<>();
    private long total_time = 0;
    private int patients_operated = 0;

    public EmergencyRoom() {
        for (Codes c : Codes.values()) {
            waiting_list.put(c, new ArrayDeque<>());
        }
    }

    public void addPatient(Patient p) {
        waiting_list.get(p.getUrgency()).add(p);
    }

    public Patient removePatient(String name, String surname) {
        for (Codes c : Codes.values()) {
            for (Patient p : waiting_list.get(c)) {
                if(p.getName().equals(name) && p.getSurname().equals(surname)) return p;
            }
        }
        return null;
    }

    public Patient getMostUrgent() {
        if(!waiting_list.get(Codes.RED).isEmpty()) {
            patients_operated++;
            total_time += System.currentTimeMillis() - waiting_list.get(Codes.RED).peek().getEntry_time();
            return waiting_list.get(Codes.RED).remove();
        }
        if(!waiting_list.get(Codes.YELLOW).isEmpty()) {
            patients_operated++;
            total_time += System.currentTimeMillis() - waiting_list.get(Codes.YELLOW).peek().getEntry_time();
            return waiting_list.get(Codes.YELLOW).remove();
        }
        if(!waiting_list.get(Codes.WHITE).isEmpty()) {
            patients_operated++;
            total_time += System.currentTimeMillis() - waiting_list.get(Codes.WHITE).peek().getEntry_time();
            return waiting_list.get(Codes.WHITE).remove();
        }
        throw new NoSuchElementException();
    }
    /**
     * Calculates mean operation time based on last operated patients
     * @return long in milliseconds
     */
    public long calculateMeanTime() {
        return total_time/patients_operated;
    }
}
