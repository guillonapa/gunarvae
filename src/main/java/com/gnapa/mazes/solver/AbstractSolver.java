package com.gnapa.mazes.solver;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Guillermo Narvaez
 */
public abstract class AbstractSolver implements IMazeSolver {
    
    protected String[][] maze;
    protected int startingX;
    protected int startingY;

    /**
     * <p>
     * 
     * </p>
     */
    public AbstractSolver(String[][] maze, int startingX, int startingY) {
        this.maze = maze;
        this.startingX = startingX;
        this.startingY = startingY;
    }

}
