public final class Crow
        extends Animal
        implements Flyable
{
    private final int iq;

    public Crow(final int birthYear,
                final int iq)
    {
        super(birthYear);
        this.iq = iq;
    }

    void caw()
    {
        System.out.println("CAW CAW");
    }

    @Override
    public void fly()
    {
        System.out.println("flap wings");
    }

    @Override
    public void land()
    {
        System.out.println("on feet");
    }

    @Override
    public int getMaxHeightFeet()
    {
        return 7000;
    }
}
