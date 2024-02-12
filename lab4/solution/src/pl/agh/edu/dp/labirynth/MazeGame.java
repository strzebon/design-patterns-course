package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.builders.MazeBuilder;
import pl.agh.edu.dp.factories.BombedMazeFactory;
import pl.agh.edu.dp.factories.EnchantedMazeFactory;
import pl.agh.edu.dp.factories.MazeFactory;

public class MazeGame {
    public Maze createMaze(){
        Maze maze = new Maze();

        Room r1 = new Room(1);
        Room r2 = new Room(2);

        Door door = new Door(r1, r2);

        maze.addRoom(r1);
        maze.addRoom(r2);

        r1.setSide(Direction.North, new Wall());
        r1.setSide(Direction.East, new Wall());
        r1.setSide(Direction.South, new Wall());
        r1.setSide(Direction.West, new Wall());

        r2.setSide(Direction.North, new Wall());
        r2.setSide(Direction.East, new Wall());
        r2.setSide(Direction.South, new Wall());
        r2.setSide(Direction.West, new Wall());

        return maze;
    }

    public void createMaze(MazeBuilder builder) {
        Room r1 = new Room();
        Room r2 = new Room();
        Room r3 = new Room();
        builder.addRoom(r1);
        builder.addRoom(r2);
        builder.addRoom(r3);
        builder.mergeWalls(Direction.West, new Wall(), r1, r2);
        builder.addDoor(new Door(r1, r2));
        builder.mergeWalls(Direction.North, new Wall(), r2, r3);
        builder.addDoor(new Door(r2, r3));
    }

    public void createMaze(MazeBuilder builder, MazeFactory factory) {
        Room r1 = factory.createRoom();
        Room r2 = factory.createRoom();
        Room r3 = factory.createRoom();
        builder.addRoom(r1);
        builder.addRoom(r2);
        builder.addRoom(r3);
        builder.mergeWalls(Direction.West, factory.createWall(), r1, r2);
        builder.addDoor(new Door(r1, r2));
        builder.mergeWalls(Direction.North, factory.createWall(), r2, r3);
        builder.addDoor(new Door(r2, r3));
    }

    public void checkSingletons() {
        MazeFactory factory1 = EnchantedMazeFactory.getInstance();
        MazeFactory factory2 = EnchantedMazeFactory.getInstance();

        if(factory1.equals(factory2)) {
            System.out.println("Same objects");
        }
        else{
            System.out.println("Not same objects");
        }

        MazeFactory factory3 = BombedMazeFactory.getInstance();
        MazeFactory factory4 = BombedMazeFactory.getInstance();
        if(factory3.equals(factory4)) {
            System.out.println("Same objects");
        }
        else System.out.println("Not same objects");
    }
}
