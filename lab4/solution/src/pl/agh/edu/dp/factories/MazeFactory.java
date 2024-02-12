package pl.agh.edu.dp.factories;

import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;

public interface MazeFactory {
    Room createRoom();
    Wall createWall();
    Door createDoor(Room r1, Room r2);
}
