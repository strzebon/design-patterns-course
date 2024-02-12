package pl.agh.edu.dp.main;

import pl.agh.edu.dp.builders.StandardMazeBuilder;
import pl.agh.edu.dp.factories.BombedMazeFactory;
import pl.agh.edu.dp.game.Game;
import pl.agh.edu.dp.game.Player;
import pl.agh.edu.dp.labirynth.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        MazeGame mazeGame = new MazeGame();
        mazeGame.checkSingletons();
//        Maze maze = mazeGame.createMaze();
//        System.out.println(maze.getRoomNumbers());

        StandardMazeBuilder standardMazeBuilder = new StandardMazeBuilder();
        mazeGame.createMaze(standardMazeBuilder, BombedMazeFactory.getInstance());
        Maze maze=standardMazeBuilder.getResultedMaze();
        Player player=new Player(20);
        Game game=new Game(maze,player);
        game.startGame();

    }
}




