package ca.bcit.comp2522.bookstore;

/**
 * A class representing a person's name.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class Name implements Printable
{
    private static final int MAXIMUM_NAME_LENGTH = 50;

    private final String first;
    private final String last;

    /**
     * Constructs a new name.
     * @param first The person's first name.
     * @param last The person's last name.
     */
    public Name(final String first,
                final String last)
    {
        validateFirstName(first);
        validateLastName(last);

        this.first = first;
        this.last  = last;
    }

    /**
     * Gets the person's first name.
     * @return The person's first name.
     */
    public final String getFirst()
    {
        return first;
    }

    /**
     * Gets the person's last name.
     * @return The person's last name.
     */
    public final String getLast()
    {
        return last;
    }

    /**
     * Displays the name in the format "First Last".
     */
    @Override
    public void display()
    {
        System.out.println(
                "The full name is " + toString() + ".");
    }

    // A method to validate the first name.
    private static void validateFirstName(final String first)
    {
        if (first == null ||
            first.isBlank() ||
            first.length() > MAXIMUM_NAME_LENGTH)
        {
            throw new IllegalArgumentException("Invalid first name");
        }
    }

    // A method to validate the last name.
    private static void validateLastName(final String last)
    {
        if (last == null ||
            last.isBlank() ||
            last.length() > MAXIMUM_NAME_LENGTH)
        {
            throw new IllegalArgumentException("Invalid last name");
        }
    }

    /**
     * Returns the name in the format "First Last".
     * @return The name in the format "First Last".
     */
    @Override
    public String toString() {
        return first + " " + last;
    }
}
