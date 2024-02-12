package pl.agh.edu.dp.builders;

import pl.agh.edu.dp.labirynth.*;

public class StandardMazeBuilder implements MazeBuilder {

    private Maze currentMaze;

    public StandardMazeBuilder() {
        reset();
    }
    @Override
    public void reset() {
        currentMaze = new Maze();
    }

    @Override
    public void addDoor(Door door) {
        Room r1 = door.getRoom1();
        Room r2 = door.getRoom2();
        Direction direction = commonWall(r1, r2);
        r1.setSide(direction, door);
        r2.setSide(Direction.reverse(direction), door);
    }

    @Override
    public void addRoom(Room room) {
        currentMaze.addRoom(room);
    }

    @Override
    public void mergeWalls(Direction direction, Wall wall, Room r1, Room r2) {
        r1.setSide(direction, wall);
        r2.setSide(Direction.reverse(direction), wall);
    }

    private Direction commonWall(Room r1, Room r2) {
        Direction[] directions = Direction.values();
        for (Direction direction: directions) {
            if (r1.getSide(direction).equals(r2.getSide(Direction.reverse(direction)))){
                return direction;
            }
        }

        throw new IllegalArgumentException("Couldn't make door");
    }

    public Maze getResultedMaze() {
        Maze product = currentMaze;
        this.reset();
        return product;
    }
}
