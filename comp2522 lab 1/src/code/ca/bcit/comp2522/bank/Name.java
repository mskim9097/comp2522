package ca.bcit.comp2522.bank;

/**
 * This class combines a Name with a first and last name.
 * Firstly, this class provides functionality to retrieve initials, full name, and reverse.
 * Secondly, validating the name if we have corrected the letter size of the name.
 * Also, it checks to make sure that
 * nobody accesses in the program as admin by typing FORBIDDEN_WORD
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 * @version 1.0
 */
public class Name
{
    /* The maximum length of a name */
    private static final int MAX_NAME_LENGTH = 45;

    /* The word that is forbidden to be used */
    private static final String FORBIDDEN_WORD = "admin";

    /* The first name of the client */
    private final String first;
    /* The last name of the client */
    private final String last;

    /**
     * Creates a new Name with a first name and a last name.
     * Firstly, it validates the given first name.
     * Secondly, it validates the given last name.
     * Finally, it assigns the values to the fields.
     *
     * @param first the client's first name
     * @param last  the client's last name
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
     * Getter that returns the first name.
     *
     * @return first name.
     */
    public String getFirst()
    {
        return first;
    }

    /**
     * Getter that returns the last name.
     *
     * @return the last name.
     */
    public String getLast()
    {
        return last;
    }

    /**
     * Creating a method that returns the initials of the first and last name in uppercase.
     *
     * @return the initials in the format "F.L."
     */
    public String getInitials()
    {
        return first.trim().substring(0, 1).toUpperCase() +
                "." +
                last.trim().substring(0, 1).toUpperCase() +
                 ".";
    }

    /**
     * Creating a method that returns the full name in uppercase
     * for the first letter of first name and last name,
     * and rest letters in lowercase.
     *
     * @return the full name
     */
    public String getFullName()
    {
        return first.trim().substring(0, 1).toUpperCase() +
                first.trim().substring(1).toLowerCase() +
                " " +
                last.trim().substring(0, 1).toUpperCase() +
                last.trim().substring(1).toLowerCase();
    }

    /**
     * Prints the reverse of the full name.
     *
     * @return reverse full name
     */
    public String getReverseName()
    {
        String combined = getFirst() +
                " " +
                getLast();
        return new StringBuilder(combined).reverse().toString();
    }

    /* The validate methods for first name */
    private static void validateFirstName(final String first)
    {
        if (first == null ||
                first.trim().isBlank() ||
                first.length() >= MAX_NAME_LENGTH ||
                first.trim().toLowerCase().contains(FORBIDDEN_WORD))
        {
            throw new IllegalArgumentException("Invalid first name");
        }
    }

    /* The validate methods for last name */
    private static void validateLastName(final String last)
    {
        if (last == null ||
                last.trim().isBlank() ||
                last.length() >= MAX_NAME_LENGTH ||
                last.trim().toLowerCase().contains(FORBIDDEN_WORD))
        {
            throw new IllegalArgumentException("Invalid last name");
        }
    }
}
