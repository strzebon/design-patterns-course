package org.example;

public class RoundHole {
    private final double radius;

    public RoundHole(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }

    public boolean fits(RoundPeg peg){
        return peg.getRadius() <= this.getRadius();
    }
}
