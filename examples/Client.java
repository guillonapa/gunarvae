package com.gnapa.mazes.client;

import static java.util.Map.entry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

import com.gnapa.mazes.generator.MazeFromFileGenerator;
import com.gnapa.mazes.generator.MazeGenerator;
import com.gnapa.mazes.solver.IMazeSolver;
import com.gnapa.mazes.solver.IRobot;
import com.gnapa.mazes.solver.RobotDirection;
import com.gnapa.mazes.utils.MazeConstants;
import com.gnapa.mazes.utils.MazeUtils;

public class Client {
    
    public static void main(String[] args) throws IOException {
        emptyRoom();
//        smallRoom();
        simpleMaze();
    }

    private static void simpleMaze() throws IOException {
        // generate a maze
        MazeGenerator generator = new MazeGenerator();
        File mazeFile = Paths.get("simple.maze").toFile();
        String[][] maze = MazeFromFileGenerator.generateFromFile(mazeFile);
        
        // set the entrance (optional)
        maze = generator.entrance(maze, 0, 6);
        // set the exit (optional)
        maze = generator.exit(maze, 20, 14);
        
        // instantiate the solver
        IMazeSolver solver = new WallFollower(maze, 0, 6);
        // instantiate the robot
        IRobot robot = new Runner(RobotDirection.DOWN);
        // solve
        solver.solve(robot);
        // set a translator (optional)
        Map<String, String> translator = Map.ofEntries(
                entry(MazeConstants.ROBOT, "🤖"),
                entry(MazeConstants.PATH, "⛅️"),
                entry(MazeConstants.WALL, "🌲"),
                entry(MazeConstants.SPACE, "☁️")
        );
        
        // print result
        MazeUtils.printMaze(maze, robot.getX(), robot.getY(), translator);
    }

    private static void smallRoom() throws IOException {
        // generate a maze
        MazeGenerator generator = new MazeGenerator();
        File f = Paths.get("smallRoom.maze").toFile();
        String[][] maze = MazeFromFileGenerator.generateFromFile(f);
        maze = generator.entrance(maze, 0, 6);
        maze = generator.exit(maze, 7, 14);
        MazeUtils.printMaze(maze);
        System.out.println("\n-----\n");
        
        // instantiate the solver and the robot
        IMazeSolver solver = new WallFollower(maze, 0, 6);
//        IRobot robot = new Cleaner(RobotDirection.DOWN);
        IRobot robot = new Runner(RobotDirection.DOWN);
        solver.solve(robot);
    }

    private static void emptyRoom() throws IOException {
        // generate a maze
        MazeGenerator generator = new MazeGenerator();
        File f = Paths.get("emptyRoom.maze").toFile();
        String[][] maze = MazeFromFileGenerator.generateFromFile(f);
//        maze = generator.entrance(maze, 0, 6);
        maze = generator.exit(maze, 20, 14);
        MazeUtils.printMaze(maze);
        System.out.println("\n-----\n");
        
        // instantiate the solver and the robot
        IMazeSolver solver = new WallFollower(maze, 6, 6);
//        IRobot robot = new Cleaner(RobotDirection.DOWN);
        IRobot robot = new Runner(RobotDirection.DOWN);
        solver.solve(robot);
        MazeUtils.printMaze(maze, robot.getX(), robot.getY());
    }
    
}
