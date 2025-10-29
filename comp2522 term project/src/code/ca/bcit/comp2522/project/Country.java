package ca.bcit.comp2522.project;

/**
 * Represents a country.
 *
 * @author Minsu Kim
 *
 * @version 1.0.0
 */
public class Country
{
    private static final int FACT_COUNT  = 3;
    private static final int FIRST_FACT  = 0;
    private static final int SECOND_FACT = 1;
    private static final int THIRD_FACT  = 2;

    private final String   name;
    private final String   capitalCityName;
    private final String[] facts;

    /**
     * Constructor for Country.
     * @param name name of the country
     * @param capitalCityName name of the capital city
     * @param facts facts about the country
     */
    public Country(final String   name,
                   final String   capitalCityName,
                   final String[] facts)
    {
        validateName(name);
        validateCapitalCityName(capitalCityName);
        validateFacts(facts);

        this.name            = name;
        this.capitalCityName = capitalCityName;

        final String[] copy;
        copy = new String[FACT_COUNT];
        copy[FIRST_FACT]  = facts[FIRST_FACT];
        copy[SECOND_FACT] = facts[SECOND_FACT];
        copy[THIRD_FACT]  = facts[THIRD_FACT];

        this.facts = copy;
    }

    /**
     * Gets the name of the country.
     * @return the name of the country
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the name of the capital city.
     * @return the name of the capital city
     */
    public String getCapitalCityName()
    {
        return capitalCityName;
    }

    /**
     * Gets the facts about the country.
     * @return the facts about the country
     */
    public String[] getFacts()
    {
        final String[] copy;
        copy = new String[FACT_COUNT];
        copy[FIRST_FACT]  = facts[FIRST_FACT];
        copy[SECOND_FACT] = facts[SECOND_FACT];
        copy[THIRD_FACT]  = facts[THIRD_FACT];
        return copy;
    }

    /**
     * Validates the name. The name cannot be null or blank.
     * @param name the name to validate
     */
    private static void validateName(final String name)
    {
        if (name == null ||
            name.isBlank())
        {
            throw new IllegalArgumentException(
                    "Name cannot be null or blank.");
        }
    }

    /**
     * Validates the capital city name. The capital city name cannot be null or blank.
     * @param capitalCityName the capital city name to validate
     */
    private static void validateCapitalCityName(
            final String capitalCityName)
    {
        if (capitalCityName == null ||
            capitalCityName.isBlank())
        {
            throw new IllegalArgumentException(
                    "Capital city name cannot be null or blank.");
        }
    }

    /**
     * Validates the facts. The fact array must contain exactly {@value FACT_COUNT} elements.
     * @param facts the facts to validate
     */
    private static void validateFacts(final String[] facts)
    {
        if (facts == null ||
            facts.length != FACT_COUNT)
        {
            final StringBuilder sb;
            sb = new StringBuilder();
            sb.append("Facts array must contain exactly ");
            sb.append(FACT_COUNT);
            sb.append(" elements.");

            throw new IllegalArgumentException(sb.toString());
        }
    }
}
