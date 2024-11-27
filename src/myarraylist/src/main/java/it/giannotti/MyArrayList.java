package it.giannotti;

public class MyArrayList<T> {

    private Object[] a1 = new Object[10];
    private int used = 0;

    public MyArrayList() {
    }

    private void increaseStaticSpace() {
        Object[] a2 = new Object[10 + a1.length];
        for (int i = 0; i < a1.length; i++) {
            a2[i] = a1[i];
        }
        a1 = a2;
    }

    private void shiftR(int pos) {
        if (used == a1.length)
            increaseStaticSpace();
        for (int i = used; i > 0; i--) {
            a1[i] = a1[i - 1];
        }
    }

    private void shiftL(int pos) {
        for (int i = pos; i < used - 1; i++) {
            a1[i] = a1[i + 1];
        }
    }

    /**
     * <p>Adds a new element at the end of the ArrayList</p>
     * 
     * @param e element to add
     */
    public void add(T e) {
        if (used == a1.length)
            increaseStaticSpace();
        a1[used] = e;
        used++;
    }

    /**
     * <p>Adds a new element in the given position of the ArrayList</p>
     * <p>If the position given is greater than the amount of elements already present, the new element gets appended at the end of the list.</p>
     * 
     * @param pos position of the new element
     * @param e element to add
     */
    public void add(int pos, T e) {
        if (pos >= used)
            add(e);
        else {
            shiftR(pos);
            a1[pos] = e;
            used++;
        }
    }

    /**
     * Removes an element in the ArrayList given an index and shifts their position
     * to fill in the new gap
     * 
     * @param pos index of the element to be removed
     * @return {@code true} if the element was removed correctly, {@code false} if it is not found.
     */
    public boolean remove(int pos) {
        if (pos >= used)
            return false;
        else {
            shiftL(pos);
            used--;
            return true;
        }
    }

    /**
     * Checks if a specified element is present in an array
     * 
     * @param e the element that you are checking for in the array
     * @return {@code true} if the element is found in
     * the list, {@code false} if it is not found.
     */
    public boolean contains(T e) {
        for (int i = 0; i < used; i++) {
            if (a1[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * Returns the element in the given position
     * 
     * @param pos index of the element to be returned
     * @return the element in the position {@code pos}, or {@code null} if the given index is empty
     */
    @SuppressWarnings("unchecked")
    public T get(int pos) {
        if (pos >= used)
            return null;
        else
            return (T) a1[pos];
    }

    /**
     * Returns the element in the given position
     * 
     * @param pos index of the element to be returned
     * @return the element in the position {@code pos}, or {@code null} if the given index is empty
     */
    public int indexOf(T e) {
        for (int i = 0; i < used; i++) {
            if (a1[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * Replaces an element in the list with a new one
     * 
     * @param pos index of the element to be replaced
     * @param e the element that will replace the previous one
     * @return the element in the position {@code pos}, or {@code null} if the given index is empty
     */
    public void set(int pos, T e) {
        if (pos >= used)
            return;
        else
            a1[pos] = e;
    }

    /**
     * Returns the size, or the amount of elements in the list, as an integer
     */
    public int size() {
        return used;
    }

    /**
     * Returns true if the list is empty, or false otherwise
     */
    public boolean isEmpty() {
        return used == 0;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0;i<used;i++) {
            s+= a1[i].toString() + ", ";
        }
        s += "]";
        return s.replace(", ]", "]");
    }
}