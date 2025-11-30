package ca.bcit.comp2522.project.mygame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for MyGameLogic.
 * Tests vaccination logic, singleton interaction, and exception handling.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
class MyGameLogicTest
{
    private MyGameLogic game1;
    private MyGameLogic game2;

    /**
     * Sets up the test environment before each test method.
     * Initializes two distinct game logic instances.
     */
    @BeforeEach
    void setUp()
    {
        // Initialize two separate instances to test interactions and independence
        game1 = new MyGameLogic();
        game2 = new MyGameLogic();

        // Ensure a clean slate for the Singleton manager
        game1.reset();
    }

    /**
     * Cleans up after each test method.
     * Sets references to null to aid garbage collection.
     */
    @AfterEach
    void tearDown()
    {
        game1 = null;
        game2 = null;
    }

    /**
     * Tests successful vaccination of a healthy cell.
     * Uses assertEquals and assertTrue.
     */
    @Test
    void testVaccinationSuccess()
    {
        // Arrange: Manually place a HealthyCell at (0,0) to ensure deterministic behavior
        // because the game initializes randomly.
        final Grid<Cell> grid1;
        final boolean    result;
        final Cell       cellAfter;

        grid1 = game1.getGrid();
        grid1.setCell(0, 0, new HealthyCell(0, 0));

        // Act: Try to vaccinate the cell
        result = game1.vaccinateCell(0, 0);

        // Assert 1: The action should be successful
        assertTrue(result, "Vaccination should return true for a HealthyCell.");

        // Assert 2: The cell type should change to ImmuneCell
        cellAfter = grid1.getCell(0, 0);
        assertEquals(ImmuneCell.class,
                cellAfter.getClass(),
                "Cell should transform into ImmuneCell after vaccination.");

        // Assert 3: Check game2 to ensure grids are independent (Rule: use multiple objects)
        // game2's (0,0) should NOT be immune (it was randomly initialized)
        assertNotEquals(ImmuneCell.class,
                game2.getGrid().getCell(0,0).getClass(),
                "Vaccinating in game1 should not affect game2's grid.");
    }

    /**
     * Tests exception handling for invalid coordinates.
     * Uses assertThrows.
     */
    @Test
    void testInvalidCoordinatesThrowsException()
    {
        // Act & Assert: Accessing out-of-bounds index should throw ArrayIndexOutOfBoundsException
        // The Grid class uses a raw array, so this exception propagates up.

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            game1.vaccinateCell(-1, 0);
        }, "Negative row index should throw exception.");

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            game2.vaccinateCell(0, 100); // GRID_COLS is 10
        }, "Out of bounds column index should throw exception.");
    }

    /**
     * Tests the Singleton behavior of SimulationManager through GameLogic instances.
     * Checks if the round count is shared/synchronized.
     */
    @Test
    void testSingletonRoundSharing()
    {
        // Arrange: Ensure both start at round 0
        assertEquals(0, game1.getRoundCount());
        assertEquals(0, game2.getRoundCount());

        // Act: Perform an action in game1 that advances the round (vaccinate healthy cell)
        // We force a healthy cell to ensure the action is valid
        game1.getGrid().setCell(0, 0, new HealthyCell(0, 0));
        game1.vaccinateCell(0, 0); // This triggers nextRound() in SimulationManager

        // Assert: Both game1 and game2 should see the updated round count
        // because they share the same Singleton SimulationManager.
        assertEquals(
                1, game1.getRoundCount(),
                "Round count should increment.");
        assertEquals(
                1, game2.getRoundCount(),
                "Round count is global (Singleton), so game2 should also see 1.");
    }

    /**
     * Tests the game over condition.
     * Checks if the game detects a "Win" when infection is contained (cannot spread).
     */
    @Test
    void testGameWinCondition()
    {
        final Grid<Cell> grid;

        // Arrange: Reset the game and setup a controlled grid environment.
        game1.reset();
        grid = game1.getGrid();

        // 1. Fill the entire grid with HealthyCells to remove random infected ones.
        for (int r = 0; r < MyGameConstants.GRID_ROWS; r++) {
            for (int c = 0; c < MyGameConstants.GRID_COLS; c++) {
                grid.setCell(r, c, new HealthyCell(r, c));
            }
        }

        // 2. Place a single InfectedCell at (0,0).
        grid.setCell(0, 0, new InfectedCell(0, 0));

        // 3. Surround it with ImmuneCells to block spread (containment).
        // (0,0)'s neighbors are (0,1) and (1,0).
        grid.setCell(0, 1, new ImmuneCell(0, 1));
        grid.setCell(1, 0, new ImmuneCell(1, 0));

        // Act: Perform an action to trigger the next round update.
        // We vaccinate an irrelevant cell (9,9) just to advance the turn.
        game1.vaccinateCell(9, 9);

        // Assert: The infection cannot spread, so the game should end in a win.
        assertTrue(game1.isGameOver(),
                "Game should be over if infection is contained.");
        assertTrue(game1.didPlayerWin(),
                "Player should win if outbreak is contained.");
    }
}