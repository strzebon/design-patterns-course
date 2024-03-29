package pl.edu.agh.to.lab4;

import java.util.Iterator;
import java.util.function.Predicate;

public class SuspectIterator implements Iterator<Suspect> {

    Suspect suspect;
    Iterator<? extends Suspect> iterator;
    Predicate<Suspect> filter;

    public SuspectIterator(Iterator<? extends Suspect> iterator, Predicate<Suspect> filter){
        this.iterator = iterator;
        this.filter = filter;
    }

    @Override
    public boolean hasNext() {
        while(iterator.hasNext()) {
            Suspect tempSuspect = iterator.next();
            if(filter.test(tempSuspect) && tempSuspect.canBeAccused()) {
                suspect = tempSuspect;
                return true;
            }
        }
        return false;
    }

    @Override
    public Suspect next() {
        return suspect;
    }
}
