package ca.bcit.bookstore;

/**
 * Models a book for BCIT's bookstore.
 *
 * @author jason wilder
 * @version 1.0
 */
class Book
{
    private final String  authorLastName;
    private final int     numPages;
    private final boolean fiction;

    private double priceUsd;

    /**
     * Constructor.
     * @param authorLastName last name of this book's author
     * @param numPages       number of pages
     * @param fiction        true if fiction; false if nonfiction
     * @param priceUsd       price in USD
     */
    Book(final String  authorLastName,
         final int     numPages,
         final boolean fiction,
         final double  priceUsd)
    {
        this.authorLastName = authorLastName;
        this.numPages = numPages;
        this.fiction = fiction;
        this.priceUsd = priceUsd;
    }
}
