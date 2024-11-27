package it.giannotti;

public class TestClass {
    String name,surname;
    int age;
    
    public TestClass(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestClass [name=" + name + ", surname=" + surname + ", age=" + age + "]";
    }


    
}
