package pl.agh.edu.dp.labirynth;

public enum Direction {
    North, South, East, West;

    public static Direction reverse(Direction direction) {
        return switch (direction) {
            case North -> South;
            case South -> North;
            case East -> West;
            case West -> East;
        };
    }
}