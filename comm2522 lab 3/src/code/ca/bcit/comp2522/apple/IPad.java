package ca.bcit.comp2522.apple;

import java.util.Objects;

public class IPad extends IDevice
{
    private final boolean hasCase;
    private final String osVersion;

    public IPad(final boolean hasCase,
                final String osVersion)
    {
        super("learning");

        validateOsVersion(osVersion);

        this.hasCase = hasCase;
        this.osVersion = osVersion;
    }

    public final boolean isHasCase()
    {
        return hasCase;
    }

    public final String getOsVersion()
    {
        return osVersion;
    }

    @Override
    public void printDetails()
    {
        System.out.println(toString());
    }

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

    @Override
    public int hashCode()
    {
        return Objects.hashCode(osVersion);
    }

    private static void validateOsVersion(final String osVersion)
    {
        if(osVersion == null || osVersion.isBlank())
        {
            throw new IllegalArgumentException("Invalid operating system version");
        }
    }
}
