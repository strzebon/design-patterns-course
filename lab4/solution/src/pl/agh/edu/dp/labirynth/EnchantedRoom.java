package pl.agh.edu.dp.labirynth;

public class EnchantedRoom extends Room {
    public EnchantedRoom(int number) {
        super(number);
        fillWalls();
    }

    public EnchantedRoom() {
        super();
        fillWalls();
    }

    private void fillWalls() {
        for (Direction direction: Direction.values()) {
            setSide(direction, new EnchantedWall());
        }
    }
}
