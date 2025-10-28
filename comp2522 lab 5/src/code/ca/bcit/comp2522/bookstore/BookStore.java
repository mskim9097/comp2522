package ca.bcit.comp2522.bookstore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * BookStore can hold many {@link Novel} objects.
 * Has instance data for store name and list of bookList it has.
 *
 * @author Minsu Kim
 * @author Esin Sahutoglu
 * @author Hali Imanpanah
 *
 * @version 1.0
 */
public class BookStore
{
    private static final int YEARS_PER_DECADE   = 10;
    private static final int LAST_YEAR_OFFSET   = 9;
    private static final int MINIMUM_DECADE     = 0;
    private static final int DEFAULT_COUNT      = 0;
    private static final int MINIMUM_YEAR       = 0;
    private static final int MAXIMUM_PERCENTAGE = 100;
    private static final int DEFAULT_PERCENTAGE = 0;
    private static final int MINIMUM_LENGTH     = 0;
    private static final int START_INDEX        = 0;

    private final String      storeName;
    private final List<Novel> bookList;

    /**
     * Constructor for BookStore.
     * Constructs with a defined list of bookList
     *
     * @param storeName The name of the bookstore.
     */
    public BookStore (final String storeName)
    {
        validateStoreName(storeName);
        this.storeName = storeName;

        bookList = new ArrayList<>();

        bookList.add(new Novel("The Adventures of Augie March", "Saul Bellow", 1953));
        bookList.add(new Novel("All the King’s Men", "Robert Penn Warren", 1946));
        bookList.add(new Novel("American Pastoral", "Philip Roth", 1997));
        bookList.add(new Novel("An American Tragedy", "Theodore Dreiser", 1925));
        bookList.add(new Novel("Animal Farm", "George Orwell", 1946));
        bookList.add(new Novel("Appointment in Samarra", "John O'Hara", 1934));
        bookList.add(new Novel("Are You There God? It's Me, Margaret.", "Judy Blume", 1970));
        bookList.add(new Novel("The Assistant", "Bernard Malamud", 1957));
        bookList.add(new Novel("At Swim-Two-Birds", "Flann O'Brien", 1938));
        bookList.add(new Novel("Atonement", "Ian McEwan", 2002));
        bookList.add(new Novel("Beloved", "Toni Morrison", 1987));
        bookList.add(new Novel("The Berlin Stories", "Christopher Isherwood", 1946));
        bookList.add(new Novel("The Big Sleep", "Raymond Chandler", 1939));
        bookList.add(new Novel("The Blind Assassin", "Margaret Atwood", 2000));
        bookList.add(new Novel("Blood Meridian", "Cormac McCarthy", 1986));
        bookList.add(new Novel("Brideshead Revisited", "Evelyn Waugh", 1946));
        bookList.add(new Novel("The Bridge of San Luis Rey", "Thornton Wilder", 1927));
        bookList.add(new Novel("Call It Sleep", "Henry Roth", 1935));
        bookList.add(new Novel("Catch-22", "Joseph Heller", 1961));
        bookList.add(new Novel("The Catcher in the Rye", "J.D. Salinger", 1951));
        bookList.add(new Novel("A Clockwork Orange", "Anthony Burgess", 1963));
        bookList.add(new Novel("The Confessions of Nat Turner", "William Styron", 1967));
        bookList.add(new Novel("The Corrections", "Jonathan Franzen", 2001));
        bookList.add(new Novel("The Crying of Lot 49", "Thomas Pynchon", 1966));
        bookList.add(new Novel("A Dance to the Music of Time", "Anthony Powell", 1951));
        bookList.add(new Novel("The Day of the Locust", "Nathanael West", 1939));
        bookList.add(new Novel("Death Comes for the Archbishop", "Willa Cather", 1927));
        bookList.add(new Novel("A Death in the Family", "James Agee", 1958));
        bookList.add(new Novel("The Death of the Heart", "Elizabeth Bowen", 1958));
        bookList.add(new Novel("Deliverance", "James Dickey", 1970));
        bookList.add(new Novel("Dog Soldiers", "Robert Stone", 1974));
        bookList.add(new Novel("Falconer", "John Cheever", 1977));
        bookList.add(new Novel("The French Lieutenant's Woman", "John Fowles", 1969));
        bookList.add(new Novel("The Golden Notebook", "Doris Lessing", 1962));
        bookList.add(new Novel("Go Tell It on the Mountain", "James Baldwin", 1953));
        bookList.add(new Novel("Gone with the Wind", "Margaret Mitchell", 1936));
        bookList.add(new Novel("The Grapes of Wrath", "John Steinbeck", 1939));
        bookList.add(new Novel("Gravity's Rainbow", "Thomas Pynchon", 1973));
        bookList.add(new Novel("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        bookList.add(new Novel("A Handful of Dust", "Evelyn Waugh", 1934));
        bookList.add(new Novel("The Heart Is a Lonely Hunter", "Carson McCullers", 1940));
        bookList.add(new Novel("The Heart of the Matter", "Graham Greene", 1948));
        bookList.add(new Novel("Herzog", "Saul Bellow", 1964));
        bookList.add(new Novel("Housekeeping", "Marilynne Robinson", 1981));
        bookList.add(new Novel("A House for Mr. Biswas", "V.S. Naipaul", 1962));
        bookList.add(new Novel("I, Claudius", "Robert Graves", 1934));
        bookList.add(new Novel("Infinite Jest", "David Foster Wallace", 1996));
        bookList.add(new Novel("Invisible Man", "Ralph Ellison", 1952));
        bookList.add(new Novel("Light in August", "William Faulkner", 1932));
        bookList.add(new Novel("The Lion, The Witch and the Wardrobe", "C.S. Lewis", 1950));
        bookList.add(new Novel("Lolita", "Vladimir Nabokov", 1955));
        bookList.add(new Novel("Lord of the Flies", "William Golding", 1954));
        bookList.add(new Novel("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        bookList.add(new Novel("Loving", "Henry Green", 1945));
        bookList.add(new Novel("Lucky Jim", "Kingsley Amis", 1954));
        bookList.add(new Novel("The Man Who Loved Children", "Christina Stead", 1940));
        bookList.add(new Novel("Midnight's Children", "Salman Rushdie", 1981));
        bookList.add(new Novel("Money", "Martin Amis", 1984));
        bookList.add(new Novel("The Moviegoer", "Walker Percy", 1961));
        bookList.add(new Novel("Mrs. Dalloway", "Virginia Woolf", 1925));
        bookList.add(new Novel("Naked Lunch", "William Burroughs", 1959));
        bookList.add(new Novel("Native Son", "Richard Wright", 1940));
        bookList.add(new Novel("Neuromancer", "William Gibson", 1984));
        bookList.add(new Novel("Never Let Me Go", "Kazuo Ishiguro", 2005));
        bookList.add(new Novel("1984", "George Orwell", 1948));
        bookList.add(new Novel("On the Road", "Jack Kerouac", 1957));
        bookList.add(new Novel("One Flew Over the Cuckoo's Nest", "Ken Kesey", 1962));
        bookList.add(new Novel("The Painted Bird", "Jerzy Kosinski", 1965));
        bookList.add(new Novel("Pale Fire", "Vladimir Nabokov", 1962));
        bookList.add(new Novel("A Passage to India", "E.M. Forster", 1924));
        bookList.add(new Novel("Play It as It Lays", "Joan Didion", 1970));
        bookList.add(new Novel("Portnoy's Complaint", "Philip Roth", 1969));
        bookList.add(new Novel("Possession", "A.S. Byatt", 1990));
        bookList.add(new Novel("The Power and the Glory", "Graham Greene", 1939));
        bookList.add(new Novel("The Prime of Miss Jean Brodie", "Muriel Spark", 1961));
        bookList.add(new Novel("Rabbit, Run", "John Updike", 1960));
        bookList.add(new Novel("Ragtime", "E.L. Doctorow", 1975));
        bookList.add(new Novel("The Recognitions", "William Gaddis", 1955));
        bookList.add(new Novel("Red Harvest", "Dashiell Hammett", 1929));
        bookList.add(new Novel("Revolutionary Road", "Richard Yates", 1961));
        bookList.add(new Novel("The Sheltering Sky", "Paul Bowles", 1949));
        bookList.add(new Novel("Slaughterhouse-Five", "Kurt Vonnegut", 1969));
        bookList.add(new Novel("Snow Crash", "Neal Stephenson", 1992));
        bookList.add(new Novel("The Sot-Weed Factor", "John Barth", 1960));
        bookList.add(new Novel("The Sound and the Fury", "William Faulkner", 1929));
        bookList.add(new Novel("The Sportswriter", "Richard Ford", 1986));
        bookList.add(new Novel("The Spy Who Came in from the Cold", "John le Carré", 1964));
        bookList.add(new Novel("The Sun Also Rises", "Ernest Hemingway", 1926));
        bookList.add(new Novel("Their Eyes Were Watching God", "Zora Neale Hurston", 1937));
        bookList.add(new Novel("Things Fall Apart", "Chinua Achebe", 1959));
        bookList.add(new Novel("To Kill a Mockingbird", "Harper Lee", 1960));
        bookList.add(new Novel("To the Lighthouse", "Virginia Woolf", 1929));
        bookList.add(new Novel("Tropic of Cancer", "Henry Miller", 1934));
        bookList.add(new Novel("Ubik", "Philip K. Dick", 1969));
        bookList.add(new Novel("Under the Net", "Iris Murdoch", 1954));
        bookList.add(new Novel("Under the Volcano", "Malcolm Lowry", 1947));
        bookList.add(new Novel("Watchmen", "Alan Moore and Dave Gibbons", 1986));
        bookList.add(new Novel("White Noise", "Don DeLillo", 1985));
        bookList.add(new Novel("White Teeth", "Zadie Smith", 2000));
        bookList.add(new Novel("Wide Sargasso Sea", "Jean Rhys", 1966));
    }

    /**
     * Returns the name of the store.
     *
     * @return the {@code storeName} of this object
     */
    public final String getStoreName()
    {
        return storeName;
    }

    /**
     * Returns the list of novels available in the store
     *
     * @return a {@code List<Novel>} containing all the novels
     */
    public List<Novel> getBookList()
    {
        return bookList;
    }


    /**
     * Prints all titles in UPPERCASE.
     */
    public void printAllTitles()
    {
        if(bookList.isEmpty())
        {
            System.out.println("No books in the store.");
            return;
        }

        for(final Novel novel : bookList)
        {
            System.out.println(novel.getTitle().toUpperCase());
        }
    }

    /**
     * Prints all titles that contain the specified parameter.
     *
     * @param title The title to search for.
     */
    public void printBookTitle(final String title)
    {
        if(bookList.isEmpty())
        {
            System.out.println("No books in the store.");
            return;
        }

        if(title == null || title.isBlank())
        {
            System.out.println("Title cannot be null or blank.");
            return;
        }
        boolean found = false;

        for(final Novel novel : bookList)
        {
            if(novel.getTitle().toLowerCase().contains(title.toLowerCase()))
            {
                System.out.println(novel.getTitle());
                found = true;
            }
        }

        if(!found)
        {
            System.out.println(
                    "No books found containing '" + title + "'.");
        }
    }

    /**
     * Prints all titles in alphabetical order, A-Z
     */
    public void printTitlesInAlphaOrder()
    {
        if(bookList.isEmpty())
        {
            System.out.println("No books in the store.");
            return;
        }
        Collections.sort(bookList);

        for(Novel novel : bookList)
        {
            System.out.println(novel.getTitle());
        }
    }

    /**
     * Prints all novels published in the specified decade.
     *
     * If the list is empty or the decade is below {@value MINIMUM_DECADE},
     * an appropriate message is displayed.
     *
     * @param decade the starting year of the decade to filter by
     */
    public void printGroupByDecade(final int decade)
    {
        if(bookList.isEmpty())
        {
            System.out.println("No books in the store.");
            return;
        }
        if(decade < MINIMUM_DECADE)
        {
            System.out.println("Decade cannot be less than 0.");
            return;
        }

        // normalize any year (ex. 1955 -> 1950)
        final int startOfDecade;
        final int endOfDecade;

        startOfDecade = (decade / YEARS_PER_DECADE) * YEARS_PER_DECADE;
        endOfDecade = startOfDecade + LAST_YEAR_OFFSET;
        boolean found = false;

        for (final Novel novel : bookList)
        {
            final int year = novel.getYearPublished();
            if(year >= startOfDecade && year <= endOfDecade)
            {
                System.out.println(novel.getTitle());
                found = true;
            }
        }
        if(!found)
        {
            System.out.println("No books found in decade " + decade);
        }
    }

    /**
     * Finds and prints the title of the novel with the longest name in the book list.
     * If the list is empty, a message indicating no books are available is displayed.
     *
     * The method iterates through the {@code bookList} to compare the length of each
     * novel’s title and identifies the one with the greatest length.
     */
    public void getLongest()
    {
        if(bookList.isEmpty())
        {
            System.out.println("No books in the store.");
            return;
        }
        Novel longest;
        longest = bookList.get(START_INDEX);

        for(final Novel novel : bookList)
        {
            if(novel.getTitle().length() >
               longest.getTitle().length())
            {
                longest = novel;
            }
        }
        System.out.println(longest.getTitle());
    }

    /**
     * Checks whether there is at least one novel in the list
     * that was published in the specified year.
     *
     * @param year the year to check for in the {@code bookList}
     *
     * @return {@code true} if a novel was published in the given year;
     *         {@code false} otherwise or if the list is empty
     */
    public boolean isThereABookWrittenIn(final int year)
    {
        if(bookList.isEmpty())
        {
            return false;
        }
        for(final Novel novel : bookList)
        {
            if(novel.getYearPublished() == year)
                return true;
        }
        return false;
    }

    /**
     * Counts how many novels in the list have titles containing
     * the specified word (case-insensitive).
     *
     * If the {@code bookList} is empty, or if the provided word is
     * {@code null} or blank, the method returns {@value DEFAULT_COUNT}.
     *
     * @param word The word to search for within each novel’s title
     *
     * @return the number of novels whose titles contain the specified word
     */
    public int howManyBooksContain(final String word)
    {
        if(bookList.isEmpty())
        {
            return DEFAULT_COUNT;
        }
        if(word == null || word.isBlank())
        {
            System.out.println("Word cannot be null or blank.");
            return DEFAULT_COUNT;
        }

        int count = DEFAULT_COUNT;
        for(final Novel novel : bookList)
        {
            if(novel.getTitle().
               toLowerCase().
               contains(word.toLowerCase()))
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Calculates the percentage of novels published between
     * the two given years (inclusive).
     *
     * Returns {@value DEFAULT_PERCENTAGE} if the list is empty
     * or either year is below {@value MINIMUM_YEAR}.
     *
     * @param first the first year
     * @param last  the second year
     * @return the percentage of novels within the range
     */
    public int whichPercentWrittenBetween(int first,
                                          int last)
    {
        if(bookList.isEmpty())
        {
            return DEFAULT_PERCENTAGE;
        }

        if(first < MINIMUM_YEAR ||
           last < MINIMUM_YEAR)
        {
            System.out.println("Year cannot be less than " +
                                MINIMUM_YEAR);
            return DEFAULT_PERCENTAGE;
        }

        final int from;
        final int to;

        from = Math.min(first, last);
        to   = Math.max(first, last);

        int count;
        count = DEFAULT_COUNT;

        for(final Novel novel : bookList)
        {
            final int year = novel.getYearPublished();
            if(year >= from && year <= to)
            {
                count++;
            }
        }

        return (count * MAXIMUM_PERCENTAGE) / bookList.size();
    }

    /**
     * Returns the oldest novel in the {@code bookList}.
     *
     * @return the oldest {@code Novel}, or {@code null} if the list is empty
     */
    public Novel getOldestBook()
    {
        if(bookList.isEmpty())
        {
            return null;
        }

        Novel oldest = bookList.get(START_INDEX);
        for(final Novel novel : bookList)
        {
            if(novel.getYearPublished() < oldest.getYearPublished())
            {
                oldest = novel;
            }
        }
        return oldest;
    }

    /**
     * A method that returns a list of all books whose title is this length.
     *
     * @param titleLength The length of the title to search for.
     *
     * @return a {@code List<Novel>} with matching titles, or an empty list if none
     */
    private List<Novel> getBooksThisLength(final int titleLength)
    {
        final List<Novel> result;
        result = new ArrayList<>();

        if(bookList.isEmpty())
        {
            return result;
        }

        if(titleLength <= MINIMUM_LENGTH)
        {
            System.out.println("Length cannot be less than " +
                                MINIMUM_LENGTH);
            return result;
        }

        for(final Novel novel : bookList)
        {
            if(novel.getTitle().trim().length() == titleLength)
            {
                result.add(novel);
            }
        }
        return result;
    }

    /**
     * A method that validates that the store name is not null or blank.
     *
     * @param storeName the name of the store to validate
     *
     * @throws IllegalArgumentException if the store name is invalid
     */
    private static void validateStoreName(final String storeName)
    {
        if (storeName == null || storeName.isBlank())
        {
            throw new IllegalArgumentException(
                    "Store name cannot be null or blank");
        }
    }

    /**
     * Main method which demonstrates the features of the {@code BookStore} class.
     *
     * Creates a bookstore instance and showcases methods such as
     * printing titles, filtering books, and displaying statistics.
     *
     * @param args Command line arguments.
     */
    public static void main(final String[] args)
    {
        final BookStore bookstore;
        final Novel oldest;
        final List<Novel> fifteenCharTitles;

        bookstore = new BookStore("Classic Novels Collection");
        System.out.println("All Titles in UPPERCASE:");
        bookstore.printAllTitles();
        System.out.println("\nBook Titles Containing 'the':");
        bookstore.printBookTitle("the");
        System.out.println("\nAll Titles in Alphabetical Order:");
        bookstore.printTitlesInAlphaOrder();
        System.out.println("\nBooks from the 2000s:");
        bookstore.printGroupByDecade(2000);
        System.out.println("\nLongest Book Title:");
        bookstore.getLongest();
        System.out.println("\nIs there a book written in 1950?");
        System.out.println(bookstore.isThereABookWrittenIn(1950));
        System.out.println("\nHow many books contain 'heart'?");
        System.out.println(bookstore.howManyBooksContain("heart"));
        System.out.println("\nPercentage of books written between 1940 and 1950:");
        System.out.println(bookstore.whichPercentWrittenBetween(1940, 1950) + "%");
        System.out.println("\nOldest book:");
        oldest = bookstore.getOldestBook();
        System.out.println(oldest.getTitle() + " by " + oldest.getAuthorName() + ", " + oldest.getYearPublished());
        System.out.println("\nBooks with titles 15 characters long:");
        fifteenCharTitles = bookstore.getBooksThisLength(15);
        fifteenCharTitles.forEach(novel -> System.out.println(novel.getTitle()));
    }
}
