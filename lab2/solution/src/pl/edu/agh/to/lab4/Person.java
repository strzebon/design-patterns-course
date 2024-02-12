package pl.edu.agh.to.lab4;

public class Person extends Suspect{

    private int age;

    public Person(String firstName, String lastName, int age) {
        super(firstName, lastName);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public boolean canBeAccused(){
        return age >= 18;
    }

}
