import java.util.Calendar;
import java.util.Date;

public class Creature
{
    private static final int MINIMUM_HEALTH = 1;
    private static final int MAXIMUM_HEALTH = 100;
    private static final int DEAD_HEALTH = 0;
    private static final int NO_DAMAGE = 0;
    private static final int NO_HEALING = 0;


    /* The name of the creature */
    private final String name;

    /* The birthDate the creature */
    private final Date dateOfBirth;

    /* The health of the creature */
    private int health;

    /**
     * Constructor for the Creature class.
     *
     * @param name The name of the creature
     * @param dateOfBirth The birthDate of the creature
     * @param health The health of the creature
     */
    public Creature(final String name,
                    final Date dateOfBirth,
                    int health)
    {
        validateName(name);
        validateDateOfBirth(dateOfBirth);
        validateHealth(health);

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.health = health;
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
     * Method that takes damage from the creature.
     * @param damage The amount of damage to take
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
     * Method that heals the creature.
     * @param healAmount The amount of health to heal
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
     * Method that calculates the age of the creature.
     * @return The age of the creature.
     */
    public int getAgeYears()
    {
        final Calendar now = Calendar.getInstance();
        final Calendar birth = Calendar.getInstance();
        birth.setTime(dateOfBirth);

        int age = now.get(Calendar.YEAR) -
                birth.get(Calendar.YEAR);

        // if birthdate is in the future, subtract 1
        if(now.get(Calendar.DAY_OF_YEAR) <
                birth.get(Calendar.DAY_OF_YEAR))
        {
            age--;
        }
        return age;
    }

    /**
     * Method that prints the details of the creature.
     */
    public void getDetails()
    {
        System.out.println("Name: " +
                name +
                "\nDate Of Birth: " +
                dateOfBirth +
                "\nAge" +
                getAgeYears() +
                "\nHealth: " +
                health);
    }

    /* Methods that validate the input name. */
    private static void validateName(final String name)
    {
        if (name == null ||
                name.trim().isEmpty())
        {
            throw new IllegalArgumentException(
                    "Name cannot be null or empty.");
        }
    }

    /* Methods that validate the input date of birth. */
    private static void validateDateOfBirth(final Date dateOfBirth)
    {
        final Date now;

        now = new Date();
        // can be deleted
        if (dateOfBirth == null
                || dateOfBirth.after(now))
        {
            throw new IllegalArgumentException(
                    "Invalid date of birth.");
        }


//        final Calendar today = Calendar.getInstance();
//        final Calendar birthDateCalendar = Calendar.getInstance();
//        birthDateCalendar.setTime(dateOfBirth);
//
//        final int birthYear = birthDateCalendar.get(Calendar.YEAR);
//        final int birthMonth = birthDateCalendar.get(Calendar.MONTH);
//        final int birthDay = birthDateCalendar.get(Calendar.DAY_OF_MONTH);
//
//        final int todayYear = today.get(Calendar.YEAR);
//        final int todayMonth = today.get(Calendar.MONTH);
//        final int todayDay = today.get(Calendar.DAY_OF_MONTH);
//
//        if (birthYear > todayYear ||
//                (birthYear == todayYear &&
//                        birthMonth > todayMonth) ||
//                (birthYear == todayYear &&
//                        birthMonth == todayMonth &&
//                        birthDay > todayDay))
//        {
//            throw new IllegalArgumentException(
//                    "Date of birth cannot be in the future.");
//        }

    }

    /* Methods that validate the input health. */
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
