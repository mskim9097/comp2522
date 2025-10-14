package ca.bcit.comp2522.fantasy;

import java.util.Date;

/**
 * The Dragon class represents a creature of type Dragon,
 * which extends the {@link Creature} class. In addition to
 * health, name, and date of birth, a Dragon has a firePower
 * attribute that determines its ability to breathe fire.
 * It includes methods for breathing fire, restoring firepower,
 * and printing Dragon-specific details.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class Dragon extends Creature {

    private static final int MINIMUM_FIRE_POWER   = 0;
    private static final int MAXIMUM_FIRE_POWER   = 100;

    private static final int FIRE_POWER_DECREMENT = 10;
    private static final int BREATHE_FIRE_DAMAGE  = 20;

    private int firePower;

    /**
     * Constructor for the Dragon class.
     *
     * @param name The name of the dragon
     * @param dateOfBirth The birthdate of the dragon
     * @param health The health of the dragon
     * @param firePower The initial firepower of the dragon
     */
    public Dragon(final String name,
                  final Date dateOfBirth,
                  final int health,
                  final int firePower)
    {
        super(name,
              dateOfBirth,
              health);

        validateFirePower(firePower);

        this.firePower = firePower;
    }

    /**
     * Prints details of the dragon, including inherited fields
     * from Creature and firePower.
     */
    @Override
    public void getDetails()
    {
        super.getDetails();
        System.out.println("Fire Power: " + firePower);
    }

    /**
     * Allows the dragon to breathe fire at another Creature.
     * Consumes firepower and reduces the target's health.
     *
     * @param target The Creature to attack with fire
     * @throws LowFirePowerException if firePower is lower than {@value FIRE_POWER_DECREMENT}
     */
    public void breatheFire(final Creature target)
            throws LowFirePowerException
    {
        if (firePower < FIRE_POWER_DECREMENT)
        {
            throw new LowFirePowerException (
                    "Not enough firePower to breathe fire! ");
        }
        firePower -= FIRE_POWER_DECREMENT;
        target.takeDamage(BREATHE_FIRE_DAMAGE);
    }

    /**
     * Restores the dragon's firepower by a given amount.
     *
     * @param amount The amount of firepower to restore
     * @throws IllegalArgumentException if the amount is less than {@value MINIMUM_FIRE_POWER}
     */
    public void restoreFirePower(final int amount)
    {
        if (amount < MINIMUM_FIRE_POWER)
        {
            throw new IllegalArgumentException(
                    "Amount cannot be less than " + MINIMUM_FIRE_POWER + ".");
        }

        firePower += amount;

        if(firePower > MAXIMUM_FIRE_POWER)
        {
            firePower = MAXIMUM_FIRE_POWER;
        }
    }

    /**
     * Validates the firepower value to ensure it is within
     * the allowed range of {@value MINIMUM_FIRE_POWER} and {@value MAXIMUM_FIRE_POWER}.
     *
     * @param firePower The firepower value to validate
     * @throws IllegalArgumentException if firePower is out of
     * {@value MINIMUM_FIRE_POWER} and {@value MAXIMUM_FIRE_POWER}
     */
    private static void validateFirePower(final int firePower)
    {
        if (firePower < MINIMUM_FIRE_POWER ||
            firePower > MAXIMUM_FIRE_POWER)
        {
            final StringBuilder errorMessages;
            errorMessages = new StringBuilder();

            errorMessages.append("Fire power must be between ");
            errorMessages.append(MINIMUM_FIRE_POWER);
            errorMessages.append(" and ");
            errorMessages.append(MAXIMUM_FIRE_POWER);
            errorMessages.append(".");

            throw new IllegalArgumentException(
                    errorMessages.toString());
        }
    }
}



