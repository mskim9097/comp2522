package ca.bcit.comp2522.project.numbergame;

/**
 * Defines global constants for the Number game.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public interface GameConstants
{
    int GRID_ROWS        = 4;
    int GRID_COLS        = 5;
    int TOTAL_SLOTS      = GRID_ROWS * GRID_COLS;
    int MAX_NUMBER_VALUE = 1000;
    int MIN_NUMBER_VALUE = 1;
    int EMPTY_SLOT       = 0;
    int INDEX_OFFSET     = 1;
    int FIRST_INDEX      = 0;
    int BUTTON_WIDTH     = 80;
    int BUTTON_HEIGHT    = 60;
}
