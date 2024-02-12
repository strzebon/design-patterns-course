package pl.agh.edu.dp.builders;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;

public interface MazeBuilder {
    void reset();
    void addDoor(Door door);
    void addRoom(Room room);
    void mergeWalls(Direction direction, Wall wall, Room r1, Room r2);
}
