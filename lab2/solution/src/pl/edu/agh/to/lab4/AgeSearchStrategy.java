package pl.edu.agh.to.lab4;

import java.util.function.Predicate;

public class AgeSearchStrategy implements Predicate<Suspect> {

    private int age;

    public AgeSearchStrategy(int age){
        this.age = age;
    }

    @Override
    public boolean test(Suspect suspect) {
        return suspect.getAge() == age;
    }
}
