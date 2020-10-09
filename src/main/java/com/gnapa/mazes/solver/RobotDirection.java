package com.gnapa.mazes.solver;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Guillermo Narvaez
 */
public enum RobotDirection {
    
    UP, RIGHT, DOWN, LEFT;

    /**
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    public RobotDirection nextRight() {
        switch (this) {
        case UP:
            return RIGHT;
        case DOWN:
            return LEFT;
        case LEFT:
            return UP;
        case RIGHT:
            return DOWN;
        }
        return null;
    }
    
    /**
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    public RobotDirection nextLeft() {
        switch (this) {
        case UP:
            return LEFT;
        case DOWN:
            return RIGHT;
        case LEFT:
            return DOWN;
        case RIGHT:
            return UP;
        }
        return null;
    }

    /**
     * <p>
     * 
     * </p>
     * 
     * @param x
     * @return
     */
    public int updateX(int x) {
        switch (this) {
        case DOWN:
            return x + 1;
        case UP:
            return x - 1;
        default:
            break;
        }
        return x;
    }

    /**
     * <p>
     * 
     * </p>
     * 
     * @param y
     * @return
     */
    public int updateY(int y) {
        switch (this) {
        case RIGHT:
            return y + 1;
        case LEFT:
            return y - 1;
        default:
            break;
        }
        return y;
    }
    
}
