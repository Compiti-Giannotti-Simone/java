package it.giannotti;

import java.util.Map;

public interface StudentOperations {

    public boolean addStudent(Student s);
    public Map<String, Map<Subject, Double>> getAllMeans();
    // public void sortByName();
}
