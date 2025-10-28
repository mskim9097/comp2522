package ca.bcit.comp2522.bookstore;

import java.util.Objects;

/**
 * A subclass of {@link Book} that represents a biography.
 * A Biography is a book written about a person's life, authored by someone else.
 * This class implements {@link Printable} to allow formatted display.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class Biography extends Book
                       implements Printable
{
    private final Person subject;

    /**
     * Constructs a Biography with the given title,
     * publication year, author, and subject.
     *
     * @param title title of a biography.
     * @param yearPublished published year of a biography.
     * @param author author of a biography.
     * @param subject subject of a biography.
     */
    public Biography(final String title,
                     final int yearPublished,
                     final Author author,
                     final Person subject)
    {
        super(title, yearPublished, author);

        validateSubject(subject);
        this.subject = subject;
    }

    /**
     * A method that gets subject.
     *
     * @return subject
     */
    public final Person getSubject()
    {
        return subject;
    }

    /**
     * A method that displays biography's details.
     */
    @Override
    public void display()
    {
        System.out.println(toString());
    }

    /**
     * A method that checks if an object equals to another object.
     * Two biographies are considered equal if their subjects are equal
     *
     * @param o   the reference object with which to compare.
     * @return true if this object equals to that object.
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

        final Biography that;
        that = (Biography) o;

        return Objects.equals(this.subject, that.subject);
    }

    /**
     * A method that gets hashCode of a subject.
     *
     * @return subject's hashcode
     */
    @Override
    public int hashCode()
    {
        return Objects.hashCode(subject);
    }

    // A method that validates a subject.
    private static void validateSubject(final Person subject)
    {
        if(subject == null)
        {
            throw new IllegalArgumentException(
                    "Subject cannot be null");
        }
    }

    /**
     * A method that returns biography's details.
     *
     * @return formatted biography's details.
     */
    @Override
    public String toString()
    {
        final StringBuilder sb;
        sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Subject ");
        sb.append(subject.toString());
        sb.append("\n");

        return sb.toString();
    }
}
