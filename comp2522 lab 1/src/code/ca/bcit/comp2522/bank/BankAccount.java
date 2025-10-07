package ca.bcit.comp2522.bank;

/**
 * Represents a simple bank account.
 * Firstly, it keeps a reference to the {@link BankClient} who owns the account.
 * Secondly, it stores the account balance in USD.
 * Thirdly, it protects the account with a personal identification number (PIN).
 * Fourthly, it keeps the account number, which must be between valid account number's length.
 * Fifthly, it records the date when the account was opened.
 * Finally, it may hold the date when the account was closed
 * (or remain null if the account is still active).
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 * @version 1.0
 */
public class BankAccount
{
    private static final int MAXIMUM_ACCOUNT_NUMBER_LENGTH = 7;
    private static final int MINIMUM_ACCOUNT_NUMBER_LENGTH = 6;

    private static final int    NO_BALANCE = 0;
    private static final int    ZERO_PIN   = 0;
    private static final double NO_DEPOSIT = 0.0;

    private final BankClient client;
    private double           balanceUsd;
    private final int        pin;
    private final String     accountNumber;
    private final Date       accountOpened;
    private final Date       accountClosed;

    /**
     * Creating a constructor
     *
     * @param client the BankClient associated with this account.
     * @param balanceUsd the initial balance of the account in USD.
     * @param pin the Personal Information Number (PIN) for an account.
     * @param accountNumber client's bank account number.
     * @param accountOpened account opened date of the account.
     * @param accountClosed account closed date of the account.
     */
    public BankAccount(final BankClient client,
                       final double balanceUsd,
                       final int pin,
                       final String accountNumber,
                       final Date accountOpened,
                       final Date accountClosed)
    {
        validateClient(client);
        validateBalanceUsd(balanceUsd);
        validatePin(pin);
        validateAccountNumber(accountNumber);
        validateAccountOpened(accountOpened);

        this.client        = client;
        this.balanceUsd    = balanceUsd;
        this.pin           = pin;
        this.accountNumber = accountNumber;
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
    }

    /**
     * Creating getter to get the client of the account.
     *
     * @return client of the account.
     */
    public BankClient getClient()
    {
        return client;
    }

    /**
     * Creating a getter to get the balance of the account in USD.
     *
     * @return balance of the account in USD.
     */
    public double getBalanceUsd()
    {
        return balanceUsd;
    }

    /**
     * Creating getter to get the pin of the account.
     *
     * @return pin of the account.
     */
    public int getPin()
    {
        return pin;
    }

    /**
     * Creating getter to get the account number of the account.
     *
     * @return account number of the account.
     */
    public String getAccountNumber()
    {
        return accountNumber;
    }

    /**
     * Creating getter to get the account's opened date of the account.
     *
     * @return account opened date of the account.
     */
    public Date getAccountOpened()
    {
        return accountOpened;
    }

    /**
     * Creating getter to get the account's closed date of the account.
     *
     * @return account closed date of the account.
     */
    public Date getAccountClosed()
    {
        return accountClosed;
    }

    /**
     * Withdraws money from the account if the amount is valid.
     * Firstly, it checks that the given amount is greater than zero.
     * Secondly, it checks that the account has enough balances.
     * If both conditions are true, the amount is subtracted from the balance.
     *
     * @param amountUsd the amount of money (in USD) to withdraw
     */
    public void withdrawUsd(final double amountUsd)
    {
        if(amountUsd > NO_BALANCE && balanceUsd >= amountUsd)
        {
            balanceUsd -= amountUsd;
        }
    }

    /**
     * Withdraws money from the account if the given PIN matches.
     * Firstly, it checks whether the provided PIN matches the account's PIN.
     * Secondly, if the PIN is correct, it calls {@link #withdrawUsd(double)}
     * to subtract the amount from the balance (only if the amount is valid
     * and there are enough funds).
     * If the PIN does not match, no money is withdrawn.
     *
     * @param amountUsd   the amount of money (in USD) to withdraw
     * @param pinToMatch  the PIN provided by the user, checked against the account's PIN
     */
    public void withdrawUsd(final double amountUsd,
                            final int    pinToMatch)
    {
        if (isMatch(pinToMatch))
        {
            withdrawUsd(amountUsd);
        }
    }

    /**
     * Deposits money into the account.
     * Firstly, it checks that the given amount is greater than zero.
     * Secondly, if the amount is valid, it is added to the account balance.
     *
     * @param amountUsd the amount of money (in USD) to deposit
     */
    public void depositUsd(final double amountUsd)
    {
        if (amountUsd > NO_DEPOSIT)
        {
            balanceUsd += amountUsd;
        }
    }

    /**
     * Creating a getter to get the details of the account.
     *
     * @return details of the account.
     */
    public String getDetails()
    {
        final StringBuilder details;
        details = new StringBuilder();

        details.append(client.getName().getFullName());
        details.append(" had $");
        details.append(balanceUsd);
        details.append(" USD in account #");
        details.append(accountNumber);
        details.append(" which he opened on ");
        details.append(accountOpened.getDayOfTheWeek());
        details.append(" ");
        details.append(Date.getMonthName(getAccountOpened().getMonth()));
        details.append(" ");
        details.append(accountOpened.getDay());
        details.append(", ");
        details.append(accountOpened.getYear());

        if (accountClosed != null)
        {
            details.append(" and closed ");
            details.append(accountClosed.getDayOfTheWeek());
            details.append(" ");
            details.append(Date.getMonthName(getAccountClosed().getMonth()));
            details.append(" ");
            details.append(accountClosed.getDay());
            details.append(", ");
            details.append(accountClosed.getYear());
            details.append(".");
        }
        else
        {
            details.append(" and is still open.");
        }

        return details.toString();
    }

    /* Method that checks whether the entered PIN matches the account's PIN. */
    private boolean isMatch(final int enteredPin)
    {
        return enteredPin == pin;
    }

    /* Method that validates the client. */
    private static void validateClient(final BankClient client)
    {
        if (client == null)
        {
            throw new IllegalArgumentException("Invalid client");
        }
    }

    /* Method that validates the balance. */
    private static void validateBalanceUsd(final double balanceUsd)
    {
        if (balanceUsd < NO_BALANCE)
        {
            throw new IllegalArgumentException("Invalid balance");
        }
    }

    /* method that validates the PIN. */
    private static void validatePin(final int pin)
    {
        if (pin < ZERO_PIN)
        {
            throw new IllegalArgumentException("Invalid pin");
        }
    }

    /* method that validates the account number. */
    private static void validateAccountNumber(final String accountNumber)
    {
        if (accountNumber == null ||
            accountNumber.length() < MINIMUM_ACCOUNT_NUMBER_LENGTH ||
            accountNumber.length() > MAXIMUM_ACCOUNT_NUMBER_LENGTH)
        {
            throw new IllegalArgumentException("Invalid account number");
        }
    }

    /* method that validates the account opened date. */
    private static void validateAccountOpened(final Date accountOpened)
    {
        if (accountOpened == null)
        {
            throw new IllegalArgumentException("Invalid account");
        }
    }
}
