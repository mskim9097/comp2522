package ca.bcit.comp2522.bookstore;

public class Book implements Comparable<Book>,
                             Printable,
                             Reversible
{
    private static final int MAXIMUM_TITLE_CHARACTERS = 100;
    private static final int MINIMUM_YEAR_PUBLISHED   = 1;
    private static final int CURRENT_YEAR             = 2025;

    private final String title;
    private final int yearPublished;
    private final Author author;

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

    public final String getTitle()
    {
        return title;
    }

    public final int getYearPublished()
    {
        return yearPublished;
    }

    public final Author getAuthor()
    {
        return author;
    }

    @Override
    public void display()
    {
        System.out.println(toString());
    }

    @Override
    public void backward()
    {
        final StringBuilder reversed;
        reversed = new StringBuilder();

        reversed.append(this.getTitle());
        reversed.reverse();

        System.out.println("Reversed Title: " + reversed.toString() + "\n");
    }

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

    private static void validateYearPublished(final int yearPublished)
    {
        if(yearPublished < MINIMUM_YEAR_PUBLISHED ||
           yearPublished > CURRENT_YEAR)
        {
            throw new IllegalArgumentException(
                    "Invalid year published");
        }
    }

    private static void validateAuthor(final Author author)
    {
        if(author == null)
        {
            throw new IllegalArgumentException(
                    "Author cannot be null");
        }
    }

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
