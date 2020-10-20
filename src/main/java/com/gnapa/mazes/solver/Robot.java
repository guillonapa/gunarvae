package com.gnapa.mazes.solver;

import com.gnapa.mazes.utils.MazeConstants;
import com.gnapa.mazes.utils.Pair;

/**
 * <p>
 * Abstract working implementation of {@link IRobot}. At the bare minimum, any 
 * extending classes must override the {@link IRobot#isDone(String[][])} method.
 * If the extending robot needs to perform a custom action, the {@link IRobot#execute()}
 * method should also be overriden.
 * </p>
 * 
 * @author Guillermo Narvaez
 */
public abstract class Robot implements IRobot {
    
    /** The robot's current direction */
    private RobotDirection direction;
    
    /** The robot's starting row */
    private final int startingRow;
    
    /** The robot's starting column */
    private final int startingColumn;
    
    /** The robot's current row */
    private int row;
    
    /** The robot's current column */
    private int column;

    /**
     * <p>
     * Initializes the robot facing the provided direction, in the
     * provided initial coordinates.
     * </p>
     */
    public Robot(RobotDirection direction, Pair initialCoors) {
        this.direction = direction;
        this.startingRow = initialCoors.getRow();
        this.startingColumn = initialCoors.getColumn();
        initializeCurrentCoordinates();
    }

    /**
     * <p>
     * Moves the robot exactly on step in its current direction. If the
     * robot moves successfully, true is returned. Otherwise, false is
     * returned.
     * </p>
     * 
     * @param maze
     *          maze or room where the robot is
     * @return true if the robot was able to move, false otherwise
     */
    @Override
    public boolean move(String[][] maze) {
        maze[column][row] = MazeConstants.PATH;
        if (canMove(maze, getDirection())) {
            row = getDirection().updateRow(getRow());
            column = getDirection().updateColumn(getColumn());
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Returns whether or not the robot can move one step in its current
     * direction in the maze provided.
     * </p>
     * 
     * @param maze
     *          maze or room where the robot is
     * @param direction
     *          robot's current direction
     * @return true if the robot can move, false otherwise
     */
    @Override
    public boolean canMove(String[][] maze, RobotDirection direction) {
        if (maze == null) return false;
        if (maze.length == 0 || maze[0].length == 0) return false;
        int potentialX = direction.updateRow(getRow());
        int potentialY = direction.updateColumn(getColumn());
        if (potentialX < 0 || potentialX >= maze[0].length) return false;
        if (potentialY < 0 || potentialY >= maze.length) return false;
        return MazeConstants.SPACE.equals(maze[potentialY][potentialX]) 
                || MazeConstants.PATH.equals(maze[potentialY][potentialX]) 
                || MazeConstants.ENTRANCE.equals(maze[potentialY][potentialX])
                || MazeConstants.EXIT.equals(maze[potentialY][potentialX]);
    }

    /**
     * <p>
     * Turns the robot exactly 90º to the right once.
     * </p>
     */
    @Override
    public void turnRight() {
        direction = getDirection().nextRight();
    }

    /**
     * <p>
     * Turns the robot exactly 90º to the left once.
     * </p>
     */
    @Override
    public void turnLeft() {
        direction = getDirection().nextLeft();
    }
    
    /**
     * <p>
     * Executes an action for the robot's current position in the maze (room).
     * </p>
     */
    @Override
    public void execute() {
        //$FALL-THROUGH$
        // user can override for custom behavior
        //
    }
    
    /**
     * <p>
     * Returns the robot's current row index.
     * </p>
     * 
     * @return the row index
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * <p>
     * Returns the robot's current  column index.
     * </p>
     * 
     * @return the column index
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * <p>
     * Returns the robot's current direction in which it's facing.
     * </p>
     * 
     * @return the robot's current direction
     */
    @Override
    public RobotDirection getDirection() {
        return direction;
    }

    /**
     * <p>
     * Returns the robot's starting row index.
     * </p>
     * 
     * @return the starting row
     */
    public int getStartingRow() {
        return startingRow;
    }

    /**
     * <p>
     * Returns the robot's starting column index.
     * </p>
     * 
     * @return the starting column
     */
    public int getStartingColumn() {
        return startingColumn;
    }
    
    /**
     * <p>
     * Sets the current row and column to the starting coordinates.
     * </p>
     */
    private void initializeCurrentCoordinates() {
        row = getStartingRow();
        column = getStartingColumn();
    }

}
