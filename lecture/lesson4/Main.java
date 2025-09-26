public class Main
{
    public static void main(final String[] args)
    {
        final Flyable f1;
        final Flyable f2;

        f1 = new Crow(2020, 102);
        f2 = new Helicopter();

        f1.fly();
        System.out.println(f1.getMaxHeightFeet());
        f1.land();
        f1.crash();

        if(f1 instanceof Crow)
        {
            final Crow c;
            c = (Crow)f1;
            c.caw();
        }

        f2.fly();
        System.out.println(f2.getMaxHeightFeet());
        f2.land();
        f2.crash();


    }
}
