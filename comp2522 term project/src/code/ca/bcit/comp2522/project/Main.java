package ca.bcit.comp2522.project;

import ca.bcit.comp2522.project.numbergame.NumberGame;
import ca.bcit.comp2522.project.wordgame.WordGame;
import ca.bcit.comp2522.project.wordgame.World;
import javafx.application.Application;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Main class.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public class Main
{
    /**
     * Drives the program.
     * @param args command line arguments
     */
    public static void main(final String[] args)
    {
        Path wordGameDir = Paths.get("src", "resources", "wordgame");

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
                    World test = new World(wordGameDir);
                    break;
                case "N":
                    Application.launch(NumberGame.class, args);
                    return;
                case "M":
                    System.out.println("My game.");
                    break;
                case "Q":
                    System.out.println("Goodbye!");
                    scan.close();
                    return;
                default:
                    System.out.println("Invalid choice.\n");
            }
        }

    }
}
