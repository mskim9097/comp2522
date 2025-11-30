package ca.bcit.comp2522.project.mygame;

/**
 * Defines constants for MyGame virus simulator.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public interface MyGameConstants
{
    int FIRST_INDEX   = 0;
    int GRID_ROWS     = 10;
    int GRID_COLS     = 10;
    int CELL_SIZE     = 20;

    int INITIAL_INFECTED_CELLS       = 4;
    int INFECTION_CHANCE_PERCENT     = 10;
    int MAX_ALLOWED_INFECTED_PERCENT = 50;
}