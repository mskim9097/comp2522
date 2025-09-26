import java.io.IOException;

public class Main
{
    public static void main(final String[] args)
    {
        final Animal a1;
        final Animal a2;

        try
        {
            a1 = new Dog(2020, "rocky");

            a2 = new Dolphin(2000);

            a1.speak();  // woof
            a2.speak();  // eeee ee

            System.out.println(a1.getClass().getSimpleName());
            return;
        }
        catch(final IllegalDogBirthYearException e)
        {
            System.out.println(e.getMessage());
            System.out.println(":(");
        }
        finally
        {
            System.out.println("THE END BYE");
        }


//        if(a1 instanceof Dog)
//        {
//            final Dog d;
//            d = (Dog)a1;
//            d.bark();
//        }


    }
}
