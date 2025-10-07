package ca.bcit.comp2522.apple;

import java.util.Objects;

/**
 * The IDevice class is an abstract parent for all Apple devices.
 *
 * <p>
 * Every iDevice has a purpose (for example, “music,” “learning,” or “talking”).
 * This class stores that purpose and provides common methods like
 * {@code toString()}, {@code equals()}, and {@code hashCode()}.
 * </p>
 *
 * <p>
 * Subclasses (such as IPod, IPad, IPhone, and IPhone16) must implement
 * {@link #printDetails()} to display their own specific fields.
 * </p>
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
abstract class IDevice
{
    private final String purpose;

    /**
     * Constructs a new {@code IDevice} with the given purpose.
     *
     * @param purpose a non-empty description of what the device is for
     * @throws IllegalArgumentException if {@code purpose} is null or blank
     */
    public IDevice(final String purpose)
    {
        validatePurpose(purpose);
        this.purpose = purpose;
    }

    /**
     * Returns this device’s purpose.
     *
     * @return the purpose string
     */
    public final String getPurpose()
    {
        return purpose;
    }

    /**
     * Prints all details for the device.
     * <p>
     * Every child class (IPod, IPad, IPhone, IPhone16) must override this
     * method to display all of its own fields along with the inherited purpose.
     * </p>
     */
    public abstract void printDetails();

    /**
     * Returns a string showing the purpose of this device.
     * Subclasses will call this method and then add their own details.
     *
     * @return a sentence that describes the device’s purpose
     */
    @Override
    public String toString()
    {
        final StringBuilder sb;
        sb = new StringBuilder();

        sb.append("The purpose of this iDevice is ");
        sb.append(getPurpose());
        sb.append("\n");
        return sb.toString();
    }

    /**
     * Checks if this device is equal to another object.
     * <p>
     * Two devices are equal if they are the same class type
     * and their purposes match (ignoring case).
     * </p>
     *
     * @param o the object to compare
     * @return {@code true} if the two devices are the same, {@code false} otherwise
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

        final IDevice device;
        device = (IDevice) o;

        return this.purpose.equalsIgnoreCase(device.purpose);
    }

    /**
     * Returns a hash code based on the purpose.
     * <p>
     * Subclasses that override {@link #equals(Object)} must
     * also override {@code hashCode()}, but they can call this
     * method as part of their calculation.
     * </p>
     *
     * @return a hash code for this device
     */
    @Override
    public int hashCode()
    {
        return Objects.hashCode(purpose);
    }

    /**
     * Ensures that the given purpose is valid.
     *
     * @param purpose the text to check
     * @throws IllegalArgumentException if {@code purpose} is null or blank
     */
    private static void validatePurpose(final String purpose)
    {
        if(purpose == null || purpose.isBlank())
        {
            throw new IllegalArgumentException("Invalid purpose");
        }
    }
}
