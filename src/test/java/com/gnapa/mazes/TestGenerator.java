package com.gnapa.mazes;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.gnapa.mazes.generator.MazeGenerator;
import com.gnapa.mazes.utils.MazeConstants;

public class TestGenerator {

    @Test
    public void generateWithoutWalls() {
        MazeGenerator generator = new MazeGenerator();
        String[][] generate = generator.generate(5, 3, true);
        String[][] expect = new String[][] {
            new String[] { MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE },
            new String[] { MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE },
            new String[] { MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE }
        };
        assertTrue(Arrays.deepEquals(expect, generate));
    }
    
    @Test
    public void generateWithWalls() {
        MazeGenerator generator = new MazeGenerator();
        String[][] generate = generator.generate(5, 3, false);
        String[][] expect = new String[][] {
            new String[] { MazeConstants.WALL, MazeConstants.WALL,  MazeConstants.WALL,  MazeConstants.WALL,  MazeConstants.WALL,  MazeConstants.WALL,  MazeConstants.WALL },
            new String[] { MazeConstants.WALL, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.WALL },
            new String[] { MazeConstants.WALL, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.WALL },
            new String[] { MazeConstants.WALL, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.SPACE, MazeConstants.WALL },
            new String[] { MazeConstants.WALL, MazeConstants.WALL,  MazeConstants.WALL,  MazeConstants.WALL,  MazeConstants.WALL,  MazeConstants.WALL,  MazeConstants.WALL }
        };
        assertTrue(Arrays.deepEquals(expect, generate));
    }
    
}
