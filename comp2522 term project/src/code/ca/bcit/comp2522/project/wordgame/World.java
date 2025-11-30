package ca.bcit.comp2522.project.wordgame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the world containing all loaded country data.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public class World
{
    private static final String EXTENSION  = ".txt";
    private static final char   START_CHAR = 'a';
    private static final char   END_CHAR   = 'z';
    private static final String SEPARATOR  = ":";

    private static final int SPLIT_LIMIT       = 2;
    private static final int LINES_PER_COUNTRY = 4;
    private static final int FIRST_INDEX       = 0;
    private static final int FACT_COUNT        = 3;
    private static final int NAME_INDEX        = 0;
    private static final int CAPITAL_INDEX     = 1;
    private static final int NAME_PARTS_LENGTH = 2;
    private static final int FACTS_OFFSET      = 1;

    private final Map<String, Country> countries;

    /**
     * Constructor for World.
     * @param dirPath the directory path containing country data files
     */
    public World(final Path dirPath)
    {
        validatePath(dirPath);

        this.countries = new HashMap<>();
        loadAllCountries(dirPath);
        // printAllCountries(); // Debug only
    }

    /**
     * Iterates through characters 'a' to 'z' to load corresponding text files.
     * @param dirPath the directory path
     */
    private void loadAllCountries(final Path dirPath)
    {
        for (char c = START_CHAR; c <= END_CHAR; c++)
        {
            final String fileName;
            final Path filePath;

            fileName = c + EXTENSION;
            filePath = dirPath.resolve(fileName);

            if(Files.exists(filePath))
            {
                loadFile(filePath);
            }
        }
    }

    /**
     * Reads a single file and parses chunks of lines into Country objects.
     * @param filePath the file path to read
     */
    private void loadFile(final Path filePath)
    {
        try
        {
            final List<String> lines;
            final List<String> tempCountry;

            lines       = Files.readAllLines(filePath);
            tempCountry = new ArrayList<>();

            for (final String line : lines)
            {
                final String trimmedLine;
                trimmedLine = line.trim();

                if(trimmedLine.isBlank())
                {
                    if(!tempCountry.isEmpty())
                    {
                        loadCountry(tempCountry);
                        tempCountry.clear();
                    }
                }
                else
                {
                    tempCountry.add(trimmedLine);
                }
            }

            if(!tempCountry.isEmpty())
            {
                loadCountry(tempCountry);
            }
        }
        catch (final IOException e)
        {
            System.out.println(
                    "Error reading file: " + filePath);
        }
    }

    /**
     * Parses a block of text lines and creates a Country object.
     * @param tempCountry the list of lines representing one country
     */
    private void loadCountry(final List<String> tempCountry)
    {
        if (tempCountry.size() < LINES_PER_COUNTRY)
        {
            return;
        }

        final String   header;
        final String[] nameParts;
        final String   countryName;
        final String   capitalName;
        final String[] facts;
        final Country  country;

        header    = tempCountry.get(FIRST_INDEX);
        nameParts = header.split(SEPARATOR, SPLIT_LIMIT);

        if (nameParts.length != NAME_PARTS_LENGTH)
        {
            return;
        }

        countryName = nameParts[NAME_INDEX].trim();
        capitalName = nameParts[CAPITAL_INDEX].trim();
        facts       = new String[FACT_COUNT];

        for(int i = FIRST_INDEX; i < FACT_COUNT; i++)
        {
            facts[i] = tempCountry.get(i + FACTS_OFFSET).trim();
        }

        country = new Country(countryName, capitalName, facts);
        countries.put(countryName, country);
    }

    /**
     * Gets a copy of the country map.
     * @return the map of countries
     */
    public Map<String, Country> getCountries()
    {
        return new HashMap<>(countries);
    }

    /**
     * Validates the directory path.
     * @param dirPath the directory path to validate
     */
    private void validatePath(final Path dirPath)
    {
        if(dirPath == null ||
                !Files.isDirectory(dirPath))
        {
            throw new IllegalArgumentException(
                    "Invalid directory path.");
        }
    }
}