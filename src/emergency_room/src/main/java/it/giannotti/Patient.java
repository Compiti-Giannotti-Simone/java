package it.giannotti;

public class Patient {
    private String name, surname;
    private Codes urgency;
    private long entry_time;

    public Patient(String name, String surname, Codes urgency) {
        this.name = name;
        this.surname = surname;
        this.urgency = urgency;
        this.entry_time = System.currentTimeMillis();
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public Codes getUrgency() {
        return urgency;
    }
    public long getEntry_time() {
        return entry_time;
    }
    @Override
    public String toString() {
        return "Patient [name=" + name + ", surname=" + surname + ", urgency=" + urgency + ", entry_time=" + entry_time
                + "]";
    }

    
}
