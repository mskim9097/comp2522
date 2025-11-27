package ca.bcit.comp2522.lab9.guessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Represents a list of country names used by the guessing game.
 * This class loads the words from a text file and provides access
 * to them as a list of strings.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class WordList
{
    private final List<String> countries;

    /**
     * Constructs a {@code WordList} by reading all lines
     * from the specified file.
     *
     * @param filePath the path to the file containing the country list
     * @throws IOException if an I/O error occurs while reading the file
     */
    public WordList(final Path filePath)
            throws IOException
    {
        countries = Files.readAllLines(filePath);
    }

    /**
     * Returns the list of countries.
     *
     * @return the list of countries
     */
    public List<String> getCountries()
    {
        return countries;
    }
}
