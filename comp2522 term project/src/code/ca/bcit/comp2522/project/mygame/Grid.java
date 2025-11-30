package ca.bcit.comp2522.project.mygame;

/**
 * Generic grid container for MyGame cells.
 *
 * @author Minsu Kim
 * @version 1.0.0
 * @param <T> the type of Cell stored in this grid
 */
public class Grid<T extends Cell>
{
    private final T[][] cells;
    private final int   rows;
    private final int   cols;

    /**
     * Constructs a Grid with the given dimensions.
     *
     * @param rows number of rows
     * @param cols number of columns
     */
    @SuppressWarnings("unchecked")
    public Grid(final int rows,
                final int cols)
    {
        this.rows = rows;
        this.cols = cols;

        this.cells = (T[][]) new Cell[rows][cols];
    }

    /**
     * Sets the cell at the given position.
     *
     * @param row  row index
     * @param col  column index
     * @param cell cell to store
     */
    public void setCell(final int row,
                        final int col,
                        final T cell)
    {
        cells[row][col] = cell;
    }

    /**
     * Returns the cell at the given position.
     *
     * @param row row index
     * @param col column index
     * @return cell at that position, or null if none
     */
    public T getCell(final int row,
                     final int col)
    {
        return cells[row][col];
    }

    /**
     * Returns the backing 2D array.
     *
     * @return 2D array of cells
     */
    public T[][] getRawArray()
    {
        return cells;
    }

    /**
     * Returns the number of rows.
     *
     * @return row count
     */
    public int getRows()
    {
        return rows;
    }

    /**
     * Returns the number of columns.
     *
     * @return column count
     */
    public int getCols()
    {
        return cols;
    }
}