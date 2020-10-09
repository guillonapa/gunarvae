package com.gnapa.mazes.generator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gnapa.mazes.utils.Pair;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Guillermo Narvaez
 */
public class MazeFromFileGenerator {
    
    /**
     * <p>
     * 
     * </p>
     * 
     * @param file
     * @return
     * @throws IOException
     */
    public static String[][] generateFromFile(File file) throws IOException {
        Stream<String> lines = Files.lines(file.toPath());
        List<Pair> walls = new LinkedList<>();
        int currLine = 0;
        int numColumns = 0;
        List<String> collectedLines = lines.collect(Collectors.toList());
        for (String line : collectedLines) {
            numColumns = Math.max(numColumns, line.length());
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '#') walls.add(Pair.create(currLine, i));
            }
            currLine++;
        }
        int numRows = currLine;
        lines.close();
        MazeGenerator generator = new MazeGenerator();
        String[][] maze = generator.generate(numRows, numColumns, true);
        return generator.apply(maze, walls);
    }
    
}
