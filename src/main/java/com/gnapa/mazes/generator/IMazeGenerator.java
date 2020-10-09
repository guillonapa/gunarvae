package com.gnapa.mazes.generator;

import java.util.List;

import com.gnapa.mazes.utils.Pair;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Guillermo Narvaez
 */
public interface IMazeGenerator {
    
    /**
     * <p>
     * 
     * </p>
     * 
     * @param x
     * @param y
     * @param hasBorders
     * @return
     */
    public String[][] generate(int x, int y, boolean hasBorders);
    
    /**
     * <p>
     * 
     * </p>
     * 
     * @param maze
     * @param walls
     * @return
     */
    public String[][] apply(String[][] maze, List<Pair> walls);
    
    /**
     * <p>
     * 
     * </p>
     * 
     * @param maze
     * @param x
     * @param y
     * @return
     */
    public String[][] entrance(String[][] maze, int x, int y);
    
    /**
     * <p>
     * 
     * </p>
     * 
     * @param maze
     * @param x
     * @param y
     * @return
     */
    public String[][] exit(String[][] maze, int x, int y);

}
