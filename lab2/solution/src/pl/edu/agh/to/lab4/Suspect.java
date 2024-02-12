package pl.edu.agh.to.lab4;

public abstract class Suspect {

    private String firstName;
    private String lastName;

    public Suspect(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public abstract int getAge();

    public String display() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public abstract boolean canBeAccused();

}
