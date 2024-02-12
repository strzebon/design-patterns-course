package pl.edu.agh.to.lab4;

import java.util.Calendar;

public class Prisoner extends Suspect {
    private final int judgementYear;

    private final int senteceDuration;

    private final String pesel;

    public Prisoner(String firstName, String lastName, String pesel, int judgementYear, int sentenceDuration) {
        super(firstName, lastName);
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.senteceDuration = sentenceDuration;
    }

    public String getPesel() {
        return pesel;
    }

    @Override
    public int getAge() {
        int y = Integer.parseInt(pesel.substring(0,2));
        int m = Integer.parseInt(pesel.substring(2,3));
        int year;
        if (m >= 2) year = 2000 + y;
        else year = 1900 + y;
        return getCurrentYear() - year;
    }

    public boolean canBeAccused() {
        return judgementYear + senteceDuration <= getCurrentYear();
    }

    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
