package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Finder {
    private CompositeAggregate compositeAggregate;

    public Finder(CompositeAggregate compositeAggregate) {
        this.compositeAggregate = compositeAggregate;
    }

    public void display(CompositeSearchStrategy searchStrategy) {
        Iterator<Suspect> iterator = compositeAggregate.iterator(searchStrategy);
        List<Suspect> suspects = new ArrayList<>();

        while(iterator.hasNext() && suspects.size() < 10) {
            suspects.add(iterator.next());
        }

        System.out.println("Znalazlem " + suspects.size() + " pasujacych podejrzanych!");
        for(Suspect suspect : suspects){
            System.out.println(suspect.display());
        }
    }
}
