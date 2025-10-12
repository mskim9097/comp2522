package ca.bcit.comp2522.bookstore;

public class Author extends Person
                    implements Printable
{
    private static final int MAXIMUM_CHARACTERS = 30;

    private final String genre;

    public Author(final Name name,
                  final Date dateOfBirth,
                  final Date dateOfDeath,
                  final String genre)
    {
        super(name, dateOfBirth, dateOfDeath);

        validateGenre(genre);
        this.genre = genre;
    }

    public final String getGenre()
    {
        return genre;
    }

    @Override
    public void display()
    {
        System.out.println(toString());
    }

    private static void validateGenre(final String genre)
    {
        if (genre == null ||
            genre.isBlank() ||
            genre.length() > MAXIMUM_CHARACTERS)
        {
            throw new IllegalArgumentException(
                    "Invalid genre");
        }
    }

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
