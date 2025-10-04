package ca.bcit.comp2522.apple;

import java.util.Objects;

public class IPad extends IDevice
{
    private final boolean hasCase;
    private final String version;

    public IPad(final boolean hasCase,
                final String version)
    {
        super("learning");
        this.hasCase = hasCase;
        this.version = version;
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
        sb.append(version);

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

        return this.version.equalsIgnoreCase(ipad.version);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(version);
    }

}
