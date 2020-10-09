package com.gnapa.mazes.utils;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Guillermo Narvaez
 */
public class Pair {
    
    public int row;
    public int column;
    
    /**
     * <p>
     * 
     * </p>
     */
    private Pair(int x, int y) {
        this.row = x;
        this.column = y;
    }
    
    /**
     * <p>
     * 
     * </p>
     * 
     * @param row
     * @param column
     * @return
     */
    public static Pair create(int row, int column) {
        return new Pair(row, column);
    }
    
}
