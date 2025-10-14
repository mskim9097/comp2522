package ca.bcit.comp2522.fantasy;

import java.util.Date;

/**
 * The Elf class represents a magical creature that extends
 * the {@link Creature} class. In addition to the inherited
 * attributes (name, date of birth, and health), an Elf has
 * a mana value used to cast spells.
 * Elves can:
 * - Cast spells that consume mana and damage targets
 * - Restore mana
 * - Display detailed information including mana
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class Elf extends Creature
{
    private static final int MINIMUM_MANA        = 0;
    private static final int MAXIMUM_MANA        = 50;

    private static final int MANA_COST_PER_SPELL = 5;
    private static final int SPELL_DAMAGE        = 10;

    private int mana;

    /**
     * Constructor for the Elf class.
     * Initializes all attributes and validates mana.
     *
     * @param name The name of the Elf
     * @param dateOfBirth The birthdate of the Elf
     * @param health The health value of the Elf
     * @param mana The initial mana value of the Elf
     */
    public Elf(final String name,
               final Date dateOfBirth,
               final int health,
               final int mana)
    {
        super(name,
              dateOfBirth,
              health);

        validateMana(mana);

        this.mana = mana;
    }

    /**
     * Prints the details of the Elf, including inherited
     * attributes and the mana value.
     */
    @Override
    public void getDetails()
    {
        super.getDetails();
        System.out.println("Mana: " + mana);
    }

    /**
     * Allows the Elf to cast a spell on a target Creature.
     * Consumes mana and inflicts damage on the target.
     *
     * @param target The Creature being attacked
     * @throws LowManaException if mana is less than {@value MANA_COST_PER_SPELL}
     */
    public void castSpell(final Creature target)
            throws LowManaException
    {
        if(mana < MANA_COST_PER_SPELL)
        {
            throw new LowManaException(
                    "The mana cannot be less than " + MANA_COST_PER_SPELL + ".");
        }

        mana -= MANA_COST_PER_SPELL;

        target.takeDamage(SPELL_DAMAGE);
    }


    /**
     * Restores the Elf's mana by a given amount.
     *
     * @param amount The amount of mana to restore
     * @throws IllegalArgumentException if amount is less than {@value MINIMUM_MANA}
     */
    public void restoreMana(final int amount)
    {
        if(amount < MINIMUM_MANA)
        {
            throw new IllegalArgumentException(
                    "Restore amount cannot be less than " + MINIMUM_MANA + ".");
        }

        mana += amount;

        if(mana > MAXIMUM_MANA)
        {
            mana = MAXIMUM_MANA;
        }
    }

    /**
     * Validates the mana value.
     *
     * @param mana The mana value to check
     * @throws IllegalArgumentException if mana is out of range
     * of {@value MINIMUM_MANA} and {@value MAXIMUM_MANA}
     */
    private static void validateMana(final int mana)
    {
        if(mana < MINIMUM_MANA ||
           mana > MAXIMUM_MANA)
        {
            final StringBuilder errorMessages;
            errorMessages = new StringBuilder();

            errorMessages.append("Mana must be between ");
            errorMessages.append(MINIMUM_MANA);
            errorMessages.append(" and ");
            errorMessages.append(MAXIMUM_MANA);
            errorMessages.append(".");

            throw new IllegalArgumentException(
                    errorMessages.toString());
        }
    }
}
