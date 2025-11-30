package ca.bcit.comp2522.project.wordgame;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents the score statistics for a game session.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public class Score implements Comparable<Score>
{
    private static final int    INITIAL_INT_VALUE      = 0;
    private static final int    NON_PLAYED_GAME_COUNT  = 0;
    private static final double NO_AVERAGE             = 0.0;
    private static final int    POINTS_FIRST_ATTEMPT   = 2;
    private static final int    POINTS_SECOND_ATTEMPT  = 1;
    private static final String DATE_FORMAT_PATTERN    = "yyyy-MM-dd HH:mm:ss";
    private static final int    EMPTY_SCORE            = 0;

    private static final String LABEL_DATE_TIME          = "Date and Time: ";
    private static final String LABEL_GAMES_PLAYED       = "Games Played: ";
    private static final String LABEL_CORRECT_FIRST      = "Correct First Attempts: ";
    private static final String LABEL_CORRECT_SECOND     = "Correct Second Attempts: ";
    private static final String LABEL_INCORRECT_ATTEMPTS = "Incorrect Attempts: ";

    private final LocalDateTime dateTimePlayed;
    private       int           numGamesPlayed;
    private       int           numCorrectFirstAttempt;
    private       int           numCorrectSecondAttempt;
    private       int           numIncorrectTwoAttempts;

    /**
     * Default constructor for new game sessions.
     * Initializes with current time and {@value #INITIAL_INT_VALUE} for all other fields.
     */
    public Score()
    {
        this(LocalDateTime.now(),
                INITIAL_INT_VALUE,
                INITIAL_INT_VALUE,
                INITIAL_INT_VALUE,
                INITIAL_INT_VALUE);
    }

    /**
     * Full constructor for loading data or testing.
     * @param dateTimePlayed date and time of the game session
     * @param numGamesPlayed number of games played
     * @param numCorrectFirstAttempt number of correct first attempts
     * @param numCorrectSecondAttempt number of correct second attempts
     * @param numIncorrectTwoAttempts number of incorrect two attempts
     */
    public Score(final LocalDateTime dateTimePlayed,
                 final int           numGamesPlayed,
                 final int           numCorrectFirstAttempt,
                 final int           numCorrectSecondAttempt,
                 final int           numIncorrectTwoAttempts)
    {
        this.dateTimePlayed          = dateTimePlayed;
        this.numGamesPlayed          = numGamesPlayed;
        this.numCorrectFirstAttempt  = numCorrectFirstAttempt;
        this.numCorrectSecondAttempt = numCorrectSecondAttempt;
        this.numIncorrectTwoAttempts = numIncorrectTwoAttempts;
    }

    /**
     * Increments the number of games played.
     */
    public void incrementGamesPlayed()
    {
        this.numGamesPlayed++;
    }

    /**
     * Increments the number of correct first attempts.
     */
    public void incrementCorrectFirstAttempt()
    {
        this.numCorrectFirstAttempt++;
    }

    /**
     * Increments the number of correct second attempts.
     */
    public void incrementCorrectSecondAttempt()
    {
        this.numCorrectSecondAttempt++;
    }

    /**
     * Increments the number of incorrect two attempts.
     */
    public void incrementIncorrectTwoAttempts()
    {
        this.numIncorrectTwoAttempts++;
    }

    /**
     * Calculates the score for the game session.
     * @return the score
     */
    public int getScore()
    {
        return (numCorrectFirstAttempt * POINTS_FIRST_ATTEMPT) +
               (numCorrectSecondAttempt * POINTS_SECOND_ATTEMPT);
    }

    /**
     * Calculates the average score for the game session.
     * @return the average score
     */
    public double getAverageScore()
    {
        if (numGamesPlayed == NON_PLAYED_GAME_COUNT)
        {
            return NO_AVERAGE;
        }

        return (double) getScore() / numGamesPlayed;
    }

    /**
     * Returns the formatted date string.
     * Used for displaying high-score date in WordGame.
     * @return formatted date string (yyyy-MM-dd HH:mm:ss)
     */
    public String getFormattedDate()
    {
        final DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);
        return dateTimePlayed.format(formatter);
    }

    /**
     * Appends the score to the specified file.
     * @param score the score to append
     * @param fileName the file name to append to
     * @throws IOException if an I/O error occurs
     */
    public static void appendScoreToFile(final Score score,
                                         final String fileName)
            throws IOException
    {
        final Path scorePath = Paths.get(fileName);

        Files.writeString(scorePath,
                score.toString() + "\n",
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    /**
     * Reads scores from the specified file.
     * @param fileName the file name to read from
     * @return a list of scores
     * @throws IOException if an I/O error occurs
     */
    public static List<Score> readScoresFromFile(final String fileName)
            throws IOException
    {
        final Path scorePath;
        final List<Score> scores;
        final DateTimeFormatter formatter;

        scorePath = Paths.get(fileName);
        scores = new ArrayList<>();
        formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);

        if(Files.notExists(scorePath) ||
           new File(fileName).length() == EMPTY_SCORE)
        {
            return scores;
        }

        try (Scanner fileScan = new Scanner(scorePath))
        {
            while (fileScan.hasNextLine())
            {
                final String line;
                final String dateLine;
                final String gamesLine;
                final String firstLine;
                final String secondLine;
                final String incorrectLine;

                final LocalDateTime dateTime;
                final int           games;
                final int           first;
                final int           second;
                final int           incorrect;

                line = fileScan.nextLine().trim();

                if(line.isEmpty())
                {
                    continue;
                }

                dateLine      = line;
                gamesLine     = fileScan.nextLine();
                firstLine     = fileScan.nextLine();
                secondLine    = fileScan.nextLine();
                incorrectLine = fileScan.nextLine();
                fileScan.nextLine();

                dateTime =  LocalDateTime.parse(
                        dateLine.substring(
                                LABEL_DATE_TIME.length()), formatter);
                games =     Integer.parseInt(
                        gamesLine.substring(
                                LABEL_GAMES_PLAYED.length()).trim());
                first =     Integer.parseInt(
                        firstLine.substring(
                                LABEL_CORRECT_FIRST.length()).trim());
                second =    Integer.parseInt(
                        secondLine.substring(
                                LABEL_CORRECT_SECOND.length()).trim());
                incorrect = Integer.parseInt(
                        incorrectLine.substring(
                                LABEL_INCORRECT_ATTEMPTS.length()).trim());

                scores.add(new Score(dateTime, games, first, second, incorrect));
            }
        }
        return scores;
    }

    /**
     * Compares two scores based on their average score.
     * @param other the other score to compare to
     * @return a negative integer, zero, or a positive integer
     * as this score is less than, equal to, or greater than the specified score
     */
    @Override
    public int compareTo(final Score other)
    {
        return Double.compare(this.getAverageScore(), other.getAverageScore());
    }

    /**
     * Returns a string representation of the score.
     * @return a string representation of the score
     */
    @Override
    public String toString()
    {
        final DateTimeFormatter formatter;
        final StringBuilder     sb;

        formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);
        sb        = new StringBuilder();

        sb.append(LABEL_DATE_TIME)
                .append(dateTimePlayed.format(formatter))
                .append("\n")
                .append(LABEL_GAMES_PLAYED)
                .append(numGamesPlayed)
                .append("\n")
                .append(LABEL_CORRECT_FIRST)
                .append(numCorrectFirstAttempt)
                .append("\n")
                .append(LABEL_CORRECT_SECOND)
                .append(numCorrectSecondAttempt)
                .append("\n")
                .append(LABEL_INCORRECT_ATTEMPTS)
                .append(numIncorrectTwoAttempts)
                .append("\n")
                .append("Score: ")
                .append(getScore())
                .append(" points\n");

        return sb.toString();
    }
}