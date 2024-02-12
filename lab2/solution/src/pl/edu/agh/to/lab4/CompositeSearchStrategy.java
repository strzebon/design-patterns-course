package pl.edu.agh.to.lab4;

import java.util.List;
import java.util.function.Predicate;

public class CompositeSearchStrategy implements Predicate<Suspect> {

    private List<Predicate<Suspect>> filters;

    public CompositeSearchStrategy(List<Predicate<Suspect>> filters){
        this.filters = filters;
    }

    @Override
    public boolean test(Suspect suspect) {
        for(Predicate<Suspect> filter: filters){
            if(!filter.test(suspect)) return false;
        }
        return true;
    }
}
