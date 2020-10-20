package com.gnapa.mazes.utils;

/**
 * <p>
 * Utility class to wrap a pair of coordinates, i.e. a row and column.
 * </p>
 * 
 * @author Guillermo Narvaez
 */
public class Pair {
    
    private int row;
    private int column;
    
    /**
     * <p>
     * Creates a new pair.
     * </p>
     */
    private Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    /**
     * <p>
     * Creates a new pair.
     * </p>
     * 
     * @param row
     *          0-based index for the row
     * @param column
     *          0-based index for the column
     * @return the new pair of coordinates
     */
    public static Pair create(int row, int column) {
        return new Pair(row, column);
    }

    /**
     * <p>
     * Returns the 0-based index for the row.
     * </p>
     * 
     * @return the row index
     */
    public int getRow() {
        return row;
    }

    /**
     * <p>
     * Returns the 0-based index for the column.
     * </p>
     * 
     * @return the column index
     */
    public int getColumn() {
        return column;
    }
    
}
