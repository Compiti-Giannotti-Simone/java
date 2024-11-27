package it.giannotti;

import java.util.ArrayList;

public class Index {
    private ArrayList<Contact> contacts;


    public Index() {
        this.contacts = new ArrayList<Contact>();
    }

    public void addContact(String name, String surname, String number) {
        contacts.add(new Contact(name, surname, number));
    }

    public void removeContact(String name, String surname) {
        contacts.remove(findContact(name, surname));
    }

    public int findContact(String name, String surname) {
        for(int i = 0;i < contacts.size();i++) {
            if(contacts.get(i).getName().equals(name) && contacts.get(i).getSurname().equals(surname)) return i;
        }
        return -1;
    }

    public String findContactNumber(String name, String surname) {
        int i = findContact(name, surname);
        if(i != -1) return contacts.get(i).getNumber();
        return null;
    }

    @Override
    public String toString() {
        return "Index [contacts=" + contacts + "]";
    }

    
}

