package it.giannotti;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class StudentManager implements StudentOperations {

    private Set<Student> students;

    public StudentManager() {
        this.students = new TreeSet<>((s1, s2) -> s1.getName().compareTo(s2.getName()));
    }

    public Map<String,Map<Subject,Double>> getAllMeans() {
        Map<String,Map<Subject,Double>> means = new HashMap<>();
        for (Student s : students) {
            means.put(s.getName()+" " +s.getSurname(),s.calculateStudentMeans());
        }
        return means;
    }

    public boolean addStudent(Student s) {
        return students.add(s);
    }

    public Set<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Students= " + students;
    }

}
