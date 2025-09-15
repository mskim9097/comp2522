import java.io.IOException;

class Animal
{
    private static final int CURRENT_YEAR = 2025;
    private final int birthYear;

    Animal(final int birthYear,
           final boolean male) throws IOException
    {
        validateBirthYear(birthYear);
        this.birthYear = birthYear;
    }

    Animal(final int birthYear)
    {
        this.birthYear = birthYear;
    }

    /**
     * CAnnot be born in the future.
     *
     * @param birthYear the birth year.
     * @throws IOException if the birth year is invalid.
     */
    private static void validateBirthYear(final int birthYear)
            throws IOException
    {
        if(birthYear > CURRENT_YEAR)
        {
            throw new IOException("Invalid birth year");
        }
    }

    void speak()
    {
        System.out.println("Speaking");
    }

    protected int getBirthYear()
    {
        return birthYear;
    }
}
