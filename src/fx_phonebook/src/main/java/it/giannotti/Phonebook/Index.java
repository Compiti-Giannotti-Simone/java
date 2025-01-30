package it.giannotti.Phonebook;

import java.util.Set;
import java.util.TreeSet;

public class Index {
    private Set<Contact> contacts;

    private static Index instance = null;

    public static Index getInstance() {
        if(instance == null) {
            instance = new Index();
        }
        return instance;
    }


    private Index() {
        this.contacts = new TreeSet<Contact>((a,b) -> a.getSurname().compareTo(b.getSurname()));
    }

    public void addContact(String name, String surname, String number) {
        contacts.add(new Contact(name, surname, number));
    }

    public void addContact(Contact c) {
        contacts.add(c);
    }

    public void removeContact(String name, String surname) {
        contacts.removeIf((a)-> (a.getName().equals(name)&&a.getSurname().equals(surname)));
    }

    public void editContact(Contact old, String name, String surname, String number) {
        old.setName(name);
        old.setSurname(surname);
        old.setNumber(number);
    }

    public Contact getContactByName(String name, String surname) {
        for (Contact c : contacts) {
            if(c.getName().equals(name) && c.getSurname().equals(surname)) return c;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Index [contacts=" + contacts + "]";
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    
}

