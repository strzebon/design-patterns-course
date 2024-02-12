package pl.agh.edu.dp.builders;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;

public class CountingMazeBuilder implements MazeBuilder {

    private int roomCounter;
    private int doorCounter;
    private int wallCounter;

    @Override
    public void reset() {
        roomCounter = 0;
        doorCounter = 0;
        wallCounter = 0;
    }

    @Override
    public void addDoor(Door door) {
        doorCounter += 1;
    }

    @Override
    public void addRoom(Room room) {
        roomCounter += 1;
        wallCounter += 4;
    }

    @Override
    public void mergeWalls(Direction direction, Wall wall, Room r1, Room r2) {
        wallCounter -= 1;
    }

    public int getCounts(){
        return roomCounter + doorCounter + wallCounter;
    }

    public int getRoomCounter() {
        return roomCounter;
    }

    public int getDoorCounter() {
        return doorCounter;
    }

    public int getWallCounter() {
        return wallCounter;
    }
}
