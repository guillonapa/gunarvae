package com.gnapa.mazes.client.solver;

import java.util.HashSet;
import java.util.Set;

import com.gnapa.mazes.solver.IMazeSolver;
import com.gnapa.mazes.solver.IRobot;

public class WallFollower implements IMazeSolver {

    private String[][] maze;

    @Override
    public void solve(IRobot robot, String[][] maze) {
        this.maze = maze;
        Set<String> visited = new HashSet<>();
        visitAll(robot, visited);
    }
    
    private boolean visitAll(IRobot robot, Set<String> visited) {
        
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

    private String coorKey(IRobot robot) {
        return String.format("%d-%d", robot.getRow(), robot.getColumn());
    }

}
