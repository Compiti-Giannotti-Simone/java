package it.giannotti;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.addStudent(new Student("pinco", "pallino"));

        for (Student s : manager.getStudents()) {
            for (Subject subject : Subject.values()) {
                if (subject != Subject.TOTAL) {
                    s.addGrade(subject, Math.floor(Math.random() * 10 * 100) / 100);
                    s.addGrade(subject, Math.floor(Math.random() * 10 * 100) / 100);
                    s.addGrade(subject, Math.floor(Math.random() * 10 * 100) / 100);
                    s.addGrade(subject, Math.floor(Math.random() * 10 * 100) / 100);
                    s.addGrade(subject, Math.floor(Math.random() * 10 * 100) / 100);
                }
            }
        }

        System.out.println(manager.toString());
        System.out.println(manager.getAllMeans());
    }

}