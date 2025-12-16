public class Person
{
    private final String firstName;

    public Person(final String firstName)
    {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    private static void validateFirstName(final String firstName)
    {
        if(firstName == null || firstName.isBlank())
        {
            throw new BadNameException("Invalid first name.");
        }
    }
}

class Main
{
    public static void main(final String[] args)
    {
        final Person p1;

        p1 = new Person("John");
        System.out.println(p1.getFirstName());
    }
}
