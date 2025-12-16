import java.util.Objects;

public class Dog
{
    private final String name;
    private final int yearBorn;

    public Dog(final String name, final int yearBorn)
    {
        this.name = name;
        this.yearBorn = yearBorn;
    }

    public void display()
    {
        System.out.println(name + ", " + yearBorn);
    }
}

public class Pug extends Dog
{
    private final boolean isBrown;

    public Pug(final String name,
               final int yearBorn,
               final boolean isBrown)
    {
        super(name, yearBorn);
        this.isBrown = isBrown;
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("is Brown: " + isBrown);
    }
}
