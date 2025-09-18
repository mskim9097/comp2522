import java.io.IOException;

class Dog extends Animal
{
    private final String name;

    Dog(final int birthYear,
        final String name) throws IllegalDogBirthYearException
    {
        super(Dog.validateBirthYear(birthYear));
        this.name = name;
        System.out.println(this.getBirthYear());
    }

    @Override
    void speak()
    {
        System.out.println("Woof!");
    }

    static int validateBirthYear(final int birthYear)
    {
        if (birthYear < 2005)
        {
            throw new IllegalArgumentException("No");
        }
        return birthYear;
    }
}
