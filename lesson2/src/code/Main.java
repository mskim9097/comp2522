import java.io.IOException;

public class Main
{
    public static void main(final String[] args)
    {
        final Animal a1;
        final Animal a2;

        try
        {
            a1 = new Dog(2026, "rocky");

            a2 = new Dolphin(2019);

            a1.speak();
            a2.speak();

            System.out.println(a1.getClass().getSimpleName());
        }
        catch (final IOException e)
        {
            System.out.println("IOException");
            System.out.println("catch");
        }
        finally
        {
            System.out.println("finally");
        }



//        if(a1 instanceof Dog)
//        {
//            final Dog d;
//            d = (Dog)a1;
//            d.bark();
//        }


    }
}
