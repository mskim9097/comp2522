package ca.bcit.comp2522.bookstore;

public class Person
        implements Comparable<Person>,
                   Printable,
                   Reversible
{
    private final Date dateOfBirth;
    private final Date dateOfDeath;
    private final Name name;

    public Person(final Name name,
                  final Date dateOfBirth,
                  final Date dateOfDeath)
    {
        validateName(name);
        validateBirthDate(dateOfBirth);
        validateDeathDate(dateOfBirth, dateOfDeath);;

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public final Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public final Date getDateOfDeath()
    {
        return dateOfDeath;
    }

    public final Name getName()
    {
        return name;
    }

    @Override
    public void display()
    {
        System.out.println(toString());
    }

    @Override
    public void backward()
    {
        final StringBuilder reversed;
        reversed = new StringBuilder();

        reversed.append(name.toString());
        System.out.println("Reversed Name: " + reversed.reverse().toString() + "\n");
    }

    @Override
    public int compareTo(final Person that)
    {
        if (that == null)
        {
            throw new IllegalArgumentException("that cannot be null");
        }

        final int result;

        if (this.dateOfBirth.getYear() != that.dateOfBirth.getYear())
        {
            result = that.dateOfBirth.getYear() - this.dateOfBirth.getYear();
        }
        else if (this.dateOfBirth.getMonth() != that.dateOfBirth.getMonth())
        {
            result = that.dateOfBirth.getMonth() - this.dateOfBirth.getMonth();
        }
        else
        {
            result = that.dateOfBirth.getDay() - this.dateOfBirth.getDay();
        }

        return result;
    }


    private static void validateBirthDate(final Date dateOfBirth)
    {
        if (dateOfBirth == null)
        {
            throw new IllegalArgumentException(
                    "birth date cannot be null");
        }
    }

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

    private static void validateName(final Name name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException(
                    "Name cannot be null");
        }
    }

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
