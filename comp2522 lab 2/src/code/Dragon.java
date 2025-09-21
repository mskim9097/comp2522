import java.util.Date;

/**
 * Dragon class represents a dragon.
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

    /* Firepower of the dragon. */
    private int firePower;

    /**
     * Constructor for the Dragon class.
     *
     * @param name The name of the dragon
     * @param dateOfBirth The birthDate of the dragon
     * @param health The health of the dragon
     * @param firePower The firepower of the dragon
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

    /* Method that prints the details of the Dragon */
    @Override
    public void getDetails()
    {
        super.getDetails();
        System.out.println("Fire Power: " + firePower);
    }

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

    /* Method that validates the input firepower. */
    private static void validateFirePower(final int firePower)
    {
        if (firePower < MINIMUM_FIRE_POWER ||
                firePower > MAXIMUM_FIRE_POWER) {
            throw new IllegalArgumentException(
                    "Fire power must be between 1 and 100.");
        }
    }
}



