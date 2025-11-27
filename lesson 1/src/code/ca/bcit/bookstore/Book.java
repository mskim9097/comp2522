// unique, meaningful, lowercase, reversee domain
package ca.bcit.bookstore;

/**
 * Models a book for BCIT's bookstore.
 *
 * @author Minsu Kim
 * @version 1.0
 */
public class Book {
    private final String authorLastName;
    private final int numPages;
    private final boolean fiction;

    private final double priceUsd;

    /**
     * Constructor.
     * @param authorLastName last name of this book's author
     * @param numPages number of pages
     * @param fiction true if fiction; false if nonfiction
     * @param priceUsd price in USD
     */
    public Book(final String authorLastName,
                final int numPages,
                final boolean fiction,
                final double priceUsd) {
        this.authorLastName = authorLastName;
        this.numPages = numPages;
        this.fiction = fiction;
        this.priceUsd = priceUsd;
    }
}
