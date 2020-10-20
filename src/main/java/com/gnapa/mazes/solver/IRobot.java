package com.gnapa.mazes.solver;

/**
 * <p>
 * An interface for all robot implementations to follow.
 * </p>
 * 
 * @author Guillermo Narvaez
 * @see Robot
 */
public interface IRobot {

    /**
     * <p>
     * Executes an action for the robot's current position in the maze (room).
     * </p>
     */
    public void execute();

    /**
     * <p>
     * Returns the robot's current row index.
     * </p>
     * 
     * @return the row index
     */
    public int getRow();

    /**
     * <p>
     * Returns the robot's current  column index.
     * </p>
     * 
     * @return the column index
     */
    public int getColumn();
    
    /**
     * <p>
     * Returns whether the robot is done and no more movement is required.
     * </p>
     * 
     * @param maze
     *          maze (room) in which the robot is operating
     * @return true if the robot is done performing the task, false otherwise
     */
    public boolean isDone(String[][] maze);
    
    /**
     * <p>
     * Turns the robot exactly 90º to the right once.
     * </p>
     */
    public void turnRight();
    
    /**
     * <p>
     * Turns the robot exactly 90º to the left once.
     * </p>
     */
    public void turnLeft();

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
    public boolean canMove(String[][] maze, RobotDirection direction);
    
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
    public boolean move(String[][] maze);
    
    /**
     * <p>
     * Returns the robot's current direction in which it's facing.
     * </p>
     * 
     * @return the robot's current direction
     */
    public RobotDirection getDirection();
    
}
