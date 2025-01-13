package it.giannotti;

import it.giannotti.books.AbstractBook;
import it.giannotti.collections.LinkedQueue;
import it.giannotti.collections.LinkedStack;
import it.giannotti.collections.ResizableQueue;
import it.giannotti.collections.ResizableStack;

public class Library {
    private ResizableStack<AbstractBook> shelf = new ResizableStack<>();
    private ResizableQueue<Person> queue = new ResizableQueue<>();

    public void addBook(AbstractBook book) {
        shelf.push(book);
    }

    public void addPerson(Person person) {
        queue.enqueue(person);
    }

    public String assignBook() {
        return "La persona " + queue.dequeue().toString() + " ha ricevuto il libro " + shelf.pop().toString();
    }
}
