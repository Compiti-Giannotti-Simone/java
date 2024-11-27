package it.giannotti;

public abstract class Developer {
    private String name, surname, tax_code;
    private int salary, id;
    private Curriculum curriculum;
    private static int s_id;

    public Developer(String name, String surname, String tax_code, int salary, Curriculum curriculum) {
        this.name = name;
        this.surname = surname;
        this.tax_code = tax_code;
        this.salary = salary;
        this.id = s_id++;
        this.curriculum = curriculum;
    }

    public boolean learnNewLanguage(String language) {
        return curriculum.addLanguage(language);
    }

    public String getDevValue() {
        switch (curriculum.getValue()) {
            case 1:
                return "Inexperienced";
            case 2:
                return "Junior";
            case 3:
                return "Senior";
        }
        return null;
    }

    public boolean compareDeveloper(Developer d) {
        if (this.curriculum.getValue() == d.curriculum.getValue())
            return true;
        return false;
    }

    public abstract void raise();

    @Override
    public String toString() {
        return "\nID: " + id + "\nCF: " + tax_code + "\nName: " + name + "\nSurname: " + surname + "\nSalary: " + salary
                + "\nCurriculum: " + curriculum.toString();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTax_code() {
        return tax_code;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
