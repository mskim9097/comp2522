
/**
 * HealingException is thrown when an invalid healing value is given.
 * For example, if the healing amount is negative.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class HealingException
        extends RuntimeException
{
    public HealingException(final String message)
    {
        super(message);
    }
}
