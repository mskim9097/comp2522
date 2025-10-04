package ca.bcit.comp2522.apple;

import java.util.Objects;

abstract class IDevice
{
    private final String purpose;

    public IDevice(final String purpose)
    {
        validatePurpose(purpose);
        this.purpose = purpose;
    }

    public final String getPurpose()
    {
        return purpose;
    }

    public abstract void printDetails();

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

    @Override
    public int hashCode()
    {
        return Objects.hashCode(purpose);
    }

    private static void validatePurpose(final String purpose)
    {
        if(purpose == null || purpose.isBlank())
        {
            throw new IllegalArgumentException("Invalid purpose");
        }
    }
}
