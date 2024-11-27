package it.giannotti;

import java.util.ArrayList;
import java.util.List;

public class Grades {
    private List<Double> grades;

    public Grades() {
        grades = new ArrayList<>();
    }

    public Double calculateMean() {
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    @Override
    public String toString() {
        return "" + grades;
    }

    public boolean add(Double grade) {
        return grades.add(grade);
    }
}
