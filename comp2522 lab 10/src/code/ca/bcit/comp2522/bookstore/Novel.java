package ca.bcit.comp2522.bookstore;

/**
 * A Novel has a title, author, and year published
 *
 * @author Minsu Kim
 * @author Esin Sahutoglu
 * @author Hali Imanpanah
 *
 * @version 1.0
 */
public class Novel
        implements Comparable<Novel>
{
    private static final int MIN_YEAR_PUBLISHED = 1455;
    private static final int MAX_YEAR_PUBLISHED = 2025;

    private final String title;
    private final String authorName;
    private final int yearPublished;

    /**
     * Constructor for a novel.
     *
     * @param title The title of the novel.
     * @param authorName The author name of the novel.
     * @param yearPublished The year the novel was published.
     */
    public Novel (final String title,
                  final String authorName,
                  final int yearPublished)
    {
        validateTitle(title);
        validateAuthor(authorName);
        validateYearPublished(yearPublished);

        this.title = title;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
    }

    /**
     * Gets the title of the novel.
     *
     * @return The title of the novel.
     */
    public final String getTitle()
    {
        return title;
    }

    /**
     * Gets the author of the novel.
     *
     * @return The author of the novel.
     */
    public final String getAuthorName()
    {
        return authorName;
    }

    /**
     * Gets the year the novel was published.
     *
     * @return The year the novel was published.
     */
    public final int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * Compares two novels by title.
     *
     * @param that The other novel to compare to.
     *
     * @return 0 if the titles are equal,
     *         a negative number if this title is less than that title,
     *         or a positive number if this title is greater than that title.
     */
    @Override
    public int compareTo(final Novel that)
    {
        if (that == null)
        {
            throw new NullPointerException(
                    "Cannot compare to null");
        }
        return this.title.compareToIgnoreCase(that.title);
    }

    /**
     * Validates the title to ensure it is not null or blank.
     *
     * Throws an IllegalArgumentException if the title is invalid.
     */
    private static void validateTitle(final String title)
    {
        if (title == null ||
            title.isBlank())
        {
            throw new IllegalArgumentException(
                    "Title cannot be null or blank");
        }
    }

    /**
     * Validates the author to ensure it is not null or blank.
     *
     * Throws an IllegalArgumentException if the author is invalid.
     */
    private static void validateAuthor(final String author)
    {
        if (author == null ||
            author.isBlank())
        {
            throw new IllegalArgumentException(
                    "Author cannot be null or blank");
        }
    }

    /**
     * Validates that the year published is within the acceptable range.
     *
     * Throws an IllegalArgumentException if the year is less than {@value MIN_YEAR_PUBLISHED} or
     * greater than MAX_YEAR_PUBLISHED.
     */
    private static void validateYearPublished(final int yearPublished)
    {
        if (yearPublished < MIN_YEAR_PUBLISHED ||
            yearPublished > MAX_YEAR_PUBLISHED)
        {
            throw new IllegalArgumentException(
                    "Year published must be between " +
                    MIN_YEAR_PUBLISHED + " and " +
                    MAX_YEAR_PUBLISHED);
        }
    }

    /**
     * A method which returns a string representation of the novel.
     *
     * @return A string representation of the novel.
     */
    @Override
    public String toString()
    {
        final StringBuilder sb;
        sb = new StringBuilder();

        sb.append("Title: ");
        sb.append(title);
        sb.append("\n");
        sb.append("Author name: ");
        sb.append(authorName);
        sb.append("\n");
        sb.append("Year Published: ");
        sb.append(yearPublished);
        sb.append("\n");

        return sb.toString();
    }
}
