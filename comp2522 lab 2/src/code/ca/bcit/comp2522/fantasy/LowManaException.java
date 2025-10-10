package ca.bcit.comp2522.fantasy;

/**
 * LowManaException is thrown when an elf does not have
 * enough mana to cast a spell.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class LowManaException
        extends Exception
{
    /**
     * LowManaException constructor.
     * @param message The message to display
     *                when the exception is thrown.
     */
    public LowManaException(final String message)
    {
        super(message);
    }
}
