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
 * Class to generate mazes or rooms from file representations of them.
 * Every character '#' in the file is considered a wall, a '?' character
 * is considered an entrance, and a '!' character is considered an exit,
 * while every other character is considered a space. The number of columns 
 * will be equal to the maximum line length seen while parsing the file, while
 * the number of rows will be equal to the number of rows in the file.
 * Any missing characters will be interpreted as space. An example:
 * </p>
 * 
 * <pre>
 * ######?#########
 * ##            ##
 * ###### ###### ##
 * ###### #########
 * ###         ####
 * ########### ####
 * ###########   ##
 * #####       # ##
 * # ### ####### ##
 * # ### ####### ##
 * # ###    #### ##
 * # ### ####    ##
 * #     #### #####
 * ##### #### #####
 * #####       ####
 * ##### ##### ####
 * ##    ##### ####
 * ## ##   ### ####
 * ## ### ####    #
 * ##     ####### #
 * ##############!#
 * </pre>
 * 
 * @author Guillermo Narvaez
 */
public class MazeFromFileGenerator {
    
    /**
     * <p>
     * Generates a two dimensional array for the maze/room represented in the
     * given file.
     * </p>
     * 
     * @param file
     *          maze/room representation
     * @return the generated two dimensional array 
     * @throws IOException
     */
    public static String[][] generate(File file) throws IOException {
        // read all lines from the file
        Stream<String> linesStream = Files.lines(file.toPath());
        List<String> lines = linesStream.collect(Collectors.toList());
        linesStream.close();
        
        // the walls in the maze
        List<Pair> walls = new LinkedList<>();
        
        // the entrances in the maze
        List<Pair> entrances = new LinkedList<>();
        
        // the entrances in the maze
        List<Pair> exits = new LinkedList<>();
        
        // read each character from each line
        int row = 0;
        int maxColumns = 0;
        for (String line : lines) {
            // update the maximum number of columns seen so far
            maxColumns = Math.max(maxColumns, line.length());
            // traverse the line
            for (int column = 0; column < line.length(); column++) {
                if (line.charAt(column) == '#') walls.add(Pair.create(row, column));
                if (line.charAt(column) == '?') entrances.add(Pair.create(row, column));
                if (line.charAt(column) == '!') exits.add(Pair.create(row, column));
            }
            row++;
        }
        
        // the total number of rows seen
        int maxRows = row;
        
        // generate the maze
        MazeGenerator generator = new MazeGenerator();
        String[][] maze = generator.generate(maxRows, maxColumns, false);
        
        // apply all entrances
        for (Pair coors : entrances) {
            maze = generator.entrance(maze, coors.getRow(), coors.getColumn());
        }
        
        // apply all exits
        for (Pair coors : exits) {
            maze = generator.exit(maze, coors.getRow(), coors.getColumn());
        }
        
        // apply the walls to the new maze
        return generator.applyWalls(maze, walls);
    }
    
}
