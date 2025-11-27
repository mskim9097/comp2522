package ca.bcit.bookstore;


public class Book
{
    public static final int MAX_LEN_TITLE = 45;

    private final String title;
    private final int    yearPublished;

    Book(final String title,
         final int yearPublished)
    {
        validateTitle(title);
        this.title = title;
        this.yearPublished = yearPublished;
    }

    private static void validateTitle(final String title)
    {
        if(title == null   ||
           title.isBlank() ||
           title.length() > MAX_LEN_TITLE ||
           title.toLowerCase().contains("bcit".toLowerCase()))
        {
            throw new IllegalArgumentException("Bad title: " + title + "!");
        }
    }

    String getTitle()
    {
        return title;
    }

    String getWhatever()
    {
        return "whatever";
    }
}
