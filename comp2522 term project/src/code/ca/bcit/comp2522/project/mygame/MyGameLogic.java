package ca.bcit.comp2522.project.mygame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Random;

/**
 * Handles all non-GUI logic for the virus outbreak game.
 * Manages the grid, infection spread, statistics, and win/lose conditions.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public class MyGameLogic
        implements MyGameConstants
{
    private static final int    INITIAL_COUNT      = 0;
    private static final int    PERCENT_CONVERSION = 100;
    private static final String RESULT_FILE_NAME
            = "src/resources/mygame/simulation_result.txt";

    private static final int[] NEIGHBOR_D_ROW = {-1, 1, 0, 0};
    private static final int[] NEIGHBOR_D_COL = {0, 0, -1, 1};

    private final Random     random;
    private final Grid<Cell> grid;

    private int     totalVaccinesUsed;
    private int     totalNewInfections;
    private boolean gameOver;
    private boolean playerWon;
    private String  endMessage;

    /**
     * Constructs a new game logic instance and initializes the grid.
     */
    public MyGameLogic()
    {
        random = new Random();
        grid   = new Grid<>(GRID_ROWS, GRID_COLS);
        reset();
    }

    /**
     * Resets the simulation to round 0 with a fresh grid.
     */
    public void reset()
    {
        final SimulationManager manager;

        manager = SimulationManager.getInstance();
        manager.reset();

        totalVaccinesUsed  = INITIAL_COUNT;
        totalNewInfections = INITIAL_COUNT;
        gameOver           = false;
        playerWon          = false;
        endMessage         = "";

        initializeGrid();
    }

    /**
     * Returns the underlying grid.
     *
     * @return the game grid
     */
    public Grid<Cell> getGrid()
    {
        return grid;
    }

    /**
     * Returns true if the game has ended.
     *
     * @return true if the game is over
     */
    public boolean isGameOver()
    {
        return gameOver;
    }

    /**
     * Returns true if the player won.
     *
     * @return true if a player contained the outbreak
     */
    public boolean didPlayerWin()
    {
        return playerWon;
    }

    /**
     * Returns the number of rounds played so far.
     *
     * @return round count
     */
    public int getRoundCount()
    {
        return SimulationManager.getInstance().getRoundCount();
    }

    /**
     * Returns the end-of-game summary message.
     *
     * @return summary string
     */
    public String getEndSummary()
    {
        final SimulationManager manager;
        final StringBuilder     sb;

        manager = SimulationManager.getInstance();
        sb      = new StringBuilder();

        sb.append(endMessage)
                .append("\n\n")
                .append("Rounds played: ")
                .append(manager.getRoundCount())
                .append("\n")
                .append("Vaccines used: ")
                .append(totalVaccinesUsed)
                .append("\n")
                .append("New infections during game: ")
                .append(totalNewInfections);

        return sb.toString();
    }

    /**
     * Returns a statistics line showing counts of each cell type.
     * Uses Java Streams (Lesson 10) for calculation.
     *
     * @return formatted stats
     */
    public String buildStatsText()
    {
        final Cell[][] cells;
        final long     healthyCount;
        final long     infectedCount;
        final long     immuneCount;

        cells = grid.getRawArray();

        healthyCount = Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .filter(c -> c instanceof HealthyCell)
                .count();

        infectedCount = Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .filter(c -> c instanceof InfectedCell)
                .count();

        immuneCount = Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .filter(c -> c instanceof ImmuneCell)
                .count();

        return String.format("Healthy: %d   Infected: %d   Immune: %d",
                healthyCount, infectedCount, immuneCount);
    }

    /**
     * Saves the game result to a file.
     * Uses Files class (Lesson 9).
     */
    public void saveResults()
    {
        final Path path;
        final String content;

        path    = Paths.get(RESULT_FILE_NAME);
        content = "--- Game Result ---\n"
                + getEndSummary() + "\n\n";

        try
        {
            Files.writeString(path, content,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        }
        catch (final IOException e)
        {
            System.out.println(
                    "Error saving game result: " + e.getMessage());
        }
    }

    /**
     * Applies a vaccine to the given cell if it is healthy.
     * If vaccination happens, advances the simulation by one round.
     *
     * @param row row index
     * @param col column index
     * @return true if vaccination was applied, false otherwise
     */
    public boolean vaccinateCell(final int row,
                                 final int col)
    {
        if (gameOver)
        {
            return false;
        }

        final Cell cell;

        cell = grid.getCell(row, col);

        if (cell instanceof HealthyCell)
        {
            final ImmuneCell immuneCell;

            immuneCell = new ImmuneCell(row, col);
            grid.setCell(row, col, immuneCell);

            totalVaccinesUsed++;
            runNextRound();
            return true;
        }

        return false;
    }

    /**
     * Advances the simulation by one round.
     */
    private void runNextRound()
    {
        final SimulationManager manager;
        final Cell[][]          cells;

        manager = SimulationManager.getInstance();
        manager.nextRound();

        cells = grid.getRawArray();

        applyCellUpdates(cells);
        applyPendingInfections(cells);
        checkEndConditions();
    }

    /**
     * Initializes the logical grid with healthy cells
     * and a fixed number of initially infected cells.
     */
    private void initializeGrid()
    {
        int rowIndex;
        int colIndex;

        rowIndex = FIRST_INDEX;
        while (rowIndex < GRID_ROWS)
        {
            colIndex = FIRST_INDEX;
            while (colIndex < GRID_COLS)
            {
                final Cell cell;

                cell = new HealthyCell(rowIndex, colIndex);
                grid.setCell(rowIndex, colIndex, cell);

                colIndex++;
            }
            rowIndex++;
        }

        int infectedSoFar;

        infectedSoFar = INITIAL_COUNT;

        while (infectedSoFar < INITIAL_INFECTED_CELLS)
        {
            final int  randomRow;
            final int  randomCol;
            final Cell current;

            randomRow = random.nextInt(GRID_ROWS);
            randomCol = random.nextInt(GRID_COLS);

            current = grid.getCell(randomRow, randomCol);

            if (!(current instanceof InfectedCell))
            {
                final InfectedCell infectedCell;

                infectedCell = new InfectedCell(randomRow, randomCol);
                grid.setCell(randomRow, randomCol, infectedCell);

                infectedSoFar++;
            }
        }
    }

    /**
     * Calls update(...) on every cell in the grid.
     * @param cells full cell map
     */
    private void applyCellUpdates(final Cell[][] cells)
    {
        int rowIndex;
        int colIndex;

        rowIndex = FIRST_INDEX;
        while (rowIndex < GRID_ROWS)
        {
            colIndex = FIRST_INDEX;
            while (colIndex < GRID_COLS)
            {
                cells[rowIndex][colIndex].update(cells);
                colIndex++;
            }
            rowIndex++;
        }
    }

    /**
     * Converts scheduled infections into infected cells.
     * @param cells full cell map
     */
    private void applyPendingInfections(final Cell[][] cells)
    {
        int rowIndex;
        int colIndex;

        rowIndex = FIRST_INDEX;
        while (rowIndex < GRID_ROWS)
        {
            colIndex = FIRST_INDEX;
            while (colIndex < GRID_COLS)
            {
                final Cell cell;

                cell = cells[rowIndex][colIndex];

                if (cell instanceof HealthyCell)
                {
                    final HealthyCell healthyCell;

                    healthyCell = (HealthyCell) cell;

                    if (healthyCell.willBeInfected())
                    {
                        final InfectedCell infectedCell;

                        infectedCell = new InfectedCell(rowIndex, colIndex);
                        grid.setCell(rowIndex, colIndex, infectedCell);
                        cells[rowIndex][colIndex] = infectedCell;
                        totalNewInfections++;
                    }
                }

                colIndex++;
            }
            rowIndex++;
        }
    }

    /**
     * Checks for win/lose conditions.
     */
    private void checkEndConditions()
    {
        final Cell[][] cells;
        boolean        hasHealthy;
        boolean        hasInfected;
        boolean        canSpread;

        cells       = grid.getRawArray();
        hasHealthy  = false;
        hasInfected = false;
        canSpread   = false;

        int infectedCount;
        int totalCells;

        infectedCount = INITIAL_COUNT;
        totalCells    = GRID_ROWS * GRID_COLS;

        int rowIndex;
        int colIndex;

        rowIndex = FIRST_INDEX;
        while (rowIndex < GRID_ROWS)
        {
            colIndex = FIRST_INDEX;
            while (colIndex < GRID_COLS)
            {
                final Cell cell;

                cell = cells[rowIndex][colIndex];

                if (cell instanceof HealthyCell)
                {
                    hasHealthy = true;
                }
                else if (cell instanceof InfectedCell)
                {
                    hasInfected = true;
                    infectedCount++;

                    if (hasHealthyNeighbor(cells, rowIndex, colIndex))
                    {
                        canSpread = true;
                    }
                }

                colIndex++;
            }
            rowIndex++;
        }

        final int infectedPercent;
        infectedPercent = infectedCount * PERCENT_CONVERSION / totalCells;

        if (!hasHealthy && hasInfected)
        {
            endGame(false,
                    "No healthy cells remain.\n"
                            + "The infection has taken over.");
        }
        else if (infectedPercent > MAX_ALLOWED_INFECTED_PERCENT)
        {
            endGame(false,
                    "You contained the spread,\n"
                            + "but infection reached "
                            + infectedPercent
                            + "% of the population.");
        }
        else if (hasInfected && !canSpread && hasHealthy)
        {
            endGame(true,
                    "The infection can no longer spread.\n"
                            + "You contained the outbreak!");
        }
    }

    /**
     * Returns true if the infected cell at (row, col)
     * has at least one healthy neighbor.
     */
    private boolean hasHealthyNeighbor(final Cell[][] cells,
                                       final int      row,
                                       final int      col)
    {
        int i;
        i = FIRST_INDEX;

        while (i < NEIGHBOR_D_ROW.length)
        {
            final int neighborRow;
            final int neighborCol;

            neighborRow = row + NEIGHBOR_D_ROW[i];
            neighborCol = col + NEIGHBOR_D_COL[i];

            if (neighborRow >= FIRST_INDEX &&
                neighborRow < GRID_ROWS &&
                neighborCol >= FIRST_INDEX &&
                neighborCol < GRID_COLS)
            {
                if (cells[neighborRow][neighborCol] instanceof HealthyCell)
                {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    /**
     * Marks the game as finished and records the result.
     * @param didPlayerWin true if the player won
     * @param message      short outcome message
     */
    private void endGame(final boolean didPlayerWin,
                         final String  message)
    {
        if (gameOver)
        {
            return;
        }
        gameOver   = true;
        playerWon  = didPlayerWin;
        endMessage = message;
    }
}