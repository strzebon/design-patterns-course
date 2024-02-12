package pl.agh.edu.dp.game;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Room;

public class Player {
    private int health;
    private Room room;

    public Player(int health) {
        this.health = health;
    }

    public void receiveDamage(int i) {
        health -= i;
        System.out.println("You received " + i + " damage");
    }

    public void moveLeft() {
        room.getSide(Direction.East).Enter(this);
    }

    public void moveRight() {
        room.getSide(Direction.West).Enter(this);
    }

    public void moveForward() {
        room.getSide(Direction.North).Enter(this);
    }

    public void moveBackward() {
        room.getSide(Direction.South).Enter(this);
    }

    @Override
    public String toString() {
        return "Player: " +
                "health=" + health +
                ", currentRoom=" + room.getRoomNumber();
    }

    public int getHealth() {
        return health;
    }

    public Room getCurrentRoom() {
        return room;
    }

    public void setCurrentRoom(Room room) {
        this.room = room;
    }
}
