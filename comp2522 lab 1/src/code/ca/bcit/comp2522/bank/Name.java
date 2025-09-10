package ca.bcit.comp2522.bank;

/**
 * Models a name for a bank client.
 *
 * @author Minsu Kim
 * @version 1.0
 */
public class Name
{
    private static final int MAX_NAME_LENGTH = 45;
    private static final String FORBIDDEN_WORD = "admin";

    private final String first;
    private final String last;

    /**
     * Constructor.
     * @param first first name of the client.
     * @param last last name of the client.
     *
     * @throws IllegalArgumentException if the name is invalid.
     */
    public Name(final String first,
                final String last)
    {
        validateFirstName(first);
        validateLastName(last);

        this.first = first;
        this.last = last;
    }

    /**
     * Gets the first name.
     * @return first name.
     */
    public String getFirst()
    {
        return first;
    }

    /**
     * Gets the last name.
     * @return last name.
     */
    public String getLast()
    {
        return last;
    }

    /**
     * Gets the initials of the name.
     * @return initials of the name.
     */
    public String getInitials()
    {
        return first.trim().substring(0, 1).toUpperCase()
                + "." + last.trim().substring(0, 1).toUpperCase()
                + ".";
    }

    /**
     * Gets the full name of the client.
     * @return full name of the client.
     */
    public String getFullName()
    {
        return first.trim().substring(0, 1).toUpperCase()
                + first.trim().substring(1).toLowerCase()
                + " "
                + last.trim().substring(0, 1).toUpperCase()
                + last.trim().substring(1).toLowerCase();
    }

    /**
     * Gets the reverse name of the client.
     * @return reverse the name of the client.
     */
    public String getReverseName()
    {
        StringBuilder reverseName = new StringBuilder();
        for (int i = last.length() - 1; i >= 0; i--)
        {
            reverseName.append(last.charAt(i));
        }
        reverseName.append(" ");
        for (int i = first.length() - 1; i >= 0; i--)
        {
            reverseName.append(first.charAt(i));
        }
        return reverseName.toString();
    }

    private static void validateFirstName(final String first)
    {
        if (first == null
                || first.trim().isBlank()
                || first.length() >= MAX_NAME_LENGTH
                || first.trim().toLowerCase().contains(FORBIDDEN_WORD))
        {
            throw new IllegalArgumentException("Invalid first name");
        }
    }

    private static void validateLastName(final String last)
    {
        if (last == null
                || last.trim().isBlank()
                || last.length() >= MAX_NAME_LENGTH
                || last.trim().toLowerCase().contains(FORBIDDEN_WORD))
        {
            throw new IllegalArgumentException("Invalid last name");
        }
    }
}
