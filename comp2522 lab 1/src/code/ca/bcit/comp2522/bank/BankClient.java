package ca.bcit.comp2522.bank;

/**
 * Represents a bank client and their personal details.
 * Firstly, it keeps the client's name.
 * Secondly, it stores the birthdate.
 * Thirdly, it may hold the death date (if the client has passed away).
 * Fourthly, it records the signup date when the client joined the bank.
 * Finally, it saves the unique client ID, which must be between valid client id's length.
 *
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 * @version 1.0
 */
public class BankClient
{
    private static final int MAX_CLIENT_ID_LENGTH = 19;
    private static final int MIN_CLIENT_ID_LENGTH = 5;

    private final Name   name;
    private final Date   birthDate;
    private final Date   deathDate;
    private final Date   signupDate;
    private final String clientID;

    /**
     * Creates a new BankClient with the given personal information.
     *
     * @param name       the full name of the client
     * @param birthDate  the client's date of birth
     * @param deathDate  the client's date of death (null if still alive)
     * @param signupDate the date when the client signed up
     * @param clientID   a unique ID that identifies the client
     */
    public BankClient(final Name name,
                      final Date birthDate,
                      final Date deathDate,
                      final Date signupDate,
                      final String clientID)
    {
        validateBirthDate(birthDate);
        validateClientID(clientID);

        this.name       = name;
        this.birthDate  = birthDate;
        this.deathDate  = deathDate;
        this.signupDate = signupDate;
        this.clientID   = clientID;
    }

    /**
     * Gets the name of the client.
     *
     * @return name of the client.
     */
    public Name getName()
    {
        return name;
    }

    /**
     * Creating a getter to get the birthDate of the client.
     *
     * @return birthDate of the client.
     */
    public Date getBirthDate()
    {
        return birthDate;
    }

    /**
     * Creating getter to get the deathDate of the client.
     *
     * @return deathDate of the client.
     */
    public Date getDeathDate()
    {
        return deathDate;
    }

    /**
     * Creating getter to get the signupDate of the client.
     *
     * @return signupDate of the client.
     */
    public Date getSignupDate()
    {
        return signupDate;
    }

    /**
     * Creating getter to get the clientID of the client.
     *
     * @return clientID of the client.
     */
    public String getClientID()
    {
        return clientID;
    }

    /**
     * Creating a getter to get the details of the client.
     *
     * @return details of the client.
     */
    public String getDetails()
    {
        final StringBuilder details;
        final String alive;

        if(isAlive())
        {
            alive = "alive";
        }
        else
        {
            alive = "not alive";
        }

        details = new StringBuilder();

        details.append(name.getFullName());
        details.append(" client #");
        details.append(clientID);
        details.append(" (");
        details.append(alive);
        details.append(") joined the bank on ");
        details.append(signupDate.getDayOfTheWeek());
        details.append(", ");
        details.append(Date.getMonthName(signupDate.getMonth()));
        details.append(" ");
        details.append(signupDate.getDay());
        details.append(", ");
        details.append(signupDate.getYear());

        return details.toString();
    }

    /* Method that checks whether the client is still alive. */
    private boolean isAlive()
    {
        return deathDate == null;
    }

    /* Method to validate the birthdate. */
    private static void validateBirthDate(final Date birthDate)
    {
        if (birthDate == null)
        {
            throw new IllegalArgumentException("Invalid birth date");
        }
    }

    /* Method to validate the client ID. */
    private static void validateClientID(final String clientID)
    {
        if (clientID == null ||
            clientID.trim().isBlank() ||
            clientID.length() < MIN_CLIENT_ID_LENGTH ||
            clientID.length() > MAX_CLIENT_ID_LENGTH)
        {
            throw new IllegalArgumentException("Invalid client ID");
        }
    }

}