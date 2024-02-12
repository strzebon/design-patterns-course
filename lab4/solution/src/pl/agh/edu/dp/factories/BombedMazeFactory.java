package pl.agh.edu.dp.factories;

import pl.agh.edu.dp.labirynth.*;

public class BombedMazeFactory implements MazeFactory {

    private static BombedMazeFactory instance;

    private BombedMazeFactory() {

    }

    public static BombedMazeFactory getInstance() {
        if (instance == null) instance = new BombedMazeFactory();

        return instance;
    }
    @Override
    public Room createRoom() {
        return new BombedRoom();
    }

    @Override
    public Wall createWall() {
        return new BombedWall();
    }

    @Override
    public Door createDoor(Room r1, Room r2) {
        return new Door(r1, r2);
    }
}
