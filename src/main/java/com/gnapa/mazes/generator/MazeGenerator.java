package com.gnapa.mazes.generator;

import java.util.List;

import com.gnapa.mazes.utils.MazeConstants;
import com.gnapa.mazes.utils.Pair;

/**
 * <p>
 * Basic implementation of {@link IMazeGenerator}.
 * </p>
 * 
 * @author Guillermo Narvaez
 * @see IMazeGenerator
 * @see MazeConstants
 */
public class MazeGenerator implements IMazeGenerator {
    
    /** Error message for when the maze to manipulate is null */
    private static final String MAZE_NULL_TEMPLATE = "Maze can't be null";
    
    /** Error message for when the size of the generated maze is invalid */
    private static final String EXCEPTION_AT_GENERATE_TEMPLATE = "Arguments to generate a maze should be greater or equal than 1: [%d, %d]";
    
    /** Error message for when the coordinates of a wall, entrance, or exit, are invalid */
    private static final String EXCEPTION_AT_APPLY_PAIR_COORS_TEMPLATE = "All pairs of coordinates should consist of valid coordinates for the maze";

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
    @Override
    public String[][] generate(int rows, int columns, boolean addWallPadding) {
        if (rows < 1 || columns < 1) 
            throw new IllegalArgumentException(String.format(EXCEPTION_AT_GENERATE_TEMPLATE, rows, columns));
        
        // update number of rows/columns if needed for padding
        if (addWallPadding) {
            columns += 2;
            rows += 2;
        }
        
        // initialize the maze
        String[][] maze = new String[columns][rows];
        for (String[] column : maze) {
            for (int i = 0; i < column.length; i++) {
                column[i] = MazeConstants.SPACE;
            }
        }
        
        // update the outer elements as walls
        if (addWallPadding) {
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    if (column == 0 || row == 0 || column == columns - 1 || row == rows - 1) {
                        maze[column][row] = MazeConstants.WALL;
                    }
                }
            }
        }
        return maze;
    }

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
    @Override
    public String[][] applyWalls(String[][] maze, List<Pair> walls) {
        // maze can't be null
        if (maze == null) throw new IllegalArgumentException(MAZE_NULL_TEMPLATE);

        // wall indexes
        int rowWallIndex = maze[0].length - 1;
        int columnWallIndex = maze.length - 1;
        for (Pair coors : walls) {
            if (coors.getRow() < 0 || coors.getRow() > rowWallIndex || coors.getColumn() < 0 || coors.getColumn() > columnWallIndex)
                throw new IllegalArgumentException(EXCEPTION_AT_APPLY_PAIR_COORS_TEMPLATE);
            // mark the wall
            maze[coors.getColumn()][coors.getRow()] = MazeConstants.WALL;
        }
        return maze;
    }

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
    @Override
    public String[][] entrance(String[][] maze, int row, int column) {
        // maze can't be null
        if (maze == null) throw new IllegalArgumentException(MAZE_NULL_TEMPLATE);
        
        // wall indexes
        int rowWallIndex = maze[0].length - 1;
        int columnWallIndex = maze.length - 1;
        if (row < 0 || row > rowWallIndex || column < 0 || column > columnWallIndex)
            throw new IllegalArgumentException(EXCEPTION_AT_APPLY_PAIR_COORS_TEMPLATE);
        
        // mark the entrance
        maze[column][row] = MazeConstants.ENTRANCE;
        return maze;
    }

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
    @Override
    public String[][] exit(String[][] maze, int row, int column) {
        // maze can't be null
        if (maze == null) throw new IllegalArgumentException(MAZE_NULL_TEMPLATE);
        
        // wall indexes
        int rowWallIndex = maze[0].length - 1;
        int columnWallIndex = maze.length - 1;
        if (row < 0 || row > rowWallIndex || column < 0 || column > columnWallIndex)
            throw new IllegalArgumentException(EXCEPTION_AT_APPLY_PAIR_COORS_TEMPLATE);
        
        // mark the exit
        maze[column][row] = MazeConstants.EXIT;
        return maze;
    }

}
