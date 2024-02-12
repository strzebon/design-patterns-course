package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

public class PersonDataProvider implements SuspectAggregate{

    private final Collection<Person> cracovCitizens = new ArrayList<Person>();

    public PersonDataProvider() {
        cracovCitizens.add(new Person("Jan", "Kowalski", 30));
        cracovCitizens.add(new Person("Janusz", "Krakowski", 30));
        cracovCitizens.add(new Person("Janusz", "Mlodociany", 10));
        cracovCitizens.add(new Person("Kasia", "Kosinska", 19));
        cracovCitizens.add(new Person("Piotr", "Zgredek", 29));
        cracovCitizens.add(new Person("Tomek", "Gimbus", 14));
        cracovCitizens.add(new Person("Janusz", "Gimbus", 15));
        cracovCitizens.add(new Person("Alicja", "Zaczarowana", 22));
        cracovCitizens.add(new Person("Janusz", "Programista", 77));
        cracovCitizens.add(new Person("Pawel", "Pawlowicz", 32));
        cracovCitizens.add(new Person("Krzysztof", "Mendel", 30));
    }

    public Collection<Person> getAllCracovCitizens() {
        return cracovCitizens;
    }


    @Override
    public Iterator<Suspect> iterator(Predicate<Suspect> filter) {
        return new SuspectIterator(cracovCitizens.iterator(), filter);
    }
}
