package pl.agh.edu.dp.labirynth;

public class BombedRoom extends Room{

    public BombedRoom(int number) {
        super(number);
        fillWalls();
    }

    public BombedRoom() {
        super();
        fillWalls();
    }

    private void fillWalls() {
        for (Direction direction: Direction.values()) {
            setSide(direction, new BombedWall());
        }
    }
}
