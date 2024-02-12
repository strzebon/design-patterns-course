package org.example;

public class Main {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(10);
        RoundPeg roundPeg = new RoundPeg(10);

        System.out.println(hole.fits(roundPeg));

        SquarePeg smallSquarePeg = new SquarePeg (10);
        SquarePeg largeSquarePeg = new SquarePeg (20);

        SquarePegAdapter smallSquarePegAdapter = new SquarePegAdapter(smallSquarePeg);
        SquarePegAdapter largeSquarePegAdapter = new SquarePegAdapter(largeSquarePeg);

        System.out.println(hole.fits(smallSquarePegAdapter));
        System.out.println(hole.fits(largeSquarePegAdapter));
    }
}