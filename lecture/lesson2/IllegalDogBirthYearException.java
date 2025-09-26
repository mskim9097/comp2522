public class IllegalDogBirthYearException
    //extends Exception
    extends RuntimeException
{
    IllegalDogBirthYearException(final String message)
    {
        super(message);
    }
}
