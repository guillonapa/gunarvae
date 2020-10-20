package com.gnapa.mazes.solver;

/**
 * <p>
 * An interface for all maze solving algorithms to follow.
 * </p>
 * 
 * @author Guillermo Narvaez
 * @see MazeSolver
 */
public interface IMazeSolver {
    
    /**
     * <p>
     * Performs the solving (or exploring) algorithm using the robot and
     * the maze provided.
     * </p>
     * 
     * @param robot
     *          robot to solve or explore the maze (room)
     * @param maze
     *          maze or room to solve or explore
     */
    public void solve(IRobot robot, String[][] maze);
    
}
