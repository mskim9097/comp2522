package ca.bcit.comp2522.bookstore;

/**
 * Represents a person with a name, date of birth,
 * and optional date of death.
 * This class implements {@link Comparable}, {@link Printable}, and {@link Reversible}
 * interfaces, allowing instances to be compared by birth date, printed, and
 * have their names displayed in reverse order.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class Person
        implements Comparable<Person>,
                   Printable,
                   Reversible
{
    private final Date dateOfBirth;
    private final Date dateOfDeath;
    private final Name name;

    /**
     * Constructs a new {@code Person} with the specified name, date of birth,
     * and date of death.
     *
     * @param name The person's name.
     * @param dateOfBirth The person's date of birth.
     * @param dateOfDeath The person's date of death.
     */
    public Person(final Name name,
                  final Date dateOfBirth,
                  final Date dateOfDeath)
    {
        validateName(name);
        validateBirthDate(dateOfBirth);
        validateDeathDate(dateOfBirth, dateOfDeath);;

        this.name        = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    /**
     * Gets the person's date of birth.
     *
     * @return The person's date of birth.
     */
    public final Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * Gets the person's date of death.
     * @return The person's date of death.
     */
    public final Date getDateOfDeath()
    {
        return dateOfDeath;
    }

    /**
     * Gets the person's name.
     *
     * @return The person's name.
     */
    public final Name getName()
    {
        return name;
    }

    /**
     * Displays the person's information.
     */
    @Override
    public void display()
    {
        System.out.println(toString());
    }


    /**
     * Reverses the person's name.
     */
    @Override
    public void backward()
    {
        final StringBuilder reversed;
        reversed = new StringBuilder();

        reversed.append(name.toString());
        System.out.println("Reversed Name: " +
                           reversed.reverse().toString() +
                           "\n");
    }

    /**
     * Compares this person to another person.
     *
     * @param that The other person.
     * @return The comparison result.
     */
    @Override
    public int compareTo(final Person that)
    {
        if (that == null)
        {
            throw new IllegalArgumentException("that cannot be null");
        }

        final int result;

        if (this.dateOfBirth.getYear() !=
            that.dateOfBirth.getYear())
        {
            result = that.dateOfBirth.getYear() -
                     this.dateOfBirth.getYear();
        }
        else if (this.dateOfBirth.getMonth() !=
                 that.dateOfBirth.getMonth())
        {
            result = that.dateOfBirth.getMonth() -
                     this.dateOfBirth.getMonth();
        }
        else
        {
            result = that.dateOfBirth.getDay() -
                     this.dateOfBirth.getDay();
        }
        return result;
    }


    // The method that validates birthdate.
    private static void validateBirthDate(final Date dateOfBirth)
    {
        if (dateOfBirth == null)
        {
            throw new IllegalArgumentException(
                    "birth date cannot be null");
        }
    }

    // The method that validates deathdate.
    private static void validateDeathDate(final Date dateOfBirth,
                                          final Date dateOfDeath)
    {
        if(dateOfDeath == null)
        {
            return;
        }
        final boolean invalid;

        if(dateOfDeath.getYear() < dateOfBirth.getYear())
        {
           invalid = true;
        }
        else if(dateOfDeath.getYear() == dateOfBirth.getYear() &&
               dateOfDeath.getMonth() < dateOfBirth.getMonth())
        {
           invalid = true;
        }
        else if(dateOfDeath.getYear() == dateOfBirth.getYear() &&
               dateOfDeath.getMonth() == dateOfBirth.getMonth() &&
               dateOfDeath.getDay() < dateOfBirth.getDay())
        {
           invalid = true;
        }
        else
        {
           invalid = false;
        }

        if(invalid)
        {
           throw new IllegalArgumentException(
                   "Date of death cannot be before date of birth");
        }
    }

    // A method that validates name.
    private static void validateName(final Name name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException(
                    "Name cannot be null");
        }
    }

    /**
     * A method that returns person's details.
     *
     * @return A string representation of the person.
     */
    @Override
    public String toString()
    {
        final StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Name: ");
        sb.append(name.toString());
        sb.append("\n");
        sb.append("Date of Birth: ");
        sb.append(dateOfBirth.getYyyyMmDd());
        sb.append("\n");
        if (dateOfDeath != null)
        {
            sb.append("Date of Death: ");
            sb.append(dateOfDeath.getYyyyMmDd());
            sb.append("\n");
        }

        return sb.toString();
    }
}
