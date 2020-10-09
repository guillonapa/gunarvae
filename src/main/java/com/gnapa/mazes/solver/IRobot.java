package com.gnapa.mazes.solver;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Guillermo Narvaez
 */
public interface IRobot {

    /**
     * <p>
     * 
     * </p>
     */
    public void execute();

    /**
     * <p>
     * 
     * </p>
     * 
     * @param startingX
     * @param startingY
     */
    public void setInitialCoordinates(int startingX, int startingY);
    
    /**
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    public int getX();

    /**
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    public int getY();
    
    /**
     * <p>
     * 
     * </p>
     * 
     * @param maze
     * @return
     */
    public boolean isDone(String[][] maze);

}
