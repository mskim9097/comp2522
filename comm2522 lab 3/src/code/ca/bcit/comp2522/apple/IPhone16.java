package ca.bcit.comp2522.apple;

import java.util.Objects;

public final class IPhone16 extends IPhone
{
    private final boolean highResolutionCamera;
    private final int memoryGb;

    public IPhone16(final double minutesRemaining,
                    final String carrier,
                    final boolean highResolutionCamera,
                    final int memoryGb)
    {
        super(minutesRemaining, carrier);
        this.highResolutionCamera = highResolutionCamera;
        this.memoryGb = memoryGb;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb;
        sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("High resolution camera: ");
        sb.append(highResolutionCamera);
        sb.append("\n");
        sb.append("Memory: ");
        sb.append(memoryGb);
        sb.append(" GB");

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

        final IPhone16 sixteen;
        sixteen = (IPhone16) o;

        return Double.compare(
                this.getMinutesRemaining(),
                sixteen.getMinutesRemaining()) == 0 &&
                this.highResolutionCamera ==
                sixteen.highResolutionCamera;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getMinutesRemaining(),
                highResolutionCamera);
    }
}
