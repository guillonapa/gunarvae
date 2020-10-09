package com.gnapa.mazes.client;

import com.gnapa.mazes.solver.Robot;
import com.gnapa.mazes.solver.RobotDirection;
import com.gnapa.mazes.utils.MazeConstants;

public class Runner extends Robot {

    public Runner(RobotDirection direction) {
        super(direction);
    }
    
    @Override
    public void execute() {
        // do nothing
    }

    public boolean isDone(String[][] maze) {
        if (maze == null) return false;
        if (maze.length == 0 || maze[0].length == 0) return false;
        return MazeConstants.EXIT.equals(maze[getY()][getX()]);
    }

}
