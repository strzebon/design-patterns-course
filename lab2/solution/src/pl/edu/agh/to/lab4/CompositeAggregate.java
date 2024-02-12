package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class CompositeAggregate implements SuspectAggregate{

    private final List<SuspectAggregate> suspectAggregates;

    public CompositeAggregate(List<SuspectAggregate> suspectAggregates){
        this.suspectAggregates = suspectAggregates;
    }

    @Override
    public Iterator<Suspect> iterator(Predicate<Suspect> filter) {
        Collection<Suspect> suspects = new ArrayList<>();
        for (SuspectAggregate suspectAggregate : suspectAggregates) {
            Iterator<Suspect> iterator = suspectAggregate.iterator(filter);
            while(iterator.hasNext()) {
                suspects.add(iterator.next());
            }
        }
        return suspects.iterator();
    }
}
