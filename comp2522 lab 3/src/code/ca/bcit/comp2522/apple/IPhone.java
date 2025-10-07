package ca.bcit.comp2522.apple;

import java.util.Objects;

/**
 * The IPhone class is a type of iDevice whose purpose is “talking.”
 *
 * <p>
 * Each iPhone keeps track of:
 * <ul>
 * <li>how many minutes are left on the phone plan</li>
 * <li>which carrier the phone uses</li>
 * </ul>
 *
 * <p>
 * According to the Lab 3 rules, two iPhones are considered equal if they
 * have the same number of minutes remaining (carrier doesn’t matter).
 * </p>
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class IPhone extends IDevice
{
    private final double minutesRemaining;
    private final String carrier;

    /**
     * Creates a new IPhone object.
     *
     * @param minutesRemaining minutes left on the plan (must be non-negative)
     * @param carrier the name of the carrier (cannot be blank)
     * @throws IllegalArgumentException if values are invalid
     */
    public IPhone(final double minutesRemaining,
                  final String carrier)
    {
        super("talking");

        validateMinutesRemaining(minutesRemaining);
        validateCarrier(carrier);

        this.minutesRemaining = minutesRemaining;
        this.carrier = carrier;
    }

    /**
     * Gets how many minutes are left on this phone’s plan.
     *
     * @return remaining minutes
     */
    public final double getMinutesRemaining()
    {
        return minutesRemaining;
    }

    /**
     * Gets the carrier of this iPhone.
     *
     * @return the carrier name
     */
    public final String getCarrier()
    {
        return carrier;
    }

    /**
     * Prints all of the iPhone’s details (purpose, minutes, and carrier).
     */
    @Override
    public void printDetails()
    {
        System.out.println(toString());
    }

    /**
     * Turns this iPhone into a string that shows its purpose,
     * minutes remaining, and carrier.
     *
     * @return formatted string with all details
     */
    @Override
    public String toString()
    {
        final StringBuilder sb;
        sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Number of minutes remaining on phone plan: ");
        sb.append(minutesRemaining);
        sb.append("\n");
        sb.append("Carrier: ");
        sb.append(carrier);
        sb.append("\n");

        return sb.toString();
    }

    /**
     * Two iPhones are equal if they are the same type
     * and have the same number of minutes remaining.
     *
     * @param o another object
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(final Object o)
    {
        if(o == null)
        {
            return false;
        }

        if(o == this)
        {
            return true;
        }

        if(!o.getClass().equals(this.getClass()))
        {
            return false;
        }

        final IPhone iphone;
        iphone = (IPhone) o;

        return Double.compare(this.minutesRemaining,
                iphone.minutesRemaining) == 0;
    }

    /**
     * Hash code based on minutes remaining.
     *
     * @return hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hashCode(minutesRemaining);
    }

    /**
     * Checks that the number of minutes is valid.
     * <p>
     * The minutes must be zero or more.
     * If a negative value is passed in, this method
     * throws an exception to stop the object from being created.
     * </p>
     *
     * @param minutesRemaining the number of minutes to check
     * @throws IllegalArgumentException if minutesRemaining is negative
     */
    private static void validateMinutesRemaining(final double minutesRemaining)
    {
        if(minutesRemaining < 0.0)
        {
            throw new IllegalArgumentException("Invalid minutes remaining");
        }
    }

    /**
     * Checks that the carrier name is valid.
     * <p>
     * The carrier cannot be null or just an empty string.
     * If it is, an exception is thrown to prevent bad data.
     * </p>
     *
     * @param carrier the carrier name to check
     * @throws IllegalArgumentException if carrier is null or blank
     */
    private static void validateCarrier(final String carrier)
    {
        if(carrier == null || carrier.isBlank())
        {
            throw new IllegalArgumentException("Invalid carrier");
        }
    }
}
