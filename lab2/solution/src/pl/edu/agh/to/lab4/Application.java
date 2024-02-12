package pl.edu.agh.to.lab4;


import java.util.List;

public class Application {

    public static void main(String[] args) {
        Finder suspectFinder = new Finder(new CompositeAggregate(List.of(new PersonDataProvider(), new PrisonersDatabase())));
        suspectFinder.display(new CompositeSearchStrategy(List.of(new NameSearchStrategy("Janusz"))));
    }
}
