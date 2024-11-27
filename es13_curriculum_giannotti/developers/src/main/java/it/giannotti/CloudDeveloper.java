package it.giannotti;

public class CloudDeveloper extends Developer {
    String cloud;
    int experience_years;

    public CloudDeveloper(String name, String surname, String tax_code, int salary, String cloud, int experience_years,
            Curriculum curriculum) {
        super(name, surname, tax_code, salary, curriculum);
        this.cloud = cloud;
        this.experience_years = experience_years;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCloud: " + cloud + "\nExperience: " + experience_years + " years";
    }

    public void raise() {
        this.setSalary((int) (this.getSalary() * 1.20));
    }

}
