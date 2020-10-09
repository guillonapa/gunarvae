package com.gnapa.mazes.client;

import java.util.HashSet;
import java.util.Set;

import com.gnapa.mazes.solver.AbstractSolver;
import com.gnapa.mazes.solver.IRobot;
import com.gnapa.mazes.solver.Robot;

public class WallFollower extends AbstractSolver {


    public WallFollower(String[][] maze, int startingX, int startingY) {
        super(maze, startingX, startingY);
    }

    @Override
    public void solve(IRobot iRobot) {
        if (iRobot instanceof Robot) {
            Robot robot = (Robot) iRobot;
            robot.setInitialCoordinates(startingX, startingY);
            Set<String> visited = new HashSet<>();
            visitAll(robot, visited);
        }
    }
    
    private boolean visitAll(Robot robot, Set<String> visited) {
        
        if (robot.isDone(maze)) {
            return true;
        }
        
        robot.execute();
        visited.add(coorKey(robot));
        
        for (int i = 0; i < 4; i++) {
            if (robot.move(maze)) {
                if (visited.contains(coorKey(robot))) {
                    robot.turnRight();
                    robot.turnRight();
                    robot.move(maze);
                    robot.turnRight();
                    robot.turnRight();
                } else {
                    if (visitAll(robot, visited)) {
                        return true;
                    }
                }
            }
            robot.turnRight();
        }
        robot.turnRight();
        robot.turnRight();
        robot.move(maze);
        robot.turnRight();
        robot.turnRight();
        return false;
    }

    private String coorKey(Robot robot) {
        return String.format("%d-%d", robot.getX(), robot.getY());
    }

}
