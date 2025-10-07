package ca.bcit.comp2522.bank;

/**
 * This class combines a Name with a first and last name.
 * Firstly, this class provides functionality to retrieve initials, full name, and reverse.
 * Secondly, validating the name if we have corrected the letter size of the name.
 * Also, it checks to make sure that
 * nobody accesses in the program as admin by typing FORBIDDEN_USERNAME
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 * @version 1.0
 */
public class Name
{
    private static final int    MAXIMUM_ALLOWED_NAME_LENGTH = 99;
    private static final String FORBIDDEN_USERNAME          = "admin";
    private static final int    FIRST_INDEX                 = 0;
    private static final int    SECOND_INDEX                  = 1;

    private final String first;
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
        final StringBuilder initialName;
        initialName = new StringBuilder();

        initialName.append(first.trim().substring(FIRST_INDEX, SECOND_INDEX).toUpperCase());
        initialName.append(".");
        initialName.append(last.trim().substring(FIRST_INDEX, SECOND_INDEX).toUpperCase());
        initialName.append(".");

        return initialName.toString();
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
        final StringBuilder fullName;
        fullName = new StringBuilder();

        fullName.append(first.trim().substring(FIRST_INDEX, SECOND_INDEX).toUpperCase());
        fullName.append(first.trim().substring(SECOND_INDEX).toLowerCase());
        fullName.append(" ");
        fullName.append(last.trim().substring(FIRST_INDEX, SECOND_INDEX).toUpperCase());
        fullName.append(last.trim().substring(SECOND_INDEX).toLowerCase());

        return fullName.toString();
    }

    /**
     * Prints the reverse of the full name.
     *
     * @return reverse full name
     */
    public String getReverseName()
    {
        final StringBuilder reverseName;
        reverseName = new StringBuilder();

        reverseName.append(getFirst());
        reverseName.append(" ");
        reverseName.append(getLast());
        reverseName.reverse();

        return reverseName.toString();
    }

    /* The validate methods for first name */
    private static void validateFirstName(final String first)
    {
        if (first == null ||
            first.trim().isBlank() ||
            first.length() >= MAXIMUM_ALLOWED_NAME_LENGTH ||
            first.trim().toLowerCase().contains(FORBIDDEN_USERNAME))
        {
            throw new IllegalArgumentException("Invalid first name");
        }
    }

    /* The validate methods for last name */
    private static void validateLastName(final String last)
    {
        if (last == null ||
            last.trim().isBlank() ||
            last.length() >= MAXIMUM_ALLOWED_NAME_LENGTH ||
            last.trim().toLowerCase().contains(FORBIDDEN_USERNAME))
        {
            throw new IllegalArgumentException("Invalid last name");
        }
    }
}
