package it.giannotti;

import java.sql.Date;

public class Person {
    String name, surname;
    Date birth_date;

    public Person() {
    }

    public Person(String name, String surname, Date birth_date) {
        this.name = name;
        this.surname = surname;
        this.birth_date = birth_date;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }
    
    @Override
    public String toString() {
        return "Person [name=" + name + ", surname=" + surname + ", birth_date=" + birth_date + "]";
    }

    
}
