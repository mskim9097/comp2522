import java.util.Objects;

/**
 * Models a movie.
 *
 * @author jason wilder
 * @version 1.0
 */
class Movie
{
    private static final int LEN_MAX_TITLE = 33;
    private final String title;

    /**
     * Constructor.
     * @param title title of the movie
     */
    Movie(final String title)
    {
        validateTitle(title);
        this.title = title;
    }

    /*
     * Validates the title.
     * @param title the title
     */
    private static void validateTitle(final String title)
    {
        if(title == null || title.isEmpty() || title.length() > LEN_MAX_TITLE)
        {
            throw new IllegalArgumentException("oops");
        }
    }

    /**
     * Returns the title.
     * @return title of the movie
     */
    String getTitle()
    {
        return title;
    }

    @Override
    public boolean equals(final Object o)
    {
        if(!(o instanceof final Movie movie))
        {
            return false;
        }
        return Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(title);
    }
}




/**
 *
 */
class Main
{
    public static void main(final String[] args)
    {
         final Movie m;
         m = new Movie("ghostbusters");
        System.out.println(m.getTitle().toUpperCase());
    }
}
