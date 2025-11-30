package ca.bcit.comp2522.project.mygame;

import javafx.scene.paint.Color;

/**
 * Represents an immune cell that cannot be infected.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public class ImmuneCell
        extends Cell
{
    /**
     * Constructs an ImmuneCell.
     *
     * @param row row index
     * @param col column index
     */
    public ImmuneCell(final int row,
                      final int col)
    {
        super(row, col);
    }

    /**
     * Returns the color of this cell.
     * @return color of the cell
     */
    @Override
    public Color getColor()
    {
        return Color.BLUE;
    }

    /**
     * Updates the state of the cell based on the current state of the grid.
     * @param map 2D array of all cells in the grid
     */
    @Override
    public void update(final Cell[][] map)
    {
        // Immune cells do nothing.
    }
}