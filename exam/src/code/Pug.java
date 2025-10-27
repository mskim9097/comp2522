public class Pug extends Dog
{
    private final boolean isBrown;

    public Pug(final String name,
               final int bornYear,
               final boolean isBrown)
    {
        super(name, bornYear);
        this.isBrown = isBrown;
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("Pug is brown: " + isBrown);
    }
}
