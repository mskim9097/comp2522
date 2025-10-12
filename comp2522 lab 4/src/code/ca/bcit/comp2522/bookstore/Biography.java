package ca.bcit.comp2522.bookstore;

import java.util.Objects;

public class Biography extends Book
                       implements Printable
{
    private final Person subject;

    public Biography(final String title,
                     final int yearPublished,
                     final Author author,
                     final Person subject)
    {
        super(title, yearPublished, author);

        validateSubject(subject);
        this.subject = subject;
    }

    public final Person getSubject()
    {
        return subject;
    }

    @Override
    public void display()
    {
        System.out.println(toString());
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

        final Biography that;
        that = (Biography) o;

        return Objects.equals(this.subject, that.subject);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(subject);
    }

    private static void validateSubject(final Person subject)
    {
        if(subject == null)
        {
            throw new IllegalArgumentException(
                    "Subject cannot be null");
        }
    }

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
