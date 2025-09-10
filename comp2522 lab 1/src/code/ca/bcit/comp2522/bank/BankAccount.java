package ca.bcit.comp2522.bank;

public class BankAccount {

    private final BankClient client;
    private double balanceUsd;
    private final int pin;
    private final String accountNumber;
    private final Date accountOpened;
    private final Date accountClosed;

    public BankAccount(final BankClient client,
                       double balanceUsd,
                       final int pin,
                       final String accountNumber,
                       final Date accountOpened,
                       final Date accountClosed) {
        if (client == null
            || balanceUsd < 0
            || pin < 0
            || accountNumber == null
            || accountNumber.length() < 6
            || accountNumber.length() > 7
            || accountOpened == null) {
                throw new IllegalArgumentException("Invalid account");
            }
        this.client = client;
        this.balanceUsd = balanceUsd;
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
    }

    public BankClient getClient() {
        return client;
    }

    public double getBalanceUsd() {
        return balanceUsd;
    }

    public int getPin() {
        return pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Date getAccountOpened() {
        return accountOpened;
    }

    public Date getAccountClosed() {
        return accountClosed;
    }

    public int withdraw(final double amountUsd) {

        if(amountUsd > 0 && balanceUsd >= amountUsd) {
            balanceUsd -= amountUsd;
            return 1;
        } else {
            return 0;
        }
    }

    public int withdraw(final double amountUsd, final int pinToMatch) {
        if (amountUsd > 0 && isMatch(pinToMatch)) {
            if(balanceUsd >= amountUsd) {
                balanceUsd -= amountUsd;
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public void deposit(final double amountUsd) {
        if (amountUsd > 0) {
            balanceUsd += amountUsd;
        }
    }

    public boolean isMatch(final int enteredPin) {
        return enteredPin == pin;
    }

    public String getDetails() {
        return client.getName().getFullName()
                + " had $"
                + balanceUsd
                + " USD in account #"
                + accountNumber
                + " which he opened on "
                + accountOpened.getYyyyMmDd()
                + (accountClosed == null ? "."
                : " and closed "
                + accountClosed.getYyyyMmDd()
                + ".");
    }

}
