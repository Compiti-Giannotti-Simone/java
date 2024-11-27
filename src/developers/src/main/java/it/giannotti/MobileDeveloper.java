package it.giannotti;

public class MobileDeveloper extends Developer {
    String favorite_os;
    boolean native_framework;

    public MobileDeveloper(String name, String surname, String tax_code, int salary, String favorite_os, boolean native_framework, Curriculum curriculum) {
        super(name, surname, tax_code, salary, curriculum);
        this.favorite_os = favorite_os;
        this.native_framework = native_framework;
    }

    public String toString() {
        return super.toString() + "\nFavorite OS: " + favorite_os + "\nNative framework: " + native_framework;
    } 

    public void raise() {
        this.setSalary((int)(this.getSalary() * 1.10));
    }
}
