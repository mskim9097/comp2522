package ca.bcit.comp2522.project.mygame;

/**
 * Manages global simulation state (rounds, etc.).
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public class SimulationManager
{
    private static final int INITIAL_ROUND_COUNT = 0;

    private static SimulationManager instance;

    private int roundCount;

    private SimulationManager()
    {
        roundCount = INITIAL_ROUND_COUNT;
    }

    /**
     * Returns the singleton instance of the SimulationManager.
     *
     * @return SimulationManager singleton
     */
    public static synchronized SimulationManager getInstance()
    {
        if (instance == null)
        {
            instance = new SimulationManager();
        }
        return instance;
    }

    /**
     * Advances the simulation by one round.
     */
    public void nextRound()
    {
        roundCount++;
    }

    /**
     * Returns the current round count.
     *
     * @return number of rounds elapsed
     */
    public int getRoundCount()
    {
        return roundCount;
    }

    /**
     * Resets the simulation back to round zero.
     */
    public void reset()
    {
        roundCount = INITIAL_ROUND_COUNT;
    }
}