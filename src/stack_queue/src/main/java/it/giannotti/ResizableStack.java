package it.giannotti;

/**
 * A stack type list implemented using static arrays
 */
public class ResizableStack<T> {

    private Object[] stack = new Object[10];
    private int used = 0;

    public ResizableStack() {
    }

    private void resizeStack() {
        Object[] newStack = new Object[10 + stack.length];
        for(int i = 0; i < stack.length;i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    /**
     * Checks if the stack is empty
     * @return true if empty, otherwise false
     */
    public boolean isEmpty() {
        return used == 0;
    }

    /**
     * Add a new element at the top of the stack
     * @param element element to add
     */
    public void push(T element) {
        if(used == stack.length) resizeStack();
        stack[used] = element;
        used++;
    }

    /**
     * Removes the element at the top of the stack and returns that element
     * @return element at the top of the stack
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return (T) stack[used--];
    }

    /**
     * Returns the element at the top of the stack, without removing it
     * @return element at the top of the stack
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return (T) stack[used];
    }

    /**
     * <p>Returns the position of the searched element as an integer between 1 and n, with n being the amount of elements in the stack</p>
     * <p>The number it returns represents how many elements need to be popped before returning the searched element</p>
     * <p>This means that if the position of an element is 1, it is at the top of the stack</p>
     * @param element the element to search for
     * @return position of the element, or -1 if it's not present
     */
    public int search(T element) {
        for(int i = 0;i<used;i++) {
            if(stack[i].equals(element)) return used - i;
        }
        return -1;
    }

    @Override
    public String toString() {
        String s = "ResizableStack [";
        for(int i = used;i > 0;i--) {
            s += stack[i].toString();
            s += ", ";
        }
        s += "]";
        return s.replace(", ]", "]");
    }
}
