import java.io.IOException;

public class Dolphin extends Animal
{
    Dolphin(final int birthYear)
            throws IllegalDogBirthYearException
    {
        super(birthYear);
    }


    @Override
    void speak()
    {
        System.out.println("ee e eee");
    }
}
