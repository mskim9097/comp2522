package ca.bcit.comp2522.project.wordgame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Represents the word game logic.
 * Handles the game loop, question generation, user interaction, and score management.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public class WordGame
{
    private static final int    QUESTIONS_PER_GAME      = 10;
    private static final int    FIRST_ATTEMPT           = 1;
    private static final int    MAX_ATTEMPTS            = 2;
    private static final int    TYPE_CAPITAL_TO_COUNTRY = 0;
    private static final int    TYPE_COUNTRY_TO_CAPITAL = 1;
    private static final int    NUM_QUESTION_TYPES      = 3;
    private static final int    LOOP_START_INDEX        = 0;
    private static final int    QUESTION_NUMBER_OFFSET  = 1;
    private static final int    INITIAL_INT_VALUE       = 0;
    private static final double INITIAL_DOUBLE_VALUE    = 0.0;

    private static final String SCORE_FILE_NAME
            = "src/resources/wordgame/score.txt";

    private final World   world;
    private final Random  random;
    private final Scanner scanner;
    private final Score   sessionScore;

    /**
     * Constructor for WordGame.
     * @param world the loaded world object containing country data
     * @param scan the scanner for user input
     */
    public WordGame(final World world,
                    final Scanner scan)
    {
        validateWorld(world);
        validateScanner(scan);

        this.world        = world;
        this.scanner      = scan;
        this.random       = new Random();
        this.sessionScore = new Score();
    }

    /**
     * Starts the main game loop.
     * Asks the user to play again after each session and handles score processing.
     */
    public void play()
    {
        boolean keepPlaying;
        keepPlaying = true;

        System.out.println("\n--- Starting Word Game ---");

        while (keepPlaying)
        {
            playGameSession();
            sessionScore.incrementGamesPlayed();

            boolean validInput;
            validInput = false;

            while (!validInput)
            {
                System.out.println("\nDo you want to play another game? (Yes/No)");
                final String input;
                input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("No"))
                {
                    processFinalScore();
                    keepPlaying = false;
                    validInput = true;
                }
                else if (input.equalsIgnoreCase("Yes"))
                {
                    validInput = true;
                }
                else
                {
                    System.out.println(
                            "Invalid input. Please enter 'Yes' or 'No'.");
                }
            }
        }
    }

    /**
     * Plays a single game session consisting of {@value #QUESTIONS_PER_GAME} questions.
     * Randomizes the order of countries to ensure unique questions per session.
     */
    private void playGameSession()
    {
        final Map<String, Country> countryMap;
        final List<Country>        countryList;

        countryMap  = world.getCountries();
        countryList = new ArrayList<>(countryMap.values());

        if(countryList.size() < QUESTIONS_PER_GAME)
        {
            System.out.println("Not enough countries loaded to play a game.");
            return;
        }

        Collections.shuffle(countryList, random);

        for(int i = LOOP_START_INDEX; i < QUESTIONS_PER_GAME; i++)
        {
            final Country targetCountry;

            targetCountry = countryList.get(i);
            generateAndAskQuestion(targetCountry,
                    i + QUESTION_NUMBER_OFFSET);
        }
    }

    /**
     * Generates a random question type and initiates the interaction.
     * @param country the target country for the question
     * @param questionNumber the current question number to display
     */
    private void generateAndAskQuestion(final Country country,
                                        final int questionNumber)
    {
        final int questionType;
        final String question;
        final String correctAnswer;
        final String[] facts;
        final String randomFact;
        final String prefix;

        questionType = random.nextInt(NUM_QUESTION_TYPES);
        prefix       = "Q" + questionNumber + ".\n";

        if (questionType == TYPE_CAPITAL_TO_COUNTRY)
        {
            question      = prefix +
                    "What country has the capital city: " +
                    country.getCapitalCityName() + "?";
            correctAnswer = country.getName();
        }
        else if (questionType == TYPE_COUNTRY_TO_CAPITAL)
        {
            question      = prefix +
                    "What is the capital city of: " +
                    country.getName() + "?";
            correctAnswer = country.getCapitalCityName();
        }
        else
        {
            facts         = country.getFacts();
            randomFact    = facts[random.nextInt(facts.length)];
            question      = prefix +
                    "Which country is described by: " + randomFact + "?";
            correctAnswer = country.getName();
        }

        checkAnswer(question, correctAnswer);
    }

    /**
     * Interact with the user to check their answer.
     * Updates the score based on the number of attempts used.
     * @param question the formatted question string
     * @param correctAnswer the correct answer string
     */
    private void checkAnswer(final String question,
                             final String correctAnswer)
    {
        System.out.println(question);

        for (int attempt = FIRST_ATTEMPT; attempt <= MAX_ATTEMPTS; attempt++)
        {
            System.out.print(
                    "Enter guess (" + attempt +
                            "/" + MAX_ATTEMPTS + "): ");

            final String userGuess;
            userGuess = scanner.nextLine().trim();

            if(userGuess.equalsIgnoreCase(correctAnswer))
            {
                System.out.println("CORRECT!");

                if (attempt == FIRST_ATTEMPT)
                {
                    sessionScore.incrementCorrectFirstAttempt();
                }
                else
                {
                    sessionScore.incrementCorrectSecondAttempt();
                }
                return;
            }
            else
            {
                if(attempt < MAX_ATTEMPTS)
                {
                    System.out.println("INCORRECT! Try again.");
                }
                else
                {
                    System.out.println(
                            "INCORRECT! The correct answer was: " +
                                    correctAnswer);
                    sessionScore.incrementIncorrectTwoAttempts();
                }
            }
        }
    }

    /**
     * Processes the final score when the user quits.
     * Loads history, compares for high score, prints a report, and saves to file.
     */
    private void processFinalScore()
    {
        try
        {
            final List<Score>   history;
            final Score         highScore;
            final StringBuilder sb;

            history = Score.readScoresFromFile(SCORE_FILE_NAME);

            if (history.isEmpty())
            {
                highScore = null;
            }
            else
            {
                highScore = Collections.max(history);
            }

            System.out.println("\n" + sessionScore.toString());

            sb = new StringBuilder();

            if (highScore == null ||
                    sessionScore.compareTo(highScore) > INITIAL_INT_VALUE)
            {
                final double prevMax;
                prevMax = (highScore == null) ? INITIAL_DOUBLE_VALUE : highScore.getAverageScore();

                sb.append("CONGRATULATIONS! You are the new high score with an average of ");
                sb.append(String.format("%.2f", sessionScore.getAverageScore()));
                sb.append(" points per game;\n");
                sb.append("the previous record was ");
                sb.append(String.format("%.2f", prevMax));
                sb.append(" points per game.\n");
            }
            else
            {
                sb.append("You did not beat the high score of ");
                sb.append(String.format("%.2f", highScore.getAverageScore()));
                sb.append(" points per game from ");
                sb.append(highScore.getFormattedDate());
                sb.append(".\n");
            }
            System.out.println(sb.toString());

            Score.appendScoreToFile(sessionScore, SCORE_FILE_NAME);
        }
        catch (final IOException e)
        {
            System.out.println("Error processing scores: " + e.getMessage());
        }
    }

    /**
     * Validates the world object.
     * @param world the world to validate
     */
    private static void validateWorld(final World world)
    {
        if (world == null)
        {
            throw new IllegalArgumentException(
                    "World cannot be null.");
        }
    }

    /**
     * Validates the scanner object.
     * @param scan the scanner to validate
     */
    private static void validateScanner(final Scanner scan)
    {
        if (scan == null)
        {
            throw new IllegalArgumentException(
                    "Scanner cannot be null.");
        }
    }
}