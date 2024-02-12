package pl.edu.agh.to.lab4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FinderTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut;
    private PersonDataProvider personDataProvider = new PersonDataProvider();
    private PrisonersDatabase prisonersDatabase = new PrisonersDatabase();
    private Finder suspectFinder = new Finder(new CompositeAggregate(List.of(personDataProvider, prisonersDatabase)));
    private CompositeSearchStrategy searchStrategy = new CompositeSearchStrategy(List.of(new NameSearchStrategy("Jan")));

    @Test
    public void testDisplayingNotJailedPrisoner() {
        prisonersDatabase.addPrisoner("Wiezeienie stanowe", new Prisoner("Jan", "Kowalski2", "802104543357", 2000, 1));
        suspectFinder.display(searchStrategy);
        assertContentIsDisplayed("Jan Kowalski2");
    }

    @Test
    public void testDisplayingSuspectedPerson() {
        personDataProvider.getAllCracovCitizens().add(new Person("Jan", "Kowalski2", 20));
        suspectFinder.display(searchStrategy);
        assertContentIsDisplayed("Jan Kowalski2");
    }

    @Test
    public void testNotDisplayingTooYoungPerson() {
        personDataProvider.getAllCracovCitizens().add(new Person("Jan", "Kowalski2", 15));
        suspectFinder.display(searchStrategy);
        assertContentIsNotDisplayed("Jan Kowalski2");
    }

    @Test
    public void testNotDisplayingJailedPrisoner() {
        personDataProvider.getAllCracovCitizens().add(new Person("Jan", "Kowalski", 20));
        prisonersDatabase.addPrisoner("Wiezeienie stanowe", new Prisoner("Jan", "Kowalski2", "802104543357", 2010, 20));
        suspectFinder.display(searchStrategy);
        assertContentIsNotDisplayed("Jan Kowalski2");
    }

    @Test
    public void testDisplayingSuspectedPersonWithGivenCombinedFilters(){
        searchStrategy = new CompositeSearchStrategy(List.of(new NameSearchStrategy("Jan"), new AgeSearchStrategy(20)));
        personDataProvider.getAllCracovCitizens().add(new Person("Jan", "Kowalski2", 20));
        personDataProvider.getAllCracovCitizens().add(new Person("Janusz", "Kowalski2", 20));
        personDataProvider.getAllCracovCitizens().add(new Person("Jan", "Kowalski3", 21));
        suspectFinder.display(searchStrategy);
        assertContentIsDisplayed("Jan Kowalski2");
        assertContentIsNotDisplayed("Janusz Kowalski2");
        assertContentIsNotDisplayed("Jan Kowalski3");
    }

    private void assertContentIsDisplayed(String expectedContent) {
        assertTrue("Application did not contain expected content: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    private void assertContentIsNotDisplayed(String expectedContent) {
        assertFalse("Application did contain expected content although it should not: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    @Before
    public void redirectSystemOut() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void resetSystemOut() {
        System.setOut(originalOut);
    }
}
