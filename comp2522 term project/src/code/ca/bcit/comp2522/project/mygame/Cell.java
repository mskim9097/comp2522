package ca.bcit.comp2522.project.mygame;

import javafx.scene.paint.Color;

/**
 * Abstract base class for all cells on the grid.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public abstract class Cell
{
    private final int row;
    private final int col;

    /**
     * Constructs a Cell with its grid position.
     *
     * @param row row index on the grid
     * @param col column index on the grid
     */
    public Cell(final int row,
                final int col)
    {
        this.row = row;
        this.col = col;
    }

    /**
     * Returns the row index of this cell.
     *
     * @return row index
     */
    public int getRow()
    {
        return row;
    }

    /**
     * Returns the column index of this cell.
     *
     * @return column index
     */
    public int getCol()
    {
        return col;
    }

    /**
     * Returns the display color for this cell.
     *
     * @return color of the cell
     */
    public abstract Color getColor();

    /**
     * Updates the state of this cell based on neighbors.
     *
     * @param map 2D array of all cells in the grid
     */
    public abstract void update(Cell[][] map);
}