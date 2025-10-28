package ca.bcit.cst.comp2522.lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a hockey team.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0.0
 */
public class HockeyTeam
{
    private final String             name;
    private final List<HockeyPlayer> roster;

    /**
     * Constructs a new hockey team.
     *
     * @param name name of the team
     * @param roster roster of the team
     */
    public HockeyTeam(final String             name,
                      final List<HockeyPlayer> roster)
    {
        validateName(name);

        this.name   = name;
        this.roster = new ArrayList<>(roster);
    }

    /**
     * Gets the name of the team.
     * @return name of the team
     */
    public final String getName()
    {
        return name;
    }

    /**
     * Gets the roster of the team.
     * @return roster of the team
     */
    public final List<HockeyPlayer> getRoster()
    {
        return roster;
    }

    /**
     * Validates the name of a team.
     *
     * @param name name of the team
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
     * Returns a string representation of the team.
     * @return a string representation of the team
     */
    @Override
    public String toString()
    {
        final StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Team name: ");
        sb.append(name);
        sb.append("\nRoster: ");
        sb.append(roster);

        return sb.toString();
    }
}
