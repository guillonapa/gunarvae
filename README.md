# Mazes

![build status badge](https://github.com/guillonapa/mazes/workflows/Maven%20Build/badge.svg)

Library to generate mazes (or rooms) and interfaces for users to use when writing code for a "robot" to explore the generated mazes. The library's main purpose is academic – to allow users to quickly code their own implementations of well-known algorithms for either exploring an unknown grid, or finding the path to exit a maze.

## Getting Started

To use the library you will need to do only two things. First, you will need to extend the `Robot` class (or implement your own `IRobot`).

```java
public class Explorer extends Robot {

    public Explorer(RobotDirection direction, Pair initialCoors) {
        super(direction, initialCoors);
    }

    @Override
    public void execute() {
        String message = String.format("Exploring (%d, %d)...", 
                                        getRow(), 
                                        getColumn());
        System.out.println(message);
    }

    public boolean isDone(String[][] maze) {
        return false;
    }

}
```

Second, you will need to implement `IMazeSolver`. This will be the implementation of your algorithm (Wall Follower, Trémaux's algorithm, etc). For example:

```java
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
```

After that, you can generate your own maze and use your `IRobot` and `IMazeSolver` to test your algorithm.

```java
// generate a maze
MazeGenerator generator = new MazeGenerator();
File mazeFile = Paths.get("simple.maze").toFile();
String[][] maze = MazeFromFileGenerator.generate(mazeFile);

// set the entrance (optional)
maze = generator.entrance(maze, 0, 6);
// set the exit (optional)
maze = generator.exit(maze, 20, 14);

// instantiate the solver
IMazeSolver solver = new WallFollower();
// instantiate the robot
IRobot robot = new Explorer(RobotDirection.DOWN, Pair.create(0, 6));
// solve
solver.solve(robot, maze);
// set a translator (optional)
Map<String, String> translator = Map.ofEntries(
        entry(MazeConstants.ROBOT, "🤖"),
        entry(MazeConstants.PATH, "⛅️"),
        entry(MazeConstants.WALL, "🌲"),
        entry(MazeConstants.SPACE, "☁️")
);

// print result
MazeUtils.printMaze(maze, robot.getRow(), robot.getColumn(), translator);
```