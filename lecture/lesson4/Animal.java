public abstract class Animal
    implements Comparable<Animal>
{
    private final int birthYear;

    Animal(final int birthYear)
    {
        this.birthYear = birthYear;
    }

    int getBirthYear()
    {
        return birthYear;
    }

    /**
     * Older animals are "BIGGER".
     * @param that
     * @return
     */
    @Override
    public int compareTo(final Animal that)
    {
        return that.birthYear - this.birthYear;
    }
}
