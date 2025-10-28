package ca.bcit.cst.comp2522.lambdas;

/**
 * Represents a hockey player.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0.0
 */
public class HockeyPlayer
{
    private static final int MINIMUM_YEAR  = 1900;
    private static final int CURRENT_YEAR  = 2025;
    private static final int MINIMUM_GOALS = 0;

    private static final String POSITION_FORWARD = "F";
    private static final String POSITION_DEFENCE = "D";
    private static final String POSITION_GOALIE  = "G";

    private final String name;
    private final String position;
    private final int    yearOfBirth;
    private       int    goals;

    /**
     * Constructs a new hockey player.
     *
     * @param name name of the player
     * @param position position of the player
     * @param yearOfBirth year of birth of the player
     * @param goals number of goals scored by the player
     */
    public HockeyPlayer(final String name,
                        final String position,
                        final int    yearOfBirth,
                        final int    goals)
    {
        validateName(name);
        validatePosition(position);
        validateYearOfBirth(yearOfBirth);
        validateGoals(goals);

        this.name         = name;
        this.position     = position;
        this.yearOfBirth  = yearOfBirth;
        this.goals        = goals;
    }

    /**
     * Gets the name of the player.
     *
     * @return name of the player
     */
    public final String getName()
    {
        return name;
    }

    /**
     * Gets the position of the player.
     *
     * @return position of the player
     */
    public final String getPosition()
    {
        return position;
    }

    /**
     * Gets the year of birth of the player.
     * @return year of birth of the player
     */
    public final int getYearOfBirth()
    {
        return yearOfBirth;
    }

    /**
     * Gets the number of goals scored by the player.
     *
     * @return number of goals scored by the player
     */
    public final int getGoals()
    {
        return goals;
    }

    /**
     * Sets the number of goals scored by the player.
     *
     * @param goals number of goals scored by the player
     */
    public final void setGoals(int goals)
    {
        validateGoals(goals);
        this.goals = goals;
    }

    /**
     * Validates the name of a player.
     *
     * @param name name of the player
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
     * Validates the position of a player.
     *
     * @param position position of the player
     */
    private static void validatePosition(final String position)
    {
        if( position == null ||
            position.isBlank())
        {
            throw new IllegalArgumentException(
                    "Position cannot be null or blank.");
        }

        if(!position.equalsIgnoreCase(POSITION_FORWARD) &&
           !position.equalsIgnoreCase(POSITION_DEFENCE) &&
           !position.equalsIgnoreCase(POSITION_GOALIE))
        {
            final StringBuilder sb;
            sb = new StringBuilder();

            sb.append("Position should be either ");
            sb.append(POSITION_FORWARD);
            sb.append(", ");
            sb.append(POSITION_DEFENCE);
            sb.append(" or ");
            sb.append(POSITION_GOALIE);
            sb.append(".");

            throw new IllegalArgumentException(sb.toString());
        }
    }


    /**
     * Validates the birth year of a player.
     * Ensure the provided year is between {@value MINIMUM_YEAR} and {@value CURRENT_YEAR}.
     *
     * @param yearOfBirth birth year of the player
     */
    private static void validateYearOfBirth(final int yearOfBirth)
    {
        if (yearOfBirth > CURRENT_YEAR ||
            yearOfBirth < MINIMUM_YEAR)
        {
            final StringBuilder sb;
            sb = new StringBuilder();

            sb.append("A birth year should be between ");
            sb.append(MINIMUM_YEAR);
            sb.append(" and ");
            sb.append(CURRENT_YEAR);
            sb.append(".");

            throw new IllegalArgumentException(sb.toString());
        }
    }

    /**
     * Validates the number of goals scored by a player.
     * Ensures the value is less than {@value MINIMUM_GOALS}}
     *
     * @param goals number of goals scored by the player
     */
    private static void validateGoals(final int goals)
    {
        if (goals < MINIMUM_GOALS)
        {
            final StringBuilder sb;
            sb = new StringBuilder();

            sb.append("A goal cannot be less than ");
            sb.append(MINIMUM_GOALS);
            sb.append(".");

            throw new IllegalArgumentException(sb.toString());
        }
    }

    /**
     * Returns a string representation of the player.
     *
     * @return a string representation of the player
     */
    @Override
    public String toString()
    {
        final StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Player name: ");
        sb.append(name);
        sb.append("\nposition: ");
        sb.append(position);
        sb.append("\nyear of birth: ");
        sb.append(yearOfBirth);
        sb.append("\ngoals: ");
        sb.append(goals);

        return sb.toString();
    }
}
