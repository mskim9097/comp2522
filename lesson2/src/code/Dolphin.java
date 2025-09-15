import java.io.IOException;

public class Dolphin extends Animal
{
    Dolphin(final int birthYear) throws IOException
    {
        super(birthYear);
    }


    @Override
    void speak()
    {
        System.out.println("Dolphin says!");
    }
}
