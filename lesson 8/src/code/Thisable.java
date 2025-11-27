public interface Thisable
{
    void a();
    void b();

    default void c()
    {
        System.out.println("c for thisable");
    }
}

interface Thatable
{
    void d();
    default void c()
    {
        System.out.println("d for thatable");
    }
}

class Person
    implements Thisable,
               Thatable,
               Comparable<Person>
{
    private final int yearBorn;

    Person(final int yearBorn)
    {
        this.yearBorn = yearBorn;
    }

    @Override
    public void d()
    {

    }

    @Override
    public void a()
    {

    }

    @Override
    public void b()
    {

    }

    @Override
    public int compareTo(final Person o)
    {
        return o.yearBorn - yearBorn;
    }

    @Override
    public void c()
    {
        System.out.println("c for person");
    }
}