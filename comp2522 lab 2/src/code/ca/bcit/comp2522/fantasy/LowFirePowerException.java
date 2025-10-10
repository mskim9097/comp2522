package ca.bcit.comp2522.fantasy;

/**
 * LowFirePowerException is thrown when a dragon does not have
 * enough firepower to breathe fire.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class LowFirePowerException
        extends Exception
{
    /**
     * LowFirePowerException constructor.
     * @param message The message to display
     *                when the exception is thrown.
     */
    public LowFirePowerException(final String message)
    {
        super(message);
    }
}
