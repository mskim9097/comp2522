package ca.bcit.comp2522.fantasy;

/**
 * LowRageException is thrown when an orc does not have
 * enough rage to go berserk.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class LowRageException
        extends RuntimeException
{
    /**
     * LowRageException constructor.
     * @param message The message to display
     *                when the exception is thrown.
     */
    public LowRageException(final String message)
    {
        super(message);
    }
}
