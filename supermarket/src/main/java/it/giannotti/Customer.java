package it.giannotti;

public class Customer {
    private String name, surname;
    private boolean member;

    public Customer(String name, String surname, boolean member) {
        this.name = name;
        this.surname = surname;
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isMember() {
        return member;
    }
    
    
}
