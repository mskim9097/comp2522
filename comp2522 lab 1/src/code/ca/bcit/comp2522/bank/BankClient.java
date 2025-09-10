package ca.bcit.comp2522.bank;

public class BankClient {

    private final Name name;
    private final Date birthDate;
    private final Date deathDate;
    private final Date signupDate;
    private final String clientID;

    public BankClient(final Name name,
                      final Date birthDate,
                      final Date deathDate,
                      final Date signupDate,
                      final String clientID) {
        if (name == null
            || birthDate == null
            || signupDate == null
            || clientID == null
            || clientID.length() < 6
            || clientID.length() > 7) {
            throw new IllegalArgumentException("Invalid client");
        }
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.signupDate = signupDate;
        this.clientID = clientID;
    }
    public Name getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public String getClientID() {
        return clientID;
    }

    public String getDetails() {
        if (isAlive()) {
            return name.getFullName()
                    + " client #"
                    + clientID
                    + " (alive) joined the bank on "
                    + signupDate.getYyyyMmDd()
                    + "!";
        } else {
            return name.getFullName()
                    + " (died "
                    + deathDate.getYyyyMmDd()
                    + ") was born on "
                    + birthDate.getYyyyMmDd()
                    + "!";
        }
    }

    public boolean isAlive() {
        return deathDate == null;
    }


}
