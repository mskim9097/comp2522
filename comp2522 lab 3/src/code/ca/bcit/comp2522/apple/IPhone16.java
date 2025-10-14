package ca.bcit.comp2522.apple;

import java.util.Objects;

/**
 * The IPhone16 class is a special type of IPhone.
 *
 * <p>
 * In addition to minutes and carrier (inherited from IPhone),
 * this class also keeps track of:
 * <ul>
 * <li>whether it has a high-resolution camera</li>
 * <li>how much memory (in gigabytes) it has</li>
 * </ul>
 * </p>
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public final class IPhone16 extends IPhone
{
    private static final int MINIMUM_MEMORY_GB = 0;

    private final boolean highResolutionCamera;
    private final int memoryGB;

    /**
     * Builds a new IPhone16 with minutes, carrier, camera, and memory.
     *
     * @param minutesRemaining minutes left on the plan
     * @param carrier carrier name
     * @param highResolutionCamera true if high-res camera, false otherwise
     * @param memoryGB memory size in gigabytes
     */
    public IPhone16(final double minutesRemaining,
                    final String carrier,
                    final boolean highResolutionCamera,
                    final int     memoryGB)
    {
        super(minutesRemaining, carrier);

        validateMemoryGB(memoryGB);

        this.highResolutionCamera = highResolutionCamera;
        this.memoryGB = memoryGB;
    }

    /**
     * Returns whether this iPhone has a high-resolution camera.
     *
     * @return true if high-res camera, false otherwise
     */
    public final boolean isHighResolutionCamera()
    {
        return highResolutionCamera;
    }

    /**
     * Returns the memory size in gigabytes.
     *
     * @return memory in GB
     */
    public final int getMemoryGb()
    {
        return memoryGB;
    }

    /**
     * Returns all details about this IPhone16,
     * including purpose, minutes, carrier, camera, and memory.
     *
     * @return a formatted string of details
     */
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

    /**
     * Checks if two IPhone16s are equal
     *
     * <p>
     * They are equal if:
     * <ul>
     * <li>they are both IPhone16 objects</li>
     * <li>they have the same minutes remaining</li>
     * <li>they have the same camera setting</li>
     * </ul>
     * Memory size does not affect equality.
     * </p>
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

        final IPhone16 sixteen;
        sixteen = (IPhone16) o;

        return super.equals(o) &&
               this.highResolutionCamera ==
               sixteen.highResolutionCamera;
    }

    /**
     * Hash code based on minutes remaining and camera setting.
     *
     * @return hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(getMinutesRemaining(),
                highResolutionCamera);
    }

    /**
     * Makes sure memory is not negative.
     *
     * @param memoryGB memory size in GB
     * @throws IllegalArgumentException if memory is less than {@value MINIMUM_MEMORY_GB}
     */
    private static void validateMemoryGB(final int memoryGB)
    {
        if(memoryGB < MINIMUM_MEMORY_GB)
        {
            throw new IllegalArgumentException(
                    "Memory cannot be less than " + MINIMUM_MEMORY_GB);
        }
    }
}
