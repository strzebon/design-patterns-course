package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.game.Player;

public class Door extends MapSite {
    private Room room1;
    private Room room2;

    public Door(Room r1, Room r2){
        this.room1 = r1;
        this.room2 = r2;
    }

    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setRoom2(Room room2) {
        this.room1 = room2;
    }

    @Override
    public void Enter(Player player) {
        System.out.println("You went through the door");
        if(player.getCurrentRoom().equals(room1)) {
            room2.Enter(player);
        } else {
            room1.Enter(player);
        }
    }
}
