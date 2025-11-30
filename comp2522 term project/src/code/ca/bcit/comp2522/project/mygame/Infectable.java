package ca.bcit.comp2522.project.mygame;

/**
 * Defines the behavior for cells that can be infected.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public interface Infectable
{
    /**
     * Attempts to infect the cell.
     *
     * @return true if infection was successful, false otherwise
     */
    boolean tryInfect();
}