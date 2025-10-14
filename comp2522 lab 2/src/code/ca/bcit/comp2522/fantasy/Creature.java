package ca.bcit.comp2522.fantasy;

import java.util.Date;

/**
 * The Creature class represents a creature with a name, date of birth,
 * and health status. It includes methods to take damage, heal,
 * calculate age, and display details.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class Creature
{
    private static final int MINIMUM_HEALTH = 55;
    private static final int MAXIMUM_HEALTH = 1000;

    private static final int DEAD_HEALTH = 0;
    private static final int MINIMUM_DAMAGE   = 0;
    private static final int MINIMUM_HEALING  = 0;

    private static final int BIRTHDAY_NOT_PASSED_OFFSET = 1;

    private final String name;
    private final Date   dateOfBirth;
    private       int    health;

    /**
     * Constructor for the Creature class.
     *
     * @param name The name of the creature
     * @param dateOfBirth The birthdate of the creature
     * @param health The health of the creature.
     */
    public Creature(final String name,
                    final Date dateOfBirth,
                    final int health)
    {
        validateName(name);
        validateDateOfBirth(dateOfBirth);
        validateHealth(health);

        this.name        = name;
        this.dateOfBirth = new Date(dateOfBirth.getTime());
        this.health      = health;
    }

    /**
     * Method that checks if the creature is alive.
     * @return true if the creature is alive, false otherwise
     */
    public boolean isAlive()
    {
        return health > DEAD_HEALTH;
    }

    /**
     * Reduces the creature's health by the given damage amount.
     *
     * @param damage The amount of damage to take
     * @throws DamageException if damage is less than {@value MINIMUM_DAMAGE}
     */
    public void takeDamage(final int damage)
    {
        if (damage < MINIMUM_DAMAGE)
        {
            throw new DamageException(
                    "Damage cannot be less than " + MINIMUM_DAMAGE + ".");
        }

        health -= damage;

        if(health < DEAD_HEALTH)
        {
            health = DEAD_HEALTH;
        }
    }

    /**
     * Increases the creature's health by the given healing amount.
     *
     * @param healAmount The amount of health to heal
     * @throws HealingException if the healing amount is less than {@value MINIMUM_HEALING}
     */
    public void heal(final int healAmount)
    {
        if(healAmount < MINIMUM_HEALING)
        {
            throw new HealingException(
                    "Healing amount cannot be less than " + MINIMUM_HEALING + ".");
        }

        health += healAmount;

        if(health > MAXIMUM_HEALTH)
        {
            health = MAXIMUM_HEALTH;
        }
    }

    /**
     * Calculates the creature's age in full years.
     *
     * @return The age of the creature in years
     */
    public int getAgeYears()
    {
        final Date now;
        now = new Date();

        int age = now.getYear() - dateOfBirth.getYear();

        // if the birthday for the current year hasn't occurred yet, subtract 1
        if((now.getMonth() < dateOfBirth.getMonth()) ||
           (now.getMonth() == dateOfBirth.getMonth() &&
            now.getDate() < dateOfBirth.getDate()))
        {
            age -= BIRTHDAY_NOT_PASSED_OFFSET;
        }
        return age;
    }

    /**
     * Prints the details of the creature, including
     * name, date of birth, age, and current health.
     */
    public void getDetails()
    {
        final StringBuilder details;
        details = new StringBuilder();

        details.append("\n");
        details.append("Name: ");
        details.append(name);
        details.append("\nDate Of Birth: ");
        details.append(dateOfBirth);
        details.append("\nAge: ");
        details.append(getAgeYears());
        details.append("\nHealth: ");
        details.append(health);

        System.out.println(details.toString());
    }

    /**
     * Validates the creature's name.
     *
     * @param name The name to validate
     * @throws IllegalArgumentException if the name is null or empty
     */
    private static void validateName(final String name)
    {
        if (name == null ||
            name.trim().isEmpty())
        {
            throw new IllegalArgumentException(
                    "Name cannot be null or empty.");
        }
    }

    /**
     * Validates the creature's date of birth.
     *
     * @param dateOfBirth The date to validate
     * @throws IllegalArgumentException if the date is null or in the future
     */
    private static void validateDateOfBirth(final Date dateOfBirth)
    {
        final Date now;

        now = new Date();

        if (dateOfBirth == null ||
            dateOfBirth.after(now))
        {
            throw new IllegalArgumentException(
                    "Date of birth cannot be null or in the future.");
        }
    }

    /**
     * Validates the creature's health value.
     *
     * @param health The health value to validate
     * @throws IllegalArgumentException if health is out of a valid range of health
     */
    private static void validateHealth(final int health)
    {
        if (health < MINIMUM_HEALTH ||
            health > MAXIMUM_HEALTH)
        {
            final StringBuilder errorMessages;
            errorMessages = new StringBuilder();

            errorMessages.append("Health must be between ");
            errorMessages.append(MINIMUM_HEALTH);
            errorMessages.append(" and ");
            errorMessages.append(MAXIMUM_HEALTH);
            errorMessages.append(".");

            throw new IllegalArgumentException(errorMessages.toString());
        }
    }
}
