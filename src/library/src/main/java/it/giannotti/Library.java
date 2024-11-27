package it.giannotti;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Library<T extends Readable> {
    Map<Class, Set<T>> library;

    public Library() {
        this.library = new HashMap<>();
    }

    public void add(T e) {
        if (library.get(e.getClass()) == null) {
            library.put(e.getClass(), new TreeSet<>((t1, t2) -> t1.getTitle().compareTo(t2.getTitle())));
        }
        library.get(e.getClass()).add(e);
    }

    public void remove(String title) {
        library.forEach((c, s) -> {
            s.removeIf(t -> t.getTitle().equals(title));
        });
    }

    public T get(String title) throws BookNotFoundException{
        for (Set<T> s : library.values()) {
            for (T t : s) {
                if(t.getTitle().equals(title)) return t;
            }
        }
        throw new BookNotFoundException("Book " + title + " not in library");
    }

    public Set<T> toSet() {
        Set<T> a = new TreeSet<>((t1, t2) -> t1.getTitle().compareTo(t2.getTitle()));
        library.forEach((c, s) -> {
            a.addAll(s);
        });
        return a;
    }

    @Override
    public String toString() {
        return ("Library " + library + "]").replace("],", "]\n").replace("it.giannotti.", "").replace("{", "{\n")
                .replace("=[", " {\n");
    }

}
