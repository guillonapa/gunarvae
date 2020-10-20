package com.gnapa.mazes.generator;

import java.util.List;

import com.gnapa.mazes.utils.Pair;

/**
 * <p>
 * An interface for a maze generator to implement. Used to generate two-dimensional
 * arrays representing a room, or a maze.
 * </p>
 * 
 * @author Guillermo Narvaez
 * @see MazeGenerator
 * @see MazeFromFileGenerator
 */
public interface IMazeGenerator {
    
    /**
     * <p>
     * Generates a new arrays with the provided number of rows and columns.
     * Two extra rows and two extra columns are added as wall padding if 
     * required.
     * </p>
     * 
     * @param rows
     *          number of rows
     * @param columns
     *          number of columns
     * @param addWallPadding
     *          true if extra rows and columns should be added as wall padding
     * @return the generated two dimensional array
     */
    public String[][] generate(int rows, int columns, boolean addWallPadding);
    
    /**
     * <p>
     * Marks as walls each of the spots in the maze that correspond to the coordinates
     * in the list of walls provided.
     * </p>
     * 
     * @param maze
     *          maze or room
     * @param walls
     *          list of coordinates for walls
     * @return the updated two dimensional array
     */
    public String[][] applyWalls(String[][] maze, List<Pair> walls);
    
    /**
     * <p>
     * Marks the corresponding spot in the maze as an entrance.
     * </p>
     * 
     * @param maze
     *          maze or room
     * @param row
     *          row index for the entrance
     * @param column
     *          column index for the entrance
     * @return the updated two dimensional array
     */
    public String[][] entrance(String[][] maze, int row, int column);
    
    /**
     * <p>
     * Marks the corresponding spot in the maze as an exit.
     * </p>
     * 
     * @param maze
     *          maze or room
     * @param row
     *          row index for the exit
     * @param column
     *          column index for the exit
     * @return the updated two dimensional array
     */
    public String[][] exit(String[][] maze, int row, int column);

}
