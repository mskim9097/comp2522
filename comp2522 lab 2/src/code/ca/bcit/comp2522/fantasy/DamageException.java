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
    public DamageException(final String message)
    {
        super(message);
    }
}
