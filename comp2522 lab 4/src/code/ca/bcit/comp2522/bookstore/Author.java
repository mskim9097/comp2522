package ca.bcit.comp2522.bookstore;

/**
 * A subclass of {@link Person} that represents an Author.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class Author extends Person
                    implements Printable
{
    private static final int MAXIMUM_GENRE_LENGTH = 30;

    private final String genre;

    /**
     * Constructor of Author.
     *
     * @param name name of author.
     * @param dateOfBirth birthdate of author.
     * @param dateOfDeath deathdate of author.
     * @param genre genre of author.
     */
    public Author(final Name name,
                  final Date dateOfBirth,
                  final Date dateOfDeath,
                  final String genre)
    {
        super(name, dateOfBirth, dateOfDeath);

        validateGenre(genre);
        this.genre = genre;
    }

    /**
     * A method that gets genre.
     * @return
     */
    public final String getGenre()
    {
        return genre;
    }

    /**
     * Displays the person's information.
     */
    @Override
    public void display()
    {
        System.out.println(toString());
    }

    // A method that validate genre.
    private static void validateGenre(final String genre)
    {
        if (genre == null ||
            genre.isBlank() ||
            genre.length() > MAXIMUM_GENRE_LENGTH)
        {
            throw new IllegalArgumentException(
                    "Invalid genre");
        }
    }

    /**
     * A method that returns Author's details.
     * @return author's details.
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Genre: ");
        sb.append(genre);
        sb.append("\n");

        return sb.toString();
    }
}
