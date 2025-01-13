package it.giannotti.collections;


/**
 * A stack type list implemented using nodes with pointers
 */
public class LinkedStack<T> {

    private class Node {
        private T element;
        private Node link;

        Node(T element) {
            this.element = element;
        }
    }

    private Node top;

    public LinkedStack() {
    }

    /**
     * Checks if the stack is empty
     * @return true if empty, otherwise false
     */
    public boolean isEmpty() {
        return top.equals(null);
    }

    /**
     * Add a new element at the top of the stack
     * @param element element to add
     */
    public void push(T element) {
        Node node = new Node(element);
        node.link = top;
        top = node;
    }

    /**
     * Returns the element at the top of the stack, without removing it
     * @return element at the top of the stack
     */
    public T peek() {
        if(isEmpty()) throw new IllegalStateException("Stack is empty");
        return top.element;
    }
    
    /**
     * Removes the element at the top of the stack and returns that element
     * @return element at the top of the stack
     */
    public T pop() {
        if(isEmpty()) throw new IllegalStateException("Stack is empty");
        T popped = top.element;
        top = top.link;
        return popped;
    }

    /**
     * <p>Returns the position of the searched element as an integer between 1 and n, with n being the amount of elements in the stack</p>
     * <p>The number it returns represents how many elements need to be popped before returning the searched element</p>
     * <p>This means that if the position of an element is 1, it is at the top of the stack</p>
     * @param element the element to search for
     * @return position of the element, or -1 if it's not present
     */
    public int search(T element) {
        int pos = 1;
        Node n = top;
        while(n != null) {
            if(n.element.equals(element)) return pos;
            n = n.link;
            pos++;
        }
        return -1;
    }

    @Override
    public String toString() {
        String s = "LinkedStack [";
        Node temp = top;
        while(temp != null) {
            s += temp.element.toString();
            s += ", ";
            temp = temp.link;
        }
        s += "]";
        return s.replace(", ]", "]");
    }
}