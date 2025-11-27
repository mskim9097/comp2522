import java.util.Objects;

public class HorrorMovie extends Movie
{
    private final String scaryCharacter;

    HorrorMovie(final String title,
                final String scaryCharacter)
            throws InvalidScarer
    {
        super(title);
        validateScaryCharacter(scaryCharacter);
        this.scaryCharacter = scaryCharacter;
    }

    private static void validateScaryCharacter(final String scaryCharacter)
            throws InvalidScarer
    {
        if (scaryCharacter == null ||
            scaryCharacter.isBlank())
        {
            throw new InvalidScarer("no");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HorrorMovie that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(scaryCharacter, that.scaryCharacter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), scaryCharacter);
    }
}

class InvalidScarer extends Exception
{
    InvalidScarer(final String message)
    {
        super(message);
    }
}

class Main2
{
    public static void main(final String[] args)
    {
        final Movie m1;
        final Movie m2;

        m1 = new Movie("a");

        try
        {
            m2 = new HorrorMovie("b", "c");
            System.out.println(m1.getTitle());
            System.out.println(m2.getTitle());
        }
        catch (InvalidScarer e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            System.out.println("goodbye");
        }


    }
}
