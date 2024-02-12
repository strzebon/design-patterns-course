package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.game.Player;

public class Wall extends MapSite {
    public Wall(){

    }

    @Override
    public void Enter(Player player) {
        System.out.println("You hit the wall");
        player.receiveDamage(5);
    }
}
