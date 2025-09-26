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

    private static final int MINIMUM_FIRE_POWER = 0;
    private static final int MAXIMUM_FIRE_POWER = 100;
    private static final int FIRE_POWER_DECREMENT= 10;
    private static final int BREATHE_FIRE_DAGAGE = 20;

    private int firePower;

    /**
     * Constructor for the Dragon class.
     * Validates firePower and initializes the Dragon object.
     *
     * @param name The name of the dragon
     * @param dateOfBirth The birth date of the dragon
     * @param health The health of the dragon
     * @param firePower The initial fire power of the dragon
     * @throws IllegalArgumentException if firePower is invalid
     */
    public Dragon(final String name,
                  final Date dateOfBirth,
                  int health,
                  int firePower)
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
     * @throws LowFirePowerException if firePower is too low
     */
    public void breathFire(final Creature target)
            throws LowFirePowerException
    {
        if (firePower < FIRE_POWER_DECREMENT)
        {
            throw new LowFirePowerException ("Not enough firePower to breathe fire! ");
        }
        firePower -= FIRE_POWER_DECREMENT;
        target.takeDamage(BREATHE_FIRE_DAGAGE);
    }


    /**
     * Restores the dragon's firepower by a given amount.
     * Firepower is capped at 100.
     *
     * @param amount The amount of fire power to restore
     * @throws IllegalArgumentException if amount is negative
     */
    public void restoreFirePower(final int amount)
    {
        if (amount < MINIMUM_FIRE_POWER)
        {
            throw new IllegalArgumentException("Fire power cannot be larger than 100.");
        }
        firePower += amount;

        if(firePower > MAXIMUM_FIRE_POWER)
        {
            firePower = MAXIMUM_FIRE_POWER;
        }
    }

    /**
     * Validates the firepower value to ensure it is within
     * the allowed range (0–100).
     *
     * @param firePower The fire power value to validate
     * @throws IllegalArgumentException if firePower is out of range
     */
    private static void validateFirePower(final int firePower)
    {
        if (firePower < MINIMUM_FIRE_POWER ||
                firePower > MAXIMUM_FIRE_POWER) {
            throw new IllegalArgumentException(
                    "Fire power must be between 1 and 100.");
        }
    }
}



