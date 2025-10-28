package ca.bcit.comp2522.bookstore;

/**
 * A subclass of {@link Biography} that represents an Autobiography.
 * An Autobiography is a biography written by the subject themselves,
 * so the author and the subject are the same person.
 * This class implements {@link Printable} to allow formatted display.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class Autobiography extends Biography
                           implements Printable
{
    /**
     * Constructs an Autobiography with the given title, publication year, and author.
     * The author is also the subject of the autobiography.
     *
     * @param title title of autobiography.
     * @param yearPublished published year of autobiography.
     * @param author author of autobiography
     */
    public Autobiography(final String title,
                         final int    yearPublished,
                         final Author author)
    {
        super(title,
              yearPublished,
              author,
              author);
    }

    /**
     * A method that displays autobiography's details.
     */
    @Override
    public void display()
    {
        System.out.println(toString());
    }

    /**
     * A method that returns autobiography's details.
     *
     * @return autobiography's details.
     */
    @Override
    public String toString()
    {
        return super.toString();
    }
}
