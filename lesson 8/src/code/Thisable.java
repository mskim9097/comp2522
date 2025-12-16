interface Thisable
{
    void a();
    void b();
    default void c(){}
}

interface Thatable
{
    void d();
    default void c(){}
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
    public void c()
    {
        System.out.println("whatever");
    }



    @Override
    public int compareTo(final Person o)
    {
        return o.yearBorn - this.yearBorn;
    }
}
