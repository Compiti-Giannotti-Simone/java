package it.giannotti;

/**
 * A queue type list implemented using nodes with pointers
 */
public class LinkedQueue<T> {

    private class Node {
        private T element;
        private Node link;

        Node(T element) {
            this.element = element;
        }
    }

    private Node front, back;

    public LinkedQueue() {
    }

    /**
     * Checks if the stack is empty
     * @return true if empty, otherwise false
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Add a new element at the back of the queue
     * @param element element to add
     */
    public void enqueue(T element) {
        Node n = new Node(element);
        if(back == null) {
            back = n;
            front = back;
        }
        else {
            back.link = n;
            back = n;
        }
    }

    /**
     * Removes and returns the element at the front of the queue
     * @returns element at the front of the quee
     */
    public T dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = front.element;
        front = front.link;
        if(front == null) {
            front = back;
        }
        return element;
    }

    /**
     * Returns the element at the front of the queue, without removing it
     * @returns element at the front of the quee
     */
    public T peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.element;
    }

    /**
     * <p>Returns the position in queue of the searched element as an integer between 1 and n, with n being the amount of elements in the queue</p>
     * <p>The number it returns represents how many elements need to be dequeued before returning the searched element</p>
     * <p>This means that if the position of an element is 1, it is at the front of the queue</p>
     * @param element the element to search for
     * @return position of the element, or -1 if it's not present
     */
    public int search(T element) {
        Node n = front;
        int pos = 1;
        while(n != null) {
            if(n.element.equals(element)) return pos;
            n = n.link;
            pos++;
        }
        return -1;
    }

    @Override
    public String toString() {
        String s = "LinkedQueue [";
        while(front != null) {
            s += front.element.toString();
            s += ", ";
            front = front.link;
        }
        s += "]";
        return s.replace(", ]", "]");
    }
}
