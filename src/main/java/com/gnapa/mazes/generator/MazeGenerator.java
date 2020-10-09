package com.gnapa.mazes.generator;

import java.util.List;

import com.gnapa.mazes.utils.MazeConstants;
import com.gnapa.mazes.utils.Pair;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Guillermo Narvaez
 */
public class MazeGenerator implements IMazeGenerator {
    
    private static final String EXCEPTION_AT_GENERATE_TEMPLATE = "Arguments to generate a maze should be greater or equal than 1: [%d, %d]";
    private static final String EXCEPTION_AT_APPLY_PAIR_COORS_TEMPLATE = "All pairs of coordinates should consist of valid coordinates for the maze";
    private static final String EXCEPTION_AT_APPLY_MAZE_SIZE_TEMPLATE = "All pairs of coordinates should consist of valid coordinates for the maze";

    /**
     * <p>
     * 
     * </p>
     */
    @Override
    public String[][] generate(int numRows, int numColumns, boolean hasBorders) {
        if (numRows < 1 || numColumns < 1) 
            throw new IllegalArgumentException(String.format(EXCEPTION_AT_GENERATE_TEMPLATE, numRows, numColumns));
        int columns = numColumns;
        int rows = numRows;
        if (!hasBorders) {
            columns += 2;
            rows += 2;
        }
        String[][] maze = new String[columns][rows];
        for (String[] column : maze) {
            for (int i = 0; i < column.length; i++) {
                column[i] = MazeConstants.SPACE;
            }
        }
        String borderString = hasBorders ? MazeConstants.SPACE : MazeConstants.WALL;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (column == 0 || row == 0 || column == columns - 1 || row == rows - 1) {
                    maze[column][row] = borderString;
                }
            }
        }
        return maze;
    }

    /**
     * <p>
     * 
     * </p>
     */
    @Override
    public String[][] apply(String[][] maze, List<Pair> walls) {
        // maze should be at least 3x3 (single square being walled)
        if (maze.length < 3 || maze[0].length < 3)
            throw new IllegalArgumentException(EXCEPTION_AT_APPLY_MAZE_SIZE_TEMPLATE);
        
        // wall indexes
        int rowWallIndex = maze[0].length - 1;
        int columnWallIndex = maze.length - 1;
        for (Pair coors : walls) {
            if (coors.row < 0 || coors.row > rowWallIndex || coors.column < 0 || coors.column > columnWallIndex)
                throw new IllegalArgumentException(EXCEPTION_AT_APPLY_PAIR_COORS_TEMPLATE);
            maze[coors.column][coors.row] = MazeConstants.WALL;
        }
        return maze;
    }

    /**
     * <p>
     * 
     * </p>
     */
    @Override
    public String[][] entrance(String[][] maze, int x, int y) {
        // maze should be at least 3x3 (single square being walled)
        if (maze.length < 3 || maze[0].length < 3)
            throw new IllegalArgumentException(EXCEPTION_AT_APPLY_MAZE_SIZE_TEMPLATE);
        
        // wall indexes
        int rowWallIndex = maze[0].length - 1;
        int columnWallIndex = maze.length - 1;
        if (x < 0 || x > rowWallIndex || y < 0 || y > columnWallIndex)
            throw new IllegalArgumentException(EXCEPTION_AT_APPLY_PAIR_COORS_TEMPLATE);
        
        maze[y][x] = MazeConstants.ENTRANCE;
        return maze;
    }

    /**
     * <p>
     * 
     * </p>
     */
    @Override
    public String[][] exit(String[][] maze, int x, int y) {
        // maze should be at least 3x3 (single square being walled)
        if (maze.length < 3 || maze[0].length < 3)
            throw new IllegalArgumentException(EXCEPTION_AT_APPLY_MAZE_SIZE_TEMPLATE);
        
        // wall indexes
        int rowWallIndex = maze[0].length - 1;
        int columnWallIndex = maze.length - 1;
        if (x < 0 || x > rowWallIndex || y < 0 || y > columnWallIndex)
            throw new IllegalArgumentException(EXCEPTION_AT_APPLY_PAIR_COORS_TEMPLATE);
        
        maze[y][x] = MazeConstants.EXIT;
        return maze;
    }

}
