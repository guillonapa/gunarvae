package com.gnapa.mazes.utils;

import java.io.PrintStream;
import java.util.Map;

/**
 * <p>
 * Utilities for the mazes library.
 * </p>
 * 
 * @author Guillermo Narvaez
 */
public class MazeUtils {

    private static int INVALID_INDEX = -1;
    
    /**
     * <p>
     * Prints a maze to standard output, using the constants from {@link MazeConstants}.
     * </p>
     * 
     * @param maze
     *          array representing the maze
     */
    public static void printMaze(String[][] maze) {
        printMaze(maze, null);
    }
    
    /**
     * <p>
     * Prints a maze to standard output, using the constants from {@link MazeConstants}
     * while substituting all occurrences using the provided translator.
     * </p>
     * 
     * @param maze
     *          array representing the maze
     * @param translator
     *          map with string substitutions to use when printing
     */
    public static void printMaze(String[][] maze, Map<String, String> translator) {
        printMaze(maze, INVALID_INDEX, INVALID_INDEX, translator);
    }
    
    /**
     * <p>
     * Prints a maze to standard output, using the constants from {@link MazeConstants}.
     * The location of the robot is printed using the row and column coordinates.
     * </p>
     * 
     * @param maze
     *          array representing the maze
     * @param row
     *          row index for the robot's location
     * @param column
     *          column index for the robot's location
     */
    public static void printMaze(String[][] maze, int row, int column) {
        printMaze(maze, row, column, null);
    }

    /**
     * <p>
     * Prints a maze to standard output, using the constants from {@link MazeConstants}
     * while substituting all occurrences using the provided translator. The location of 
     * the robot is printed using the row and column coordinates.
     * </p>
     * 
     * @param maze
     *          array representing the maze
     * @param row
     *          row index for the robot's location
     * @param column
     *          column index for the robot's location
     * @param translator
     *          map with string substitutions to use when printing
     */
    public static void printMaze(String[][] maze, int row, int column, Map<String, String> translator) {
        printMaze(maze, row, column, translator, System.out);
    }
    
    /**
     * <p>
     * Prints a maze using the provided {@link PrintStream}, using the constants from 
     * {@link MazeConstants} while substituting all occurrences using the provided 
     * translator. The location of the robot is printed using the row and column coordinates.
     * </p>
     * 
     * @param maze
     *          array representing the maze
     * @param row
     *          row index for the robot's location
     * @param column
     *          column index for the robot's location
     * @param translator
     *          map with string substitutions to use when printing
     */
    public static void printMaze(String[][] maze, int row, int column, Map<String, String> translator, PrintStream printer) {
        // validate maze
        String error = null;
        if (maze == null) error = "maze is null";
        if (maze.length == 0 || maze[0].length == 0) error = "maze should at least be of size 1x1";
        if (error != null) {
            printer.println(String.format("Unable to print: %s", error));
            return;
        }

        // traverse and print
        for (int currRow = 0; currRow < maze[0].length; currRow++) {
            for (int currColumn = 0; currColumn < maze.length; currColumn++) {
                String curr = maze[currColumn][currRow];
                if (row == currRow && column == currColumn) {
                    // override with robot
                    curr = translator != null && translator.containsKey(MazeConstants.ROBOT) ? 
                            translator.get(MazeConstants.ROBOT) : MazeConstants.ROBOT;
                } else {
                    // check if the string representation exists in the translator
                    curr = translator != null && translator.containsKey(curr) ?
                            translator.get(curr) : curr;
                }
                // print the current entry
                printer.print(String.format("%s ", curr));
            }
            // append a new line
            printer.println();
        }
    }

}
