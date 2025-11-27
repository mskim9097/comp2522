import java.util.Objects;

/**
 * Models a movie
 *
 * @author Minsu Kim
 * @version 1.0
 */
public class Movie
{
    private static final int LEN_MAX_TITLE = 33;

    private final String title;

    /**
     * Constructor.
     * @param title the title of the movie
     */
    Movie(final String title)
    {
        validateTitle(title);

        this.title = title;
    }

    /**
     * Gets the title of the movie.
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    private static void validateTitle(final String title)
    {
        if (title == null ||
            title.isBlank() ||
            title.length() > LEN_MAX_TITLE)
        {
            throw new IllegalArgumentException("oops");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Movie movie)) return false;
        return Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}

/**
 *
 */
class Main
{
    /**
     *
     * @param args
     */
    public static void main(final String[] args)
    {
        final Movie m;
        m = new Movie("ghostbusters");
        System.out.println( m.getTitle());
    }
}
