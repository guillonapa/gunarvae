package com.gnapa.mazes.solver;

/**
 * <p>
 * Enumeration to represent the direction in which a {@link IRobot} is facing.
 * </p>
 * 
 * @author Guillermo Narvaez
 */
public enum RobotDirection {
    
    UP, RIGHT, DOWN, LEFT;

    /**
     * <p>
     * Returns the direction in which the robot would
     * be facing if it were to turn 90º to the right.
     * </p>
     * 
     * @return the direction after turning right once
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
     * Returns the direction in which the robot would
     * be facing if it were to turn 90º to the left.
     * </p>
     * 
     * @return the direction after turning left once
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
     * Returns the new index for the row in the maze where the
     * robot should be if it were to move one step in its current
     * direction.
     * </p>
     * 
     * @param row
     *          current row
     * @return the updated row index
     */
    public int updateRow(int row) {
        switch (this) {
        case DOWN:
            return row + 1;
        case UP:
            return row - 1;
        default:
            break;
        }
        return row;
    }

    /**
     * <p>
     * Returns the new index for the column in the maze where the
     * robot should be if it were to move one step in its current
     * direction.
     * </p>
     * 
     * @param column
     *          current column
     * @return the updated column index
     */
    public int updateColumn(int column) {
        switch (this) {
        case RIGHT:
            return column + 1;
        case LEFT:
            return column - 1;
        default:
            break;
        }
        return column;
    }
    
}
