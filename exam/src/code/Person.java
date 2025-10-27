public class Person
{
    private final String first;

    public Person(final String first)
    {
        validateFirst(first);
        this.first = first;
    }

    public String getFirst()
    {
        return first;
    }

    private static void validateFirst(final String first)
    {
        if(first == null || first.isBlank())
        {
            throw new BadNameException("Invalid first name.");
        }
    }

    public static void main(final String[] args)
    {
        final Person p1;
        p1 = new Person("John");

        System.out.println(p1.getFirst());
    }
}
