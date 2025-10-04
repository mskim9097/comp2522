package ca.bcit.comp2522.apple;

import java.util.Objects;

public class IPhone extends IDevice
{
    private final double minutesRemaining;
    private final String carrier;

    public IPhone(final double minutesRemaining,
                  final String carrier)
    {
        super("talking");

        validateMinutesRemaining(minutesRemaining);
        validateCarrier(carrier);

        this.minutesRemaining = minutesRemaining;
        this.carrier = carrier;
    }

    public final double getMinutesRemaining()
    {
        return minutesRemaining;
    }

    public final String getCarrier()
    {
        return carrier;
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
        sb.append("Number of minutes remaining on phone plan: ");
        sb.append(minutesRemaining);
        sb.append("\n");
        sb.append("Carrier: ");
        sb.append(carrier);
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

        final IPhone iphone;
        iphone = (IPhone) o;

        return Double.compare(this.minutesRemaining,
                iphone.minutesRemaining) == 0;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(minutesRemaining);
    }

    private static void validateMinutesRemaining(final double minutesRemaining)
    {
        if(minutesRemaining < 0.0)
        {
            throw new IllegalArgumentException("Invalid minutes remaining");
        }
    }

    private static void validateCarrier(final String carrier)
    {
        if(carrier == null || carrier.isBlank())
        {
            throw new IllegalArgumentException("Invalid carrier");
        }
    }
}
