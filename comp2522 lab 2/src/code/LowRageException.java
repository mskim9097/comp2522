
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
    public LowRageException(final String message)
    {
        super(message);
    }
}
