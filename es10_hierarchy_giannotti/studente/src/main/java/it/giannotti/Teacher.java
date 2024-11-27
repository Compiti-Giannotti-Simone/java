package it.giannotti;

public class Teacher extends Student {

    public Teacher(String name, String surname, String id, int serial_number) {
        super(name, surname, id, serial_number);
    }

    @Override
    public String toString() {
        return "Teacher " + super.toString();
    }
}
