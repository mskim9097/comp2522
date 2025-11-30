package ca.bcit.comp2522.project.mygame;

import javafx.scene.paint.Color;
import java.util.Random;

/**
 * Represents a healthy cell that can become infected.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public class HealthyCell
        extends Cell
        implements Infectable
{
    private static final int MAXIMUM_PERCENT = 100;

    private static final Random RANDOM;
    private static final int    PERCENT_RANGE;

    static
    {
        RANDOM        = new Random();
        PERCENT_RANGE = MAXIMUM_PERCENT;
    }

    private boolean willBeInfected;

    /**
     * Constructs a HealthyCell.
     *
     * @param row row index
     * @param col column index
     */
    public HealthyCell(final int row,
                       final int col)
    {
        super(row, col);
        this.willBeInfected = false;
    }

    /**
     * Returns the color of this cell.
     * @return color of the cell
     */
    @Override
    public Color getColor()
    {
        return Color.LIGHTGREEN;
    }

    /**
     * Updates the state of the cell based on the current state of the grid.
     * @param map 2D array of all cells in the grid
     */
    @Override
    public void update(final Cell[][] map)
    {
        // No action required for healthy cells.
    }

    /**
     * Tries to infect this cell.
     * @return true if infection was successful, false otherwise
     */
    @Override
    public boolean tryInfect()
    {
        final int value;

        value = RANDOM.nextInt(PERCENT_RANGE);

        if (value < MyGameConstants.INFECTION_CHANCE_PERCENT)
        {
            willBeInfected = true;
            return true;
        }

        return false;
    }

    /**
     * Returns whether this cell is scheduled to become infected
     * in the next simulation round.
     *
     * @return true if this cell will become infected next round
     */
    public boolean willBeInfected()
    {
        return willBeInfected;
    }
}