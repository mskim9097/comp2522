package ca.bcit.comp2522.apple;

import java.util.Objects;

public final class IPhone16 extends IPhone
{
    private final boolean highResolutionCamera;
    private final int memoryGB;

    public IPhone16(final double minutesRemaining,
                    final String carrier,
                    final boolean highResolutionCamera,
                    final int memoryGB)
    {
        super(minutesRemaining, carrier);

        validateMemoryGB(memoryGB);

        this.highResolutionCamera = highResolutionCamera;
        this.memoryGB = memoryGB;
    }

    public final boolean isHighResolutionCamera() {
        return highResolutionCamera;
    }

    public final int getMemoryGb() {
        return memoryGB;
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
        sb.append(memoryGB);
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

        return super.equals(o) &&
               this.highResolutionCamera ==
               sixteen.highResolutionCamera;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getMinutesRemaining(),
                highResolutionCamera);
    }

    private static void validateMemoryGB(final int memoryGB)
    {
        if(memoryGB < 0)
        {
            throw new IllegalArgumentException("Invalid memory in GB");
        }
    }
}
