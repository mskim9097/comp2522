package ca.bcit.comp2522.project.numbergame;

/**
 * Concrete implementation of the Number Game logic.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public class NumberGameLogic
        extends BaseGame
{
    /**
     * Checks if placing the number at the specified index is valid.
     * Enforces the rule: numbers must be in ascending order relative to their neighbors.
     * @param number the number to place
     * @param index the target slot index
     * @return true if the move follows the ascending order rule, false otherwise
     */
    @Override
    public boolean isValidPlacement(final int number,
                                    final int index)
    {
        if (getNumberAt(index) != EMPTY_SLOT)
        {
            return false;
        }

        for (int i = index - INDEX_OFFSET; i >= FIRST_INDEX; i--)
        {
            if (getNumberAt(i) != EMPTY_SLOT)
            {
                if (getNumberAt(i) >= number)
                {
                    return false;
                }
                break;
            }
        }

        for (int i = index + INDEX_OFFSET; i < TOTAL_SLOTS; i++)
        {
            if (getNumberAt(i) != EMPTY_SLOT)
            {
                if (getNumberAt(i) <= number)
                {
                    return false;
                }
                break;
            }
        }
        return true;
    }

    /**
     * Returns true if the number can be placed.
     * @param number the number to place
     * @return true if the number can be placed
     */
    @Override
    public boolean isMovePossible(final int number)
    {
        for (int i = FIRST_INDEX; i < TOTAL_SLOTS; i++)
        {
            if (isValidPlacement(number, i))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if the board is full.
     * @return true if the board is full
     */
    @Override
    public boolean isBoardFull()
    {
        for (int i = FIRST_INDEX; i < TOTAL_SLOTS; i++)
        {
            if (getNumberAt(i) == EMPTY_SLOT)
            {
                return false;
            }
        }
        return true;
    }
}