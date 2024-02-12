package pl.agh.edu.dp.factories;

import pl.agh.edu.dp.labirynth.*;

public class EnchantedMazeFactory implements MazeFactory{

    private static EnchantedMazeFactory instance;

    private EnchantedMazeFactory() {

    }

    public static EnchantedMazeFactory getInstance() {
        if (instance == null) instance = new EnchantedMazeFactory();

        return instance;
    }

    @Override
    public Room createRoom() {
        return new EnchantedRoom();
    }

    @Override
    public Wall createWall() {
        return new EnchantedWall();
    }

    @Override
    public Door createDoor(Room r1, Room r2) {
        return new EnchantedDoor(r1, r2);
    }
}
