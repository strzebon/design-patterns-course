package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.game.Player;

import java.util.EnumMap;
import java.util.Map;

public class Room extends MapSite
{
    private static int id = 0;
    private int roomNumber;
    private Map<Direction, MapSite> sides;

    public Room(int number) {
        this.sides = new EnumMap<>(Direction.class);
        this.roomNumber = number;
        fillWalls();
    }

    public Room() {
        this.sides = new EnumMap<>(Direction.class);
        this.roomNumber = id;
        fillWalls();
        id += 1;
    }

    public MapSite getSide(Direction direction){
        return this.sides.get(direction);
    }

    public void setSide(Direction direction, MapSite ms){
        this.sides.put(direction, ms);
    }

    public int getRoomNumber(){
        return this.roomNumber;
    }

    @Override
    public void Enter(Player player){
        player.setCurrentRoom(this);
        System.out.println("You entered room nr " + roomNumber);
    }

    private void fillWalls() {
        for (Direction direction: Direction.values()) {
            setSide(direction, new Wall());
        }
    }
}
