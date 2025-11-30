package ca.bcit.comp2522.project.numbergame;

import java.util.Arrays;

/**
 * Abstract base class for the Number Game.
 * Holds the data structure but delegates ALL logic to the concrete class.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public abstract class BaseGame
        implements GameConstants
{
    private final int[] gridNumbers;

    /**
     * Constructs the BaseGame and initializes the board with empty slots.
     */
    public BaseGame()
    {
        this.gridNumbers = new int[TOTAL_SLOTS];
        resetBoard();
    }

    /**
     * Resets the board to all empty slots.
     */
    public void resetBoard()
    {
        Arrays.fill(gridNumbers, EMPTY_SLOT);
    }

    /**
     * Gets the number at the specified index.
     * @param index index of the number
     * @return the number at the specified index
     */
    public int getNumberAt(final int index)
    {
        return gridNumbers[index];
    }

    /**
     * Sets the number at the specified index.
     * @param index index number
     * @param number number to set
     */
    public void setNumberAt(final int index,
                            final int number)
    {
        gridNumbers[index] = number;
    }

    /**
     * Checks if the specified number already exists on the board.
     * Used to prevent duplicate numbers from being generated.
     * @param number the number to check
     * @return true if the number is already on the board, false otherwise
     */
    public boolean isNumberPresent(final int number)
    {
        for (final int n : gridNumbers)
        {
            if (n == number)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the placement is valid.
     */
    public abstract boolean isValidPlacement(final int number, final int index);

    /**
     * Checks if there is at least one valid move available for the given number.
     * @param number the number to check
     * @return true if the number can be placed in any empty slot
     */
    public abstract boolean isMovePossible(final int number);

    /**
     * Checks if the board is full.
     */
    public abstract boolean isBoardFull();
}