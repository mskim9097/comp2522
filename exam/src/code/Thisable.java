interface Thisable
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
        System.out.println("c for thatable");
    }
}

class Person implements Thisable, Thatable, Comparable<Person>
{
    private final int birthYear;

    Person(final int birthYear)
    {
        this.birthYear = birthYear;
    }

    @Override
    public void a()
    {
        System.out.println( "a for this");
    }

    @Override
    public void b()
    {
        System.out.println("b for this");
    }

    @Override
    public void d()
    {
        System.out.println("d for that");
    }

    @Override
    public void c()
    {
        Thisable.super.c();
    }

    @Override
    public int compareTo(final Person other)
    {
        return other.birthYear - birthYear;
    }
}