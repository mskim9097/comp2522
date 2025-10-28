package ca.bcit.cst.comp2522.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Main class.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0.0
 */
public class Main
{
    private static HockeyTeam sampleTeam()
    {
        final List<HockeyPlayer> ps;
        ps = new ArrayList<>();

        ps.add(new HockeyPlayer("Alex Morgan", "F", 2002, 21));
        ps.add(new HockeyPlayer("Ben Carter",  "D", 1999,  6));
        ps.add(new HockeyPlayer("Casey Young", "F", 2004, 28));
        ps.add(new HockeyPlayer("Drew Singh",  "G", 2000,  0));
        ps.add(new HockeyPlayer("Eva Chen",    "D", 2001,  5));

        return new HockeyTeam("BCIT Blizzards", ps);
    }

    /**
     * Drives the program.
     * @param args no-argument.
     */
    public static void main(final String[] args)
    {
        final int                currentYear;
        final HockeyTeam         team;
        final List<HockeyPlayer> roster;

        final Supplier<HockeyPlayer> callUp;
        final Predicate<HockeyPlayer> isForward;
        final Predicate<HockeyPlayer> moreGoals;

        currentYear = 2025;
        team = sampleTeam();
        roster = team.getRoster();

        // 1) Supplier — create a call-up and add it
        System.out.println("\n1. Suppliers");




        callUp = () -> new HockeyPlayer("Finn Lee", "F", 2005, 12);

        roster.add(callUp.get());
        System.out.println("New call-up added: " + roster.get(roster.size() - 1).getName());

        // 2) Predicate — forwards with 20+ goals
        System.out.println("\n2. Predicates");



        isForward = p -> p.getPosition().equalsIgnoreCase("F");
        moreGoals = p -> p.getGoals() >= 20;

        for (final HockeyPlayer p : roster)
        {
            if (isForward.test(p) && moreGoals.test(p))
            {
                System.out.println(p.getName() + " is a forward with 20+ goals.");
            }
        }

        // 3) Function — map player to a label string
        System.out.println("\n3. Functions");

        final Function<HockeyPlayer, String> playerToLabel;
        playerToLabel = p -> {
            final StringBuilder sb;
            sb = new StringBuilder();

            sb.append(p.getName());
            sb.append("-");
            sb.append(p.getGoals());
            sb.append(p.getPosition());

            return sb.toString();
        };

        for (final HockeyPlayer p : roster)
        {
            System.out.println(playerToLabel.apply(p));
        }

        // 4) Consumer — print names
        System.out.println("\n4. Consumer");

        final Consumer<HockeyPlayer> printName;
        printName = p -> System.out.println(p.getName());

        for (final HockeyPlayer p : roster)
        {
            printName.accept(p);
        }

        // 5) UnaryOperator — uppercase names
        System.out.println("\n5. UnaryOperator");

        final UnaryOperator<String> toUpperCase;
        toUpperCase = s -> s.toUpperCase();

        for (final HockeyPlayer p : roster)
        {
            final String upperName;
            upperName = toUpperCase.apply(p.getName());

            System.out.println(upperName);
        }

        // 6) Comparator — sort by goals DESC (no chaining)
        System.out.println("\n6. Comparator");

        final Comparator<HockeyPlayer> sortByGoalsDesc;

        sortByGoalsDesc = (a, b) -> Integer.compare(b.getGoals(), a.getGoals());

        System.out.println("Before sorting:");
        for (final HockeyPlayer p : roster)
        {
            System.out.println(p.getName() + " goals: " + p.getGoals());
        }

        Collections.sort(roster, sortByGoalsDesc);

        System.out.println("\nAfter sorting:");
        for (final HockeyPlayer p : roster)
        {
            System.out.println(p.getName() + " goals: " + p.getGoals());
        }

        // 7) Aggregation (loop) — total goals
        System.out.println("\n7. Aggregation");

        int sum;
        sum = 0;

        for (final HockeyPlayer p : roster)
        {
            sum += p.getGoals();
        }

        System.out.println(team.getName() + "'s total goals: " + sum);

        // 8) Custom FI (EligibilityRule)
        System.out.println("\n8. Custom Functional Interface (EligibilityRule)");

        final EligibilityRule isEligible;
        isEligible = (player, minAge, minGoals, year) -> {
            final int age;
            age = year - player.getYearOfBirth();
            return age >= minAge && player.getGoals() >= minGoals;
        };

        final int minAge;
        final int minGoals;

        minAge = 20;
        minGoals = 15;

        System.out.println("Eligible players (age >= " + minAge +
                ", goals >= " + minGoals + "):");

        for (final HockeyPlayer p : roster)
        {
            if (isEligible.test(p, minAge, minGoals, currentYear))
            {
                final StringBuilder sb;
                sb = new StringBuilder();

                sb.append("Name: ").append(p.getName());
                sb.append(" | Age: ").append(currentYear - p.getYearOfBirth());
                sb.append(" | Goals: ").append(p.getGoals());

                System.out.println(sb.toString());
            }
        }
    }
}