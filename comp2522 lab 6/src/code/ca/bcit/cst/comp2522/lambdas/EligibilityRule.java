package ca.bcit.cst.comp2522.lambdas;

/**
 * A custom functional interface that determines
 * whether a hockey player meets eligibility criteria.
 *
 * A player is eligible if their age is at least {@code minAge}
 * and their goals are at least {@code minGoals}.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0.0
 */
@FunctionalInterface
public interface EligibilityRule
{
    /**
     * Tests whether a player is eligible.
     *
     * @param player the player to test
     * @param minAge minimum required age
     * @param minGoals minimum required goals
     * @param currentYear the current year
     * @return {@code true} if the player is eligible, {@code false} otherwise
     */
    boolean test(final HockeyPlayer player,
                 final int          minAge,
                 final int          minGoals,
                 final int          currentYear);
}
