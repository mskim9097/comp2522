import java.util.Date;

public class Elf extends Creature
{
    private static final int MINIMUM_MANA = 0;
    private static final int MAXIMUM_MANA = 50;
    private static final int MANA_DECREMENT = 5;
    private static final int CAST_SPELL_DAMAGE = 10;

    private int mana;

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

    /* Method that prints the details of the Elf */
    @Override
    public void getDetails()
    {
        super.getDetails();
        System.out.println("Mana: " + mana);
    }

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
