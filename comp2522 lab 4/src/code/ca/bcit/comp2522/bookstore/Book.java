package ca.bcit.comp2522.bookstore;

/**
 * A class representing Book.
 * A Book has a title, publication year, and an author.
 * It supports comparison by publication year, formatted display, and title reversal.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 *
 * @version 1.0
 */
public class Book implements Comparable<Book>,
                             Printable,
                             Reversible
{
    private static final int MAXIMUM_TITLE_CHARACTERS = 100;
    private static final int MINIMUM_YEAR_PUBLISHED   = 1455;
    private static final int CURRENT_YEAR             = 2025;

    private final String title;
    private final int yearPublished;
    private final Author author;

    /**
     * Constructs a Book with the specified title,
     * publication year, and author.
     *
     * @param title book's title.
     * @param yearPublished published year of book.
     * @param author author of a book.
     */
    public Book (final String title,
                 final int    yearPublished,
                 final Author author)
    {
        validateTitle(title);
        validateYearPublished(yearPublished);
        validateAuthor(author);

        this.title = title;
        this.yearPublished = yearPublished;
        this.author = author;
    }

    /**
     * A method that gets a title.
     *
     * @return title
     */
    public final String getTitle()
    {
        return title;
    }

    /**
     * A method that gets a published year.
     *
     * @return published year.
     */
    public final int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * A method that gets a author of a book.
     *
     * @return author of a book.
     */
    public final Author getAuthor()
    {
        return author;
    }

    /**
     * A method that displays a book's detail.
     */
    @Override
    public void display()
    {
        System.out.println(toString());
    }

    /**
     * A method that displays reversed book's title.
     */
    @Override
    public void backward()
    {
        final StringBuilder reversed;
        reversed = new StringBuilder();

        reversed.append(this.getTitle());
        reversed.reverse();

        System.out.println("Reversed Title: " + reversed.toString() + "\n");
    }

    /**
     * A method that compares this book with another book by published year.
     *
     * @param that the book to compare with
     * @return A negative integer if this book was published after the other,
     *         zero if in the same year,
     *         or a positive integer if published before.
     */
    @Override
    public int compareTo(final Book that)
    {
        if(that == null)
        {
            throw new IllegalArgumentException(
                    "that cannot be null");
        }

        return that.getYearPublished() - this.getYearPublished();
    }

    // A method that validates a title.
    private static void validateTitle(final String title)
    {
        if(title == null ||
           title.isBlank() ||
           title.length() > MAXIMUM_TITLE_CHARACTERS)
        {
            throw new IllegalArgumentException(
                    "Invalid title");
        }
    }

    // A method that validates a published year.
    private static void validateYearPublished(final int yearPublished)
    {
        if(yearPublished < MINIMUM_YEAR_PUBLISHED ||
           yearPublished > CURRENT_YEAR)
        {
            throw new IllegalArgumentException(
                    "Invalid year published");
        }
    }

    // A method that validates an author of a book.
    private static void validateAuthor(final Author author)
    {
        if(author == null)
        {
            throw new IllegalArgumentException(
                    "Author cannot be null");
        }
    }

    /**
     * Returns a string representation of the book.
     *
     * @return a formatted string containing book details
     */
    @Override
    public String toString()
    {
        final StringBuilder sb;
        sb = new StringBuilder();

        sb.append("Title: ");
        sb.append(title);
        sb.append("\n");
        sb.append("Year Published: ");
        sb.append(yearPublished);
        sb.append("\n");
        sb.append("Author ");
        sb.append(author.toString());
        sb.append("\n");

        return sb.toString();
    }
}
