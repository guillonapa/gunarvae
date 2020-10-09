package com.gnapa.mazes.utils;

import java.util.Map;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Guillermo Narvaez
 */
public class MazeUtils {
    
    /**
     * <p>
     * 
     * </p>
     * 
     * @param maze
     */
    public static void printMaze(String[][] maze) {
        for (int row = 0; row < maze[0].length; row++) {
            for (int column = 0; column < maze.length; column++) {
                System.out.print(String.format("%s ", maze[column][row]));
            }
            System.out.println();
        }
    }
    
    /**
     * <p>
     * 
     * </p>
     * 
     * @param maze
     * @param translator
     */
    public static void printMaze(String[][] maze, Map<String, String> translator) {
        for (int row = 0; row < maze[0].length; row++) {
            for (int column = 0; column < maze.length; column++) {
                String str = maze[column][row];
                if (translator.containsKey(str)) {
                    str = translator.get(str);
                }
                System.out.print(String.format("%s ", str));
            }
            System.out.println();
        }
    }
    
    /**
     * <p>
     * 
     * </p>
     * 
     * @param maze
     * @param x
     * @param y
     */
    public static void printMaze(String[][] maze, int x, int y) {
        for (int row = 0; row < maze[0].length; row++) {
            for (int column = 0; column < maze.length; column++) {
                if (x == row && y == column) {
                    System.out.print(String.format("%s ", MazeConstants.ROBOT));
                } else {
                    System.out.print(String.format("%s ", maze[column][row]));
                }
            }
            System.out.println();
        }
    }
    
    /**
     * <p>
     * 
     * </p>
     * 
     * @param maze
     * @param x
     * @param y
     * @param translator
     */
    public static void printMaze(String[][] maze, int x, int y, Map<String, String> translator) {
        for (int row = 0; row < maze[0].length; row++) {
            for (int column = 0; column < maze.length; column++) {
                if (x == row && y == column) {
                    String str = translator.containsKey(MazeConstants.ROBOT) ? 
                            translator.get(MazeConstants.ROBOT) : MazeConstants.ROBOT;
                    System.out.print(String.format("%s ", str));
                } else {
                    String str = maze[column][row];
                    if (translator.containsKey(str)) {
                        str = translator.get(str);
                    }
                    System.out.print(String.format("%s ", str));
                }
            }
            System.out.println();
        }
    }

}
