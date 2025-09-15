import java.io.IOException;

class Dog extends Animal
{
    private final String name;

    Dog(final int birthYear,
        final String name) throws IOException
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
        if (birthYear < 2000)
        {
            throw new IllegalArgumentException("Invalid birth year");
        }
        return birthYear;
    }
}
