package ca.bcit.comp2522.fantasy;

import java.util.Calendar;
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
    private static final int MINIMUM_HEALTH = 1;
    private static final int MAXIMUM_HEALTH = 100;

    private static final int DEAD_HEALTH = 0;
    private static final int NO_DAMAGE   = 0;
    private static final int NO_HEALING  = 0;

    private static final int ADD_ONE_AFTER_BIRTH = 1;

    private final String name;
    private final Date   dateOfBirth;
    private       int    health;

    /**
     * Constructor for the Creature class.
     * Validates inputs and sets initial values.
     *
     * @param name The name of the creature (non-null, not empty)
     * @param dateOfBirth The birthdate of the creature (non-null, not in the future)
     * @param health The health of the creature (between 1 and 100)
     */
    public Creature(final String name,
                    final Date dateOfBirth,
                    int health)
    {
        validateName(name);
        validateDateOfBirth(dateOfBirth);
        validateHealth(health);

        this.name        = name;
        this.dateOfBirth = dateOfBirth;
        this.health      = health;
    }

    /**
     * Method that checks if the creature is alive.
     * @return true if the creature is greater than 0, false otherwise
     */
    public boolean isAlive()
    {
        return health > DEAD_HEALTH;
    }

    /**
     * Reduces the creature's health by the given damage amount.
     * Health cannot drop below 0.
     *
     * @param damage The amount of damage to take
     * @throws DamageException if damage is negative
     */
    public void takeDamage(final int damage)
    {
        if (damage < NO_DAMAGE)
        {
            throw new DamageException(
                    "Damage cannot be negative.");
        }

        health -= damage;

        if(health < DEAD_HEALTH)
        {
            health = DEAD_HEALTH;
        }
    }

    /**
     * Increases the creature's health by the given healing amount.
     * Health cannot exceed 100.
     *
     * @param healAmount The amount of health to heal
     * @throws HealingException if healing amount is negative
     */
    public void heal(final int healAmount)
    {
        if(healAmount < NO_HEALING)
        {
            throw new HealingException(
                    "Healing amount cannot be negative.");
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
        final Calendar now;
        final Calendar birth;
        final int age;

        now = Calendar.getInstance();
        birth = Calendar.getInstance();
        birth.setTime(dateOfBirth);

        // if the birthdate is in the future, subtract 1
        if(now.get(Calendar.DAY_OF_YEAR) <
           birth.get(Calendar.DAY_OF_YEAR))
        {
            age = now.get(Calendar.YEAR) -
                  birth.get(Calendar.YEAR - ADD_ONE_AFTER_BIRTH);
        }
        else
        {
            age = now.get(Calendar.YEAR) -
                  birth.get(Calendar.YEAR);
        }
        return age;
    }

    /**
     * Prints the details of the creature, including:
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
     * @throws IllegalArgumentException if name is null or empty
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
     * @throws IllegalArgumentException if date is null or in the future
     */
    private static void validateDateOfBirth(final Date dateOfBirth)
    {
        final Date now;

        now = new Date();
        // can be deleted
        if (dateOfBirth == null ||
            dateOfBirth.after(now))
        {
            throw new IllegalArgumentException(
                    "Invalid date of birth.");
        }
    }

    /**
     * Validates the creature's health value.
     *
     * @param health The health value to validate
     * @throws IllegalArgumentException if health is out of range (1–100)
     */
    private static void validateHealth(final int health)
    {
        if (health < MINIMUM_HEALTH ||
            health > MAXIMUM_HEALTH)
        {
            throw new IllegalArgumentException(
                    "Health must be between 1 and 100.");
        }
    }
}
