import java.util.Objects;

/**
 * Represent a movie
 *
 * @author Minsu Kim
 * @version 1.0
 */
public class Movie
{
    private static final int MAXIMUM_TITLE_LENGTH = 33;

    private final String title;

    /**
     * Constructor of Movie
     * @param title Movie title
     */
    public Movie(final String title)
    {
        validateTitle(title);
        this.title = title;
    }

    /**
     * A method that returns movie title
     * @return title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * A method that validates title
     * @param title movie title
     */
    private static void validateTitle(final String title)
    {
        if(title == null ||
           title.isEmpty() ||
           title.length() > MAXIMUM_TITLE_LENGTH)
        {
            throw new IllegalArgumentException("oops");
        }
    }

    @Override
    public boolean equals(final Object o)
    {
        if(o == null || !o.getClass().equals(this.getClass()))
        {
            return false;
        }
        final Movie that;
        that = (Movie) o;
        return this.title.equals(that.title);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(title);
    }
}

/**
 * Main class to drive Movie
 *
 * @author Minsu Kim
 * @version 1.0
 */
public class Main
{
    /**
     * drives the program
     * @param args no-argument
     */
    public static void main(final String[] args)
    {
        final Movie m1;
        m1 = new Movie("Test");
        System.out.println(m1.getTitle().toUpperCase());
    }
}
/// ////////////////////////////////////////////////////////
public class HorrorMovie extends Movie
{
    private final String scaryCharacter;

    public HorrorMovie(final String title,
                       final String scaryCharacter)
            throws InvalidScarer
    {
        super(title);
        validateScaryCharacter(scaryCharacter);
        this.scaryCharacter = scaryCharacter;
    }

    @Override
    public boolean equals(final Object o)
    {
        if(o == null || !o.getClass().equals(this.getClass()))
        {
            return false;
        }
        final HorrorMovie that;
        that = (HorrorMovie) o;
        return that.scaryCharacter.equals(this.scaryCharacter);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(scaryCharacter);
    }

    private static void validateScaryCharacter(final String scaryCharacter)
            throws InvalidScarer
    {
        if(scaryCharacter == null)
        {
            throw new InvalidScarer("no");
        }
    }
}

public class Test
{
    public static void main(final String[] args)
    {
        final Movie m1;
        final Movie m2;

        m1 = new Movie("Groundhog DAy");

        try
        {
            m2 = new HorrorMovie("Hallowen", "churkey");
            System.out.println(m1.getTitle());
            System.out.println(m2.getTitle());
        }
        catch(final InvalidScarer e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            System.out.println("goodbye");
        }
    }
}

public class InvalidScarer extends Exception
{
    public InvalidScarer(final String message)
    {
        super(message);
    }
}



