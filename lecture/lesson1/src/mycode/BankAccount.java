class BankAccount
{
    private static final double PI = 3.14;

    static
    {
        System.out.println("1. class is loaded");
    }

    // instance
    {
        System.out.println("2. object constructed");
    }

    BankAccount()
    {
        System.out.println("3. constructor executed");
    }

    public static void main(final String[] args)
    {
        final BankAccount b1;
        final BankAccount b2;

        b1 = new BankAccount();
        b2 = new BankAccount();

    }
}
