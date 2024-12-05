package it.giannotti;

/**
 * A queue type list implemented using static arrays
 */
public class ResizableQueue<T> {

    private Object[] queue = new Object[10];
    private int back = 0;

    public ResizableQueue() {
    }

    private void resizeQueue() {
        Object[] newQueue = new Object[10 + queue.length];
        for(int i = 0; i < queue.length;i++) {
            newQueue[i] = queue[i];
        }
        queue = newQueue;
    }

    private void shiftL(int pos) {
        for (int i = pos; i < back - 1; i++) {
            queue[i] = queue[i + 1];
        }
        queue[--back] = null; 
    }

    /**
     * Checks if the stack is empty
     * @return true if empty, otherwise false
     */
    public boolean isEmpty() {
        return back == 0;
    }

    /**
     * Add a new element at the back of the queue
     * @param element element to add
     */
    public void enqueue(T element) {
        if(back == queue.length) resizeQueue();
        queue[back] = element;
        back++;
    }

    /**
     * Removes and returns the element at the front of the queue
     * @returns element at the front of the quee
     */
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T element = (T) queue[0];
        shiftL(0);
        return element;
    }

    /**
     * Returns the element at the front of the queue, without removing it
     * @returns element at the front of the quee
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return (T) queue[0];
    }

    /**
     * <p>Returns the position in queue of the searched element as an integer between 1 and n, with n being the amount of elements in the queue</p>
     * <p>The number it returns represents how many elements need to be dequeued before returning the searched element</p>
     * <p>This means that if the position of an element is 1, it is at the front of the queue</p>
     * @param element the element to search for
     * @return position of the element, or -1 if it's not present
     */
    public int search(T element) {
        for(int i = 0;i < back;i++) {
            if(queue[i].equals(element)) return i+1;
        }
        return -1;
    }

    @Override
    public String toString() {
        String s = "ResizableQueue [";
        for(int i = 0;i < back;i++) {
            s += queue[i].toString();
            s += ", ";
        }
        s += "]";
        return s.replace(", ]", "]");
    }
}
