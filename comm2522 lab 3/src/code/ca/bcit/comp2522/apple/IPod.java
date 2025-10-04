package ca.bcit.comp2522.apple;

import java.util.Objects;

public class IPod extends IDevice
{
    private final int numberOfSongs;
    private final double maximumVolumeDB;

    public IPod(final int numberOfSongs,
                final double maximumVolumeDB)
    {
        super("music");

        validateNumberOfSongs(numberOfSongs);
        validateMaximumVolumeDB(maximumVolumeDB);

        this.numberOfSongs = numberOfSongs;
        this.maximumVolumeDB = maximumVolumeDB;
    }

    @Override
    public void printDetails()
    {
        System.out.println(toString());
    }

    public final int getNumberOfSongs()
    {
        return numberOfSongs;
    }

    public final double getMaximumVolumeDB()
    {
        return maximumVolumeDB;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb;
        sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("The purpose of this iDevice is ");
        sb.append("Number of songs stored: ");
        sb.append(numberOfSongs);
        sb.append("\n");
        sb.append("Maximum volume in decibels: ");
        sb.append(maximumVolumeDB);

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

        final IPod ipod;
        ipod = (IPod) o;

        return this.numberOfSongs == ipod.numberOfSongs;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(numberOfSongs);
    }

    private static void validateNumberOfSongs(final int numberOfSongs)
    {
        if(numberOfSongs < 0)
        {
            throw new IllegalArgumentException("Invalid number of songs");
        }
    }

    private static void validateMaximumVolumeDB(final double maximumVolumeDB)
    {
        if(maximumVolumeDB < 0)
        {
            throw new IllegalArgumentException("Invalid maximum volume in decibels");
        }
    }
}
