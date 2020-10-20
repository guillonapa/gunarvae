package com.gnapa.mazes.client;

import static java.util.Map.entry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

import com.gnapa.mazes.client.solver.WallFollower;
import com.gnapa.mazes.generator.MazeFromFileGenerator;
import com.gnapa.mazes.generator.MazeGenerator;
import com.gnapa.mazes.solver.IMazeSolver;
import com.gnapa.mazes.solver.IRobot;
import com.gnapa.mazes.solver.RobotDirection;
import com.gnapa.mazes.utils.MazeConstants;
import com.gnapa.mazes.utils.MazeUtils;
import com.gnapa.mazes.utils.Pair;

public class Client {
    
    public static void main(String[] args) throws IOException {
        emptyRoom();
        smallRoom();
        simpleMaze();
        unboundedRoom();
    }

    private static void simpleMaze() throws IOException {
        // generate a maze
        MazeGenerator generator = new MazeGenerator();
        File mazeFile = Paths.get("simple.maze").toFile();
        String[][] maze = MazeFromFileGenerator.generate(mazeFile);
        
        // set the entrance (optional)
        maze = generator.entrance(maze, 0, 6);
        // set the exit (optional)
        maze = generator.exit(maze, 20, 14);
        
        // instantiate the solver
        IMazeSolver solver = new WallFollower();
        // instantiate the robot
        IRobot robot = new Runner(RobotDirection.DOWN, Pair.create(0, 6));
        // solve
        solver.solve(robot, maze);
        // set a translator (optional)
        Map<String, String> translator = Map.ofEntries(
                entry(MazeConstants.ROBOT, "🤖"),
                entry(MazeConstants.PATH, "⛅️"),
                entry(MazeConstants.WALL, "🌲"),
                entry(MazeConstants.SPACE, "☁️")
        );
        
        // print result
        MazeUtils.printMaze(maze, robot.getRow(), robot.getColumn(), translator);
    }
    
    private static void unboundedRoom() throws IOException {
        // generate a maze
        MazeGenerator generator = new MazeGenerator();
        String[][] maze = generator.generate(6, 10, true);
        maze = generator.entrance(maze, 1, 0);
        maze = generator.exit(maze, 7,10);
        MazeUtils.printMaze(maze);
        // instantiate the solver and the robot
        IMazeSolver solver = new WallFollower();
        IRobot robot = new Runner(RobotDirection.DOWN, Pair.create(3, 3));
        solver.solve(robot, maze);
        MazeUtils.printMaze(maze, robot.getRow(), robot.getColumn());
    }

    private static void smallRoom() throws IOException {
        // generate a maze
        MazeGenerator generator = new MazeGenerator();
        String[][] maze = generator.generate(6, 14, true);
        maze = generator.entrance(maze, 0, 6);
        maze = generator.exit(maze, 7, 14);
        MazeUtils.printMaze(maze);
        
        // instantiate the solver and the robot
        IMazeSolver solver = new WallFollower();
        IRobot robot = new Runner(RobotDirection.DOWN, Pair.create(0, 6));
        solver.solve(robot, maze);
        MazeUtils.printMaze(maze, robot.getRow(), robot.getColumn());
    }

    private static void emptyRoom() throws IOException {
        // generate a maze
        MazeGenerator generator = new MazeGenerator();
        File f = Paths.get("emptyRoom.maze").toFile();
        String[][] maze = MazeFromFileGenerator.generate(f);
        maze = generator.exit(maze, 20, 14);
        MazeUtils.printMaze(maze);
        
        // instantiate the solver and the robot
        IMazeSolver solver = new WallFollower();
        IRobot robot = new Runner(RobotDirection.DOWN, Pair.create(6, 6));
        solver.solve(robot, maze);
        MazeUtils.printMaze(maze, robot.getRow(), robot.getColumn());
    }
    
}
