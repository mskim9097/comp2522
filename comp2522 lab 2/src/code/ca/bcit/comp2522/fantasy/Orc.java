package ca.bcit.comp2522.fantasy;

import java.util.Date;

/**
 * The Orc class represents a warrior-like creature that extends
 * the {@link Creature} class. In addition to the inherited
 * attributes (name, date of birth, and health), an Orc has
 * a rage attribute that fuels its berserk attacks.
 * Orcs can:
 * - Enter berserk mode to deal damage to a target
 * - Deal double damage when rage exceeds a threshold
 * - Display detailed information including rage
 * Rage increases when berserk is used, capped at {@value MAXIMUM_RAGE}.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 * 
 * @version 1.0
 */
public class Orc extends Creature
{
    private static final int MINIMUM_RAGE   = 0;
    private static final int MAXIMUM_RAGE   = 30;
    private static final int RAGE_INCREMENT = 5;

    private static final int BERSERK_DAMAGE       = 15;
    private static final int MINIMUM_BERSERK_RAGE = 5;

    private static final int DOUBLE_DAMAGE_RAGE = 20;
    private static final int DOUBLE_DAMAGE      = 2;

    private int rage;

    /**
     * Constructor for the Orc class.
     * Initializes all attributes and validates rage.
     *
     * @param name The name of the Orc
     * @param dateOfBirth The birthdate of the Orc
     * @param health The health value of the Orc
     * @param rage The initial rage value of the Orc
     */
    public Orc(final String name,
               final Date dateOfBirth,
               final int health,
               final int rage)
    {
        super(name,
              dateOfBirth,
              health);

        validateRage(rage);

        this.rage = rage;
    }

    /**
     * Prints the details of the Orc, including inherited
     * attributes and the rage value.
     */
    @Override
    public void getDetails()
    {
        super.getDetails();
        System.out.println("Rage: " + rage);
    }

    /**
     * Allows the Orc to go berserk and attack a target Creature.
     * Rage increases after using berserk, and if the rage is above
     * a threshold, the Orc deals {@value DOUBLE_DAMAGE} times.
     *
     * @param target The Creature being attacked
     * @throws LowRageException if rage is less than {@value MINIMUM_BERSERK_RAGE}
     */
    public void berserk(final Creature target)
            throws LowRageException
    {
        if(rage < MINIMUM_BERSERK_RAGE)
        {
            throw new LowRageException(
                    "Rage cannot be less than " + MINIMUM_BERSERK_RAGE + ".");
        }

        rage += RAGE_INCREMENT;

        if(rage > MAXIMUM_RAGE)
        {
            rage = MAXIMUM_RAGE;
        }

        if(rage > DOUBLE_DAMAGE_RAGE)
        {
            target.takeDamage(
                    BERSERK_DAMAGE * DOUBLE_DAMAGE);
        }
        else
        {
            target.takeDamage(
                    BERSERK_DAMAGE);
        }
    }

    /**
     * Validates the rage value.
     *
     * @param rage The rage value to check
     * @throws IllegalArgumentException if rage is out of valid range
     */
    private static void validateRage(final int rage)
    {
        if(rage < MINIMUM_RAGE ||
           rage > MAXIMUM_RAGE)
        {
            final StringBuilder errorMessages;
            errorMessages = new StringBuilder();

            errorMessages.append("Rage must be between ");
            errorMessages.append(MINIMUM_RAGE);
            errorMessages.append(" and ");
            errorMessages.append(MAXIMUM_RAGE);
            errorMessages.append(".");

            throw new IllegalArgumentException(
                    errorMessages.toString());
        }
    }
}
