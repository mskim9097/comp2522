package ca.bcit.comp2522.apple;

import java.util.Objects;

/**
 * The IPad class is an iDevice made for “learning.”
 *
 * <p>
 * Each iPad keeps track of:
 * <ul>
 * <li>whether it has a case</li>
 * <li>which operating system version it uses</li>
 * </ul>
 * </p>
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class IPad extends IDevice
{
    private final boolean hasCase;
    private final String osVersion;

    /**
     * Builds a new IPad with its case info and OS version.
     *
     * @param hasCase true if the iPad has a case
     * @param osVersion the OS version (cannot be blank)
     * @throws IllegalArgumentException if OS version is blank
     */
    public IPad(final boolean hasCase,
                final String osVersion)
    {
        super("learning");

        validateOsVersion(osVersion);

        this.hasCase = hasCase;
        this.osVersion = osVersion;
    }

    /**
     * Returns whether this iPad has a case.
     *
     * @return true if it has a case, false otherwise
     */
    public final boolean isHasCase()
    {
        return hasCase;
    }

    /**
     * Returns the operating system version of this iPad.
     *
     * @return the OS version string
     */
    public final String getOsVersion()
    {
        return osVersion;
    }

    /**
     * Prints all details of this iPad.
     */
    @Override
    public void printDetails()
    {
        System.out.println(toString());
    }

    /**
     * Returns all details about this iPad,
     * including its purpose, case info, and OS version.
     *
     * @return formatted string of details
     */
    @Override
    public String toString()
    {
        final StringBuilder sb;
        sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Has a case: ");
        sb.append(hasCase);
        sb.append("\n");
        sb.append("Operating system version: ");
        sb.append(osVersion);

        return sb.toString();
    }

    /**
     * Two iPads are equal if they have the same OS version.
     * The case value is ignored for equality.
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

        final IPad ipad;
        ipad = (IPad) o;

        return this.osVersion.equalsIgnoreCase(ipad.osVersion);
    }

    /**
     * Hash code based on OS version.
     *
     * @return hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hashCode(osVersion);
    }

    /**
     * Makes sure the OS version string is valid.
     *
     * @param osVersion version text to check
     * @throws IllegalArgumentException if null or blank
     */
    private static void validateOsVersion(final String osVersion)
    {
        if(osVersion == null || osVersion.isBlank())
        {
            throw new IllegalArgumentException("Invalid operating system version");
        }
    }
}
