package pl.agh.edu.dp.game;

import pl.agh.edu.dp.labirynth.Maze;

import java.io.IOException;

public class Game {
    private Maze maze;
    private Player player;

    public Game(Maze maze, Player player) {
        this.maze = maze;
        player.setCurrentRoom(maze.getStartRoom());
        this.player = player;
    }

    private void beforeStart() {
        System.out.println("wasd - movement, q - exit");
        System.out.println(player);
    }

    public void startGame() throws IOException {
        beforeStart();
        char input = 0;
        while(input != 'q') {
            input = (char) System.in.read();
            switch (movePlayer(input)) {
                case -1 -> {
                    System.out.println("You died");
                    System.out.println("GAME OVER");
                    return;
                }
                case 1 -> {
                    System.out.println("YOU WON");
                    return;
                }
            }
        }
    }

    public int movePlayer(int x) {
        switch (x) {
            case 'a' -> {
                player.moveLeft();
            }
            case 'd' -> {
                player.moveRight();
            }
            case 'w' -> {
                player.moveForward();
            }
            case 's' -> {
                player.moveBackward();
            }
            default -> {
                return -2;
            }
        }
        return checkAfterMovement();
    }

    private int checkAfterMovement() {
        if(player.getHealth() <= 0) {
            return -1;
        }
        if(player.getCurrentRoom().equals(maze.getEndRoom())) {
            return 1;
        }
        System.out.println(player);
        return 0;
    }
}
