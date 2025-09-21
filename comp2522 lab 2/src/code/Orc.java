import java.util.Date;

public class Orc extends Creature
{
    private static final int MINIMUM_RAGE = 0;
    private static final int MAXIMUM_RAGE = 30;
    private static final int RAGE_INCREMENT = 5;
    private static final int BERSERK_DAMAGE = 15;
    private static final int MINIMUM_BERSERK_RAGE = 5;
    private static final int DOUBLE_DAMAGE_RAGE = 20;
    private static final int DOUBLE_DAMAGE = 2;

    private int rage;

    public Orc(final String name,
               final Date dateOfBirth,
               int health,
               int rage) {
        super(name,
                dateOfBirth,
                health);
        validateRage(rage);

        this.rage = rage;
    }

    @Override
    public void getDetails()
    {
        super.getDetails();
        System.out.println("Rage: " + rage);
    }

    public void berserk(final Creature target)
            throws LowRageException
    {
        if(rage < MINIMUM_BERSERK_RAGE)
        {
            throw new LowRageException(
                    "Not enough rage to berserk!");
        }
        rage += RAGE_INCREMENT;

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

    private static void validateRage(final int rage)
    {
        if(rage < MINIMUM_RAGE ||
                rage > MAXIMUM_RAGE)
        {
            throw new IllegalArgumentException(
                    "Rage must be between 0 and 30");
        }
    }
}
