import java.util.Objects;

public class Dog
{
    private final String name;
    private final int bornYear;

    public Dog(final String name,
               final int bornYear)
    {
        this.name = name;
        this.bornYear = bornYear;
    }

    public void display()
    {
        System.out.println("Dog name: " + name);
        System.out.println("Dog born year: " + bornYear);
    }

    @Override
    public boolean equals(final Object o)
    {
        if(o == null)
        {
            return false;
        }
        if(o == this)
        {
            return true;
        }
        if(!o.getClass().equals(this.getClass()))
        {
            return false;
        }

        final Dog that = (Dog)o;

        return this.name.equals(that.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }
}
