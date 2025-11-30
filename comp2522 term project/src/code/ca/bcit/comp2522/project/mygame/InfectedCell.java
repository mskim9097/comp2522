package ca.bcit.comp2522.project.mygame;

import javafx.scene.paint.Color;

/**
 * Represents an infected cell that tries to infect its neighbors.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public class InfectedCell
        extends Cell
        implements MyGameConstants
{
    private static final int[] NEIGHBOR_D_ROW = {-1, 1, 0, 0};
    private static final int[] NEIGHBOR_D_COL = {0, 0, -1, 1};

    /**
     * Constructs an InfectedCell.
     *
     * @param row row index
     * @param col column index
     */
    public InfectedCell(final int row,
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
        return Color.RED;
    }

    /**
     * Updates the state of the cell based on the current state of the grid.
     * @param map 2D array of all cells in the grid
     */
    @Override
    public void update(final Cell[][] map)
    {
        final int row;
        final int col;

        row = getRow();
        col = getCol();

        for (int i = FIRST_INDEX; i < NEIGHBOR_D_ROW.length; i++)
        {
            final int neighborRow;
            final int neighborCol;

            neighborRow = row + NEIGHBOR_D_ROW[i];
            neighborCol = col + NEIGHBOR_D_COL[i];

            if (neighborRow >= FIRST_INDEX &&
                neighborRow < map.length &&
                neighborCol >= FIRST_INDEX &&
                neighborCol < map[FIRST_INDEX].length)
            {
                final Cell neighbor;

                neighbor = map[neighborRow][neighborCol];

                if (neighbor instanceof Infectable)
                {
                    final Infectable infectable;

                    infectable = (Infectable) neighbor;
                    infectable.tryInfect();
                }
            }
        }
    }
}
