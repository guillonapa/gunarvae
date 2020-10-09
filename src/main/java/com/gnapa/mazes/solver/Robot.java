package com.gnapa.mazes.solver;

import com.gnapa.mazes.utils.MazeConstants;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Guillermo Narvaez
 */
public abstract class Robot implements IRobot {
    
    private RobotDirection direction;
    private int initialX;
    private int initialY;
    private int x;
    private int y;

    /**
     * <p>
     * 
     * </p>
     */
    public Robot(RobotDirection direction) {
        this.direction = direction;
    }

    /**
     * <p>
     * 
     * </p>
     * 
     * @param maze
     * @return
     */
    public boolean move(String[][] maze) {
        maze[y][x] = MazeConstants.PATH;
        if (canMove(maze, getDirection())) {
            x = getDirection().updateX(getX());
            y = getDirection().updateY(getY());
            return true;
        }
        return false;
    }

    /**
     * <p>
     * 
     * </p>
     * 
     * @param maze
     * @param direction
     * @return
     */
    private boolean canMove(String[][] maze, RobotDirection direction) {
        if (maze == null) return false;
        if (maze.length == 0 || maze[0].length == 0) return false;
        int potentialX = direction.updateX(getX());
        int potentialY = direction.updateY(getY());
        if (potentialX < 0 || potentialX >= maze[0].length) return false;
        if (potentialY < 0 || potentialY >= maze.length) return false;
        return MazeConstants.SPACE.equals(maze[potentialY][potentialX]) || MazeConstants.PATH.equals(maze[potentialY][potentialX]) || MazeConstants.EXIT.equals(maze[potentialY][potentialX]);
    }

    /**
     * <p>
     * 
     * </p>
     */
    public void turnRight() {
        direction = getDirection().nextRight();
    }

    /**
     * <p>
     * 
     * </p>
     */
    public void turnLeft() {
        direction = getDirection().nextLeft();
    }
    
    /**
     * <p>
     * 
     * </p>
     */
    @Override
    public void execute() {
        System.out.println(String.format("Executing action..."));
    }
    
    /**
     * <p>
     * 
     * </p>
     */
    @Override
    public void setInitialCoordinates(int startingX, int startingY) {
        initialX = startingX;
        initialY = startingY;
        x = getInitialX();
        y = getInitialY();
    }

    /**
     * <p>
     * 
     * </p>
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * <p>
     * 
     * </p>
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    public int getInitialX() {
        return initialX;
    }

    /**
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    public int getInitialY() {
        return initialY;
    }

    /**
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    public RobotDirection getDirection() {
        return direction;
    }

}
