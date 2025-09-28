package ca.bcit.comp2522.bank;

/**
 * Creating a driver class to test the program(runningName, Date, BankClient, BankAccount class).
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 * @version 1.0
 */
public class Main
{
    /**
     * Main entry point of the program.
     * Firstly, it creates four {@link Name} objects for Albert Einstein,
     * Nelson Mandela, Frida Kahlo, and Jackie Chan.
     * Secondly, it uses those names to create four {@link BankClient}
     * objects with their birthdates, death dates (if any), signup dates,
     * and client IDs.
     * Thirdly, it creates four {@link BankAccount} objects for those clients,
     * giving each account a starting balance, a PIN, and an account number,
     * as well as the open date and (if applicable) close date.
     * Finally, the objects are ready to be used in further program logic.
     *
     * @param args command line arguments (not used in this program)
     */
    public static void main(final String[] args)
    {
        final Name n1;
        final Name n2;
        final Name n3;
        final Name n4;

        n1 = new Name("Albert", "Einstein");
        n2 = new Name("Nelson", "Mandela");
        n3 = new Name("Frida",  "Kahlo");
        n4 = new Name("Jackie", "Chan");

        final BankClient c1;
        final BankClient c2;
        final BankClient c3;
        final BankClient c4;

        c1 = new BankClient(
                n1,
                new Date(1879, 3, 14),
                new Date(1955, 4, 18),
                new Date(1900, 1,  1),
                "abc123"
        );
        c2 = new BankClient(
                n2,
                new Date(1918, 7 , 18),
                new Date(2013, 12,  5),
                new Date(1994, 5 , 10),
                "654321"
        );
        c3 = new BankClient(
                n3,
                new Date(1907, 7,  6),
                new Date(1954, 7, 13),
                new Date(1940, 1,  1),
                "frd123"
        );
        c4 = new BankClient(
                n4,
                new Date(1954, 4 , 7),
                null,
                new Date(1980, 10, 1),
                "chan789"
        );

        final BankAccount b1;
        final BankAccount b2;
        final BankAccount b3;
        final BankAccount b4;

        b1 = new BankAccount(
                c1,
                1000,
                3141,
                c1.getClientID(),
                c1.getSignupDate(),
                new Date(1950, 10, 14)
        );
        b2 = new BankAccount(
                c2,
                2000,
                4664,
                c2.getClientID(),
                c2.getSignupDate(),
                null
        );
        b3 = new BankAccount(
                c3,
                500,
                1907,
                c3.getClientID(),
                c3.getSignupDate(),
                new Date(1954, 7, 13)
        );
        b4 = new BankAccount(
                c4,
                3000,
                1954,
                c4.getClientID(),
                c4.getSignupDate(),
                null
        );


        System.out.println(n1.getInitials());
        System.out.println(n1.getFullName());
        System.out.println(n1.getReverseName());
        System.out.println(c1.getDetails());
        System.out.println(b1.getDetails());
        b1.withdrawUsd(100);
        System.out.println(b1.getDetails() + "\n");

        System.out.println(n2.getInitials());
        System.out.println(n2.getFullName());
        System.out.println(n2.getReverseName());
        System.out.println(c2.getDetails());
        System.out.println(b2.getDetails());
        b2.withdrawUsd(200, 4664);
        System.out.println(b2.getDetails() + "\n");

        System.out.println(n3.getInitials());
        System.out.println(n3.getFullName());
        System.out.println(n3.getReverseName());
        System.out.println(c3.getDetails());
        System.out.println(b3.getDetails());
        b3.withdrawUsd(50, 1907);
        System.out.println(b3.getDetails() + "\n");

        System.out.println(n4.getInitials());
        System.out.println(n4.getFullName());
        System.out.println(n4.getReverseName());
        System.out.println(c4.getDetails());
        System.out.println(b4.getDetails());
        b4.withdrawUsd(500);
        System.out.println(b4.getDetails());
    }
}
