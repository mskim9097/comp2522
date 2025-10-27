public interface File
{

    default void save(final String fileName)
    {
        System.out.println("Saved data to file " + fileName);
    }
    void open();
}

public interface Bank
{
    default void save(final String accountNumber)
    {
        System.out.println("saved money to account number " + accountNumber);
    }
    void deposit();
}

public class OnlineBankAccount implements File, Bank
{
    private final String fileName;
    private final String accountNumber;

    public OnlineBankAccount(final String fileName,
                             final String accountNumber)
    {
        this.fileName = fileName;
        this.accountNumber = accountNumber;
    }

    @Override
    public void open()
    {
        System.out.println("Opening file " + fileName);
    }

    @Override
    public void deposit()
    {
        System.out.println("Depositing money to account number " + accountNumber);
    }

    @Override
    public void save(final String fileName)
    {
        System.out.println("saved money to account number " + accountNumber);
    }
}