package ca.bcit.comp2522.apple;

import java.util.Objects;

/**
 * The IPod class is an iDevice made for “music.”
 *
 * <p>
 * Each iPod keeps track of:
 * <ul>
 * <li>how many songs it can store</li>
 * <li>its maximum volume in decibels (dB)</li>
 * </ul>
 * </p>
 *
 * <p>
 * For Lab 3: two iPods are equal if they store the same number of songs.
 * The volume level does not matter for equality.
 * </p>
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class IPod extends IDevice
{
    private final int numberOfSongs;
    private final double maximumVolumeDB;

    /**
     * Builds a new IPod with songs and volume settings.
     *
     * @param numberOfSongs how many songs are stored (must be ≥ 0)
     * @param maximumVolumeDB the loudest volume in decibels (must be ≥ 0)
     * @throws IllegalArgumentException if songs or volume are invalid
     */
    public IPod(final int numberOfSongs,
                final double maximumVolumeDB)
    {
        super("music");

        validateNumberOfSongs(numberOfSongs);
        validateMaximumVolumeDB(maximumVolumeDB);

        this.numberOfSongs = numberOfSongs;
        this.maximumVolumeDB = maximumVolumeDB;
    }

    /**
     * Prints all details of this iPod.
     */
    @Override
    public void printDetails()
    {
        System.out.println(toString());
    }

    /**
     * Returns the number of songs this iPod stores.
     *
     * @return number of songs
     */
    public final int getNumberOfSongs()
    {
        return numberOfSongs;
    }

    /**
     * Returns the maximum volume of this iPod in decibels.
     *
     * @return max volume in dB
     */
    public final double getMaximumVolumeDB()
    {
        return maximumVolumeDB;
    }

    /**
     * Returns all details about this iPod, including purpose,
     * number of songs, and max volume.
     *
     * @return a formatted string of details
     */
    @Override
    public String toString()
    {
        final StringBuilder sb;
        sb = new StringBuilder();
        
        sb.append(super.toString());
        sb.append("Number of songs stored: ");
        sb.append(numberOfSongs);
        sb.append("\n");
        sb.append("Maximum volume in decibels: ");
        sb.append(maximumVolumeDB);

        return sb.toString();
    }

    /**
     * Two iPods are equal if they have the same number of songs.
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

        final IPod ipod;
        ipod = (IPod) o;

        return this.numberOfSongs == ipod.numberOfSongs;
    }

    /**
     * Hash code based on the number of songs.
     *
     * @return hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hashCode(numberOfSongs);
    }

    /**
     * Makes sure the number of songs is not negative.
     *
     * @param numberOfSongs number to check
     * @throws IllegalArgumentException if negative
     */
    private static void validateNumberOfSongs(final int numberOfSongs)
    {
        if(numberOfSongs < 0)
        {
            throw new IllegalArgumentException("Invalid number of songs");
        }
    }

    /**
     * Makes sure the maximum volume is not negative.
     *
     * @param maximumVolumeDB volume in dB
     * @throws IllegalArgumentException if negative
     */
    private static void validateMaximumVolumeDB(final double maximumVolumeDB)
    {
        if(maximumVolumeDB < 0)
        {
            throw new IllegalArgumentException("Invalid maximum volume in decibels");
        }
    }
}
