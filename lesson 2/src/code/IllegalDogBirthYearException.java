public class IllegalDogBirthYearException
        //extends Exception
        extends RuntimeException
{
    public IllegalDogBirthYearException(final String message)
    {
        super(message);
    }
}
