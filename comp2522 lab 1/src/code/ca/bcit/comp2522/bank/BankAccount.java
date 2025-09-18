package ca.bcit.comp2522.bank;

/**
 * Represents a simple bank account.
 * Firstly, it keeps a reference to the {@link BankClient} who owns the account.
 * Secondly, it stores the account balance in USD.
 * Thirdly, it protects the account with a personal identification number (PIN).
 * Fourthly, it keeps the account number, which must be 6 to 7 digits long.
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

    private static final int MAX_ACCOUNT_NUMBER_LENGTH = 7;
    private static final int MIN_ACCOUNT_NUMBER_LENGTH = 6;
    private static final int ONE = 1;
    private final BankClient client;
    private double balanceUsd;
    private final int pin;
    private final String accountNumber;
    private final Date accountOpened;
    private final Date accountClosed;

    /**
     * Creating a constructor
     *
     * @param client the BankClient associated with this account.
     * @param balanceUsd the initial balance of the account in USD.
     * @param pin the 4-digit Personal Information Number (PIN) for an account.
     * @param accountNumber client's bank account number.
     * @param accountOpened account opened date of the account.
     * @param accountClosed account closed date of the account.
     */
    public BankAccount(final BankClient client,
                       double balanceUsd,
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

        this.client = client;
        this.balanceUsd = balanceUsd;
        this.pin = pin;
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
     *Creating a getter to get the balance of the account in USD.
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
    public void withdraw(final double amountUsd)
    {
        if(amountUsd > 0 && balanceUsd >= amountUsd) {
            balanceUsd -= amountUsd;
        }
    }

    /**
     * Withdraws money from the account if the given PIN matches.
     * Firstly, it checks whether the provided PIN matches the account's PIN.
     * Secondly, if the PIN is correct, it calls {@link #withdraw(double)}
     * to subtract the amount from the balance (only if the amount is valid
     * and there are enough funds).
     * If the PIN does not match, no money is withdrawn.
     *
     * @param amountUsd   the amount of money (in USD) to withdraw
     * @param pinToMatch  the PIN provided by the user, checked against the account's PIN
     */
    public void withdraw(final double amountUsd,
                         final int pinToMatch)
    {
        if (isMatch(pinToMatch))
        {
            withdraw(amountUsd);
        }
    }

    /**
     * Deposits money into the account.
     * Firstly, it checks that the given amount is greater than zero.
     * Secondly, if the amount is valid, it is added to the account balance.
     *
     * @param amountUsd the amount of money (in USD) to deposit
     */
    public void deposit(final double amountUsd)
    {
        if (amountUsd > 0.0) {
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
        return client.getName().getFullName() +
                " had $" +
                balanceUsd +
                " USD in account #" +
                accountNumber +
                " which he opened on " +
                accountOpened.getDayOfTheWeek() +
                " " +
                Date.MONTH_NAMES[accountOpened.getMonth() - ONE] +
                " " +
                accountOpened.getDay() +
                ", " +
                accountOpened.getYear() +
                (accountClosed == null ?
                        " and is still open." :
                        " and closed " +
                                accountClosed.getDayOfTheWeek() +
                                " " +
                                Date.MONTH_NAMES[accountClosed.getMonth() - ONE] +
                                " " +
                                accountClosed.getDay() +
                                ", " +
                                accountClosed.getYear() +
                                ".");
    }

    /* Method that checks whether the entered PIN matches the account's PIN. */
    private boolean isMatch(final int enteredPin)
    {
        return enteredPin == pin;
    }

    /* Method that validates the client. */
    private static void validateClient(final BankClient client)
    {
        if (client == null) {
            throw new IllegalArgumentException("Invalid client");
        }
    }

    /* Method that validates the balance. */
    private static void validateBalanceUsd(final double balanceUsd)
    {
        if (balanceUsd < 0) {
            throw new IllegalArgumentException("Invalid balance");
        }
    }

    /* method that validates the PIN. */
    private static void validatePin(final int pin)
    {
        if (pin < 0) {
            throw new IllegalArgumentException("Invalid pin");
        }
    }

    /* method that validates the account number. */
    private static void validateAccountNumber(final String accountNumber)
    {
        if (accountNumber == null ||
                accountNumber.length() < MIN_ACCOUNT_NUMBER_LENGTH ||
                accountNumber.length() > MAX_ACCOUNT_NUMBER_LENGTH) {
            throw new IllegalArgumentException("Invalid account number");
        }
    }

    /* method that validates the account opened date. */
    private static void validateAccountOpened(final Date accountOpened)
    {
        if (accountOpened == null) {
            throw new IllegalArgumentException("Invalid account");
        }
    }

}
