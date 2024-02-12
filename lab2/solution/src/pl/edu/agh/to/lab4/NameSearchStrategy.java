package pl.edu.agh.to.lab4;

import java.util.Objects;
import java.util.function.Predicate;

public class NameSearchStrategy implements Predicate<Suspect> {

    private String firstName;

    public NameSearchStrategy(String firstName){
        this.firstName = firstName;
    }

    @Override
    public boolean test(Suspect suspect) {
        return Objects.equals(firstName, suspect.getFirstName());
    }
}
