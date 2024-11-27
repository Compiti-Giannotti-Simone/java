package it.giannotti;

public class Contact {
    private String name, surname, number;

    public Contact(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Contact [name=" + name + ", surname=" + surname + ", number=" + number + "]";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNumber() {
        return number;
    }

    
}
