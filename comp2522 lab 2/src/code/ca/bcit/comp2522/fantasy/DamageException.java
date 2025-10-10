package ca.bcit.comp2522.fantasy;

/**
 * DamageException is thrown when an invalid damage value is given.
 * For example, if the damage is negative.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class DamageException
        extends RuntimeException
{
    /**
     * DamageException constructor.
     * @param message The message to display
     *                when the exception is thrown.
     */
    public DamageException(final String message)
    {
        super(message);
    }
}
