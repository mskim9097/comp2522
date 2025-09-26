import java.util.Date;

/**
 * The Elf class represents a magical creature that extends
 * the {@link Creature} class. In addition to the inherited
 * attributes (name, date of birth, and health), an Elf has
 * a mana value used to cast spells.
 * Elves can:
 * - Cast spells that consume mana and damage targets
 * - Restore mana (capped at 50)
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
    private static final int MINIMUM_MANA = 0;
    private static final int MAXIMUM_MANA = 50;
    private static final int MANA_DECREMENT = 5;
    private static final int CAST_SPELL_DAMAGE = 10;

    private int mana;

    /**
     * Constructor for the Elf class.
     * Initializes all attributes and validates mana.
     *
     * @param name The name of the Elf
     * @param dateOfBirth The birth date of the Elf
     * @param health The health value of the Elf
     * @param mana The initial mana value of the Elf
     * @throws IllegalArgumentException if mana is invalid
     */
    public Elf(final String name,
               final Date dateOfBirth,
               int health,
               int mana)
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
     * @throws LowManaException if mana is too low to cast a spell
     */
    public void castSpell(final Creature target)
            throws LowManaException
    {
        if(mana < MANA_DECREMENT)
        {
            throw new LowManaException(
                    "Not enough mana to cast spell");
        }
        mana -= MANA_DECREMENT;
        target.takeDamage(CAST_SPELL_DAMAGE);
    }


    /**
     * Restores the Elf's mana by a given amount.
     * Mana cannot go below 0 or above 50.
     *
     * @param amount The amount of mana to restore
     * @throws IllegalArgumentException if amount is negative
     */
    public void restoreMana(final int amount)
    {
        if(amount < MINIMUM_MANA)
        {
            throw new IllegalArgumentException(
                    "Mana cannot be negative.");
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
     * @throws IllegalArgumentException if mana is out of range (0–50)
     */
    private static void validateMana(final int mana)
    {
        if(mana < MINIMUM_MANA ||
                mana > MAXIMUM_MANA)
        {
            throw new IllegalArgumentException(
                    "Mana must be between 0 and 50.");
        }
    }
}
