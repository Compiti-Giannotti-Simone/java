package it.giannotti;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name,surname;
    private Map<Subject,Grades> grades;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        grades = new HashMap<>();
        for (Subject subject : Subject.values()) {
            if(subject != Subject.TOTAL) grades.put(subject,new Grades());
        }
    }

    public Map<Subject,Double> calculateStudentMeans() {
        double total = 0;
        Map<Subject,Double> means = new HashMap<>();
        for (Subject subject : Subject.values()) {
            try {
                means.put(subject,this.grades.get(subject).calculateMean());
            } catch (Exception e) {
                means.put(subject,0.00);
            }
            total+=means.get(subject);
        }
        means.put(Subject.TOTAL, total/means.size());
        return means;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Map<Subject, Grades> getGrades() {
        return grades;
    }

    public void addGrade(Subject subject, Double grade) {
        grades.get(subject).add(grade);
    }

    @Override
    public String toString() {
        return "\n" + name + " " + surname + ", voti: " + grades;
    }
    
    
}
