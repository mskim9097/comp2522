package ca.bcit.comp2522.bookstore;

public class Name implements Printable
{
    private static final int MAXIMUM_CHARACTERS = 50;

    private final String first;
    private final String last;

    public Name(final String first,
                final String last)
    {
        validateFirstName(first);
        validateLastName(last);

        this.first = first;
        this.last = last;
    }

    public final String getFirst()
    {
        return first;
    }

    public final String getLast()
    {
        return last;
    }

    @Override
    public void display()
    {
        System.out.println(
                "The full name is " + toString() + ".");
    }

    private static void validateFirstName(final String first)
    {
        if (first == null ||
            first.isBlank() ||
            first.length() > MAXIMUM_CHARACTERS)
        {
            throw new IllegalArgumentException("Invalid first name");
        }
    }

    private static void validateLastName(final String last)
    {
        if (last == null ||
            last.isBlank() ||
            last.length() > MAXIMUM_CHARACTERS)
        {
            throw new IllegalArgumentException("Invalid last name");
        }
    }

    @Override
    public String toString() {
        return first + " " + last;
    }
}
