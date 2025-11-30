package ca.bcit.comp2522.project;

import ca.bcit.comp2522.project.mygame.MyGame;
import ca.bcit.comp2522.project.numbergame.NumberGame;
import ca.bcit.comp2522.project.wordgame.WordGame;
import ca.bcit.comp2522.project.wordgame.World;
import javafx.application.Platform;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * Main class.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public class Main
{
    private static final int  LATCH_COUNT     = 1;
    private static final char NUMBER_GAME_KEY = 'N';
    private static final char MY_GAME_KEY     = 'M';

    private static boolean fxStarted = false;

    /**
     * Drives the program.
     * @param args command line arguments
     */
    public static void main(final String[] args)
    {
        final Path wordGameDir;

        wordGameDir = Paths.get("src", "resources", "wordgame");

        System.out.println("\n===Welcome to the game!===");
        final Scanner scan;

        scan = new Scanner(System.in);

        while (true)
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
                    final World world;
                    final WordGame game;

                    world = new World(wordGameDir);
                    game  = new WordGame(world, scan);

                    game.play();
                    break;

                case "N":
                    launchGame(NUMBER_GAME_KEY);
                    break;

                case "M":
                    launchGame(MY_GAME_KEY);
                    break;

                case "Q":
                    System.out.println("Goodbye!");
                    scan.close();

                    if (fxStarted)
                    {
                        Platform.exit();
                    }
                    return;

                default:
                    System.out.println("Invalid choice.\n");
            }
        }
    }

    /**
     * Launches a JavaFX game window (NumberGame or MyGame) and
     * blocks the main thread until it closes.
     * NOTE: This method uses CountDownLatch and
     * Platform.setImplicitExit(false)
     * (implemented with AI assistance) to allow
     * the JavaFX application to be
     * re-launched multiple times without terminating the JVM.
     */
    private static void launchGame(final char gameKey)
    {
        final CountDownLatch latch;

        latch = new CountDownLatch(LATCH_COUNT);

        if (!fxStarted)
        {
            fxStarted = true;
            Platform.setImplicitExit(false);

            Platform.startup(() -> openSelectedGame(gameKey, latch));
        }
        else
        {
            Platform.runLater(() -> openSelectedGame(gameKey, latch));
        }

        try
        {
            latch.await();
        }
        catch (InterruptedException e)
        {
            System.out.println(
                    "Failed to wait for the game window to close.");
        }
    }

    /**
     * Creates and opens the selected game window.
     */
    private static void openSelectedGame(final char           gameKey,
                                         final CountDownLatch latch)
    {
        if (gameKey == NUMBER_GAME_KEY)
        {
            final NumberGame numberGame;
            numberGame = new NumberGame();
            numberGame.openGameWindow(latch);
        }
        else if (gameKey == MY_GAME_KEY)
        {
            final MyGame myGame;
            myGame = new MyGame();
            myGame.openGameWindow(latch);
        }
        else
        {
            System.out.println("Unknown game key: " + gameKey);
            latch.countDown();
        }
    }
}