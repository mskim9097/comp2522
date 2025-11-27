class Province
{
    public static final int MIN_POPULATION = 0;

    private final String name;
    private final int population;

    Province(final String name,
             final int population)
    {
        this.name = name;
        this.population = population;
    }

    public String getName()
    {
        return name;
    }

    public int getPopulation()
    {
        return population;
    }

    @Override
    public String toString()
    {
        return String.format("%s with pop %d",
                name,
                population);
    }
}
