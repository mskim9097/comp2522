package ca.bcit.comp2522.project;

import java.util.Scanner;

public class Main
{
    public static void main(final String[] args)
    {
        System.out.println("\n===Welcome to the game!===");
        final Scanner scan;

        scan = new Scanner(System.in);

        while(true)
        {
            System.out.println("Press W to play the Word game.");
            System.out.println("Press N to play the Number game.");
            System.out.println("Press M to play the My game.");
            System.out.println("Press Q to quit.");
            System.out.print("Enter your choice:");

            final String input;
            input = scan.nextLine().trim().toUpperCase();

            switch (input)
            {
                case "W":
                    System.out.println("Word game.");
                    break;
                case "N":
                    System.out.println("Number game.");
                    break;
                case "M":
                    System.out.println("My game.");
                    break;
                case "Q":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.\n");
            }

        }
    }
}
