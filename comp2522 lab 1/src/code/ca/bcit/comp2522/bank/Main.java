package ca.bcit.comp2522.bank;

public class Main {

    public static void main(final String[] args) {

        final Name n1;
        final Name n2;
        final Name n3;
        final Name n4;

        n1 = new Name("Albert", "Einstein");
        n2 = new Name("Nelson", "Mandela");
        n3 = new Name("Frida", "Kahlo");
        n4 = new Name("Jackie", "Chan");

        final BankClient c1;
        final BankClient c2;
        final BankClient c3;
        final BankClient c4;

        c1 = new BankClient(
                n1,
                new Date(1879, 3, 14),
                new Date(1955, 4, 18),
                new Date(1900, 1, 1),
                "abc123"
        );
        c2 = new BankClient(
                n2,
                new Date(1918, 7, 18),
                new Date(2013, 12, 5),
                new Date(1994, 5 , 10),
                "654321"
        );
        c3 = new BankClient(
                n3,
                new Date(1907, 7, 6),
                new Date(1954, 7, 13),
                new Date(1940, 1, 1),
                "frd123"
        );
        c4 = new BankClient(
                n4,
                new Date(1954, 4, 7),
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
        b1.withdraw(100, 3141);
        System.out.println(b1.getDetails());
        b1.deposit(1000);
        System.out.println(b1.getBalanceUsd());
    }
}
