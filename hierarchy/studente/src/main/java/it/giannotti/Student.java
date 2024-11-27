package it.giannotti;

public class Student {
    protected String name,surname,id;
    protected int serial_number;
    
    public Student(String name, String surname, String id, int serial_number) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.serial_number = serial_number;
    }

    @Override
    public String toString() {
        return " [name=" + name + ", surname=" + surname + ", id=" + id + ", serial_number=" + serial_number
                + "]";
    }

    

}
