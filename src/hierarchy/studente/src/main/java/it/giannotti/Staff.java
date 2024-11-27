package it.giannotti;

public class Staff extends Student{

    public Staff(String name, String surname, String id, int serial_number) {
        super(name, surname, id, serial_number);
    }

    @Override
    public String toString() {
        return "Teacher " + super.toString();
    }
}
