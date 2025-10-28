package ca.bcit.comp2522.bookstore;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class represents a bookshop containing a collection of classic novels.
 *
 * Initializes a map of novel titles with their authors and publication years,
 * then demonstrates iteration, filtering, and sorting operations on the data.
 *
 * @author Minsu Kim
 * @author Esin Sahutoglu
 * @author Hali Imanpanah
 *
 * @version 1.0
 */
public class Bookshop
{
    private static final String FILTER = "the";

    private final Map<String, Novel> novels;

    public Bookshop()
    {
        novels = new HashMap<>();

        novels.put("The Adventures of Augie March", new Novel("The Adventures of Augie March", "Saul Bellow", 1953));
        novels.put("All the King’s Men", new Novel("All the King’s Men", "Robert Penn Warren", 1946));
        novels.put("American Pastoral", new Novel("American Pastoral", "Philip Roth", 1997));
        novels.put("An American Tragedy", new Novel("An American Tragedy", "Theodore Dreiser", 1925));
        novels.put("Animal Farm", new Novel("Animal Farm", "George Orwell", 1946));
        novels.put("Appointment in Samarra", new Novel("Appointment in Samarra", "John O'Hara", 1934));
        novels.put("Are You There God? It's Me, Margaret.", new Novel("Are You There God? It's Me, Margaret.", "Judy Blume", 1970));
        novels.put("The Assistant", new Novel("The Assistant", "Bernard Malamud", 1957));
        novels.put("At Swim-Two-Birds", new Novel("At Swim-Two-Birds", "Flann O'Brien", 1938));
        novels.put("Atonement", new Novel("Atonement", "Ian McEwan", 2002));
        novels.put("Beloved", new Novel("Beloved", "Toni Morrison", 1987));
        novels.put("The Berlin Stories", new Novel("The Berlin Stories", "Christopher Isherwood", 1946));
        novels.put("The Big Sleep", new Novel("The Big Sleep", "Raymond Chandler", 1939));
        novels.put("The Blind Assassin", new Novel("The Blind Assassin", "Margaret Atwood", 2000));
        novels.put("Blood Meridian", new Novel("Blood Meridian", "Cormac McCarthy", 1986));
        novels.put("Brideshead Revisited", new Novel("Brideshead Revisited", "Evelyn Waugh", 1946));
        novels.put("The Bridge of San Luis Rey", new Novel("The Bridge of San Luis Rey", "Thornton Wilder", 1927));
        novels.put("Call It Sleep", new Novel("Call It Sleep", "Henry Roth", 1935));
        novels.put("Catch-22", new Novel("Catch-22", "Joseph Heller", 1961));
        novels.put("The Catcher in the Rye", new Novel("The Catcher in the Rye", "J.D. Salinger", 1951));
        novels.put("A Clockwork Orange", new Novel("A Clockwork Orange", "Anthony Burgess", 1963));
        novels.put("The Confessions of Nat Turner", new Novel("The Confessions of Nat Turner", "William Styron", 1967));
        novels.put("The Corrections", new Novel("The Corrections", "Jonathan Franzen", 2001));
        novels.put("The Crying of Lot 49", new Novel("The Crying of Lot 49", "Thomas Pynchon", 1966));
        novels.put("A Dance to the Music of Time", new Novel("A Dance to the Music of Time", "Anthony Powell", 1951));
        novels.put("The Day of the Locust", new Novel("The Day of the Locust", "Nathanael West", 1939));
        novels.put("Death Comes for the Archbishop", new Novel("Death Comes for the Archbishop", "Willa Cather", 1927));
        novels.put("A Death in the Family", new Novel("A Death in the Family", "James Agee", 1958));
        novels.put("The Death of the Heart", new Novel("The Death of the Heart", "Elizabeth Bowen", 1958));
        novels.put("Deliverance", new Novel("Deliverance", "James Dickey", 1970));
        novels.put("Dog Soldiers", new Novel("Dog Soldiers", "Robert Stone", 1974));
        novels.put("Falconer", new Novel("Falconer", "John Cheever", 1977));
        novels.put("The French Lieutenant's Woman", new Novel("The French Lieutenant's Woman", "John Fowles", 1969));
        novels.put("The Golden Notebook", new Novel("The Golden Notebook", "Doris Lessing", 1962));
        novels.put("Go Tell It on the Mountain", new Novel("Go Tell It on the Mountain", "James Baldwin", 1953));
        novels.put("Gone with the Wind", new Novel("Gone with the Wind", "Margaret Mitchell", 1936));
        novels.put("The Grapes of Wrath", new Novel("The Grapes of Wrath", "John Steinbeck", 1939));
        novels.put("Gravity's Rainbow", new Novel("Gravity's Rainbow", "Thomas Pynchon", 1973));
        novels.put("The Great Gatsby", new Novel("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        novels.put("A Handful of Dust", new Novel("A Handful of Dust", "Evelyn Waugh", 1934));
        novels.put("The Heart Is a Lonely Hunter", new Novel("The Heart Is a Lonely Hunter", "Carson McCullers", 1940));
        novels.put("The Heart of the Matter", new Novel("The Heart of the Matter", "Graham Greene", 1948));
        novels.put("Herzog", new Novel("Herzog", "Saul Bellow", 1964));
        novels.put("Housekeeping", new Novel("Housekeeping", "Marilynne Robinson", 1981));
        novels.put("A House for Mr. Biswas", new Novel("A House for Mr. Biswas", "V.S. Naipaul", 1962));
        novels.put("I, Claudius", new Novel("I, Claudius", "Robert Graves", 1934));
        novels.put("Infinite Jest", new Novel("Infinite Jest", "David Foster Wallace", 1996));
        novels.put("Invisible Man", new Novel("Invisible Man", "Ralph Ellison", 1952));
        novels.put("Light in August", new Novel("Light in August", "William Faulkner", 1932));
        novels.put("The Lion, The Witch and the Wardrobe", new Novel("The Lion, The Witch and the Wardrobe", "C.S. Lewis", 1950));
        novels.put("Lolita", new Novel("Lolita", "Vladimir Nabokov", 1955));
        novels.put("Lord of the Flies", new Novel("Lord of the Flies", "William Golding", 1954));
        novels.put("The Lord of the Rings", new Novel("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        novels.put("Loving", new Novel("Loving", "Henry Green", 1945));
        novels.put("Lucky Jim", new Novel("Lucky Jim", "Kingsley Amis", 1954));
        novels.put("The Man Who Loved Children", new Novel("The Man Who Loved Children", "Christina Stead", 1940));
        novels.put("Midnight's Children", new Novel("Midnight's Children", "Salman Rushdie", 1981));
        novels.put("Money", new Novel("Money", "Martin Amis", 1984));
        novels.put("The Moviegoer", new Novel("The Moviegoer", "Walker Percy", 1961));
        novels.put("Mrs. Dalloway", new Novel("Mrs. Dalloway", "Virginia Woolf", 1925));
        novels.put("Naked Lunch", new Novel("Naked Lunch", "William Burroughs", 1959));
        novels.put("Native Son", new Novel("Native Son", "Richard Wright", 1940));
        novels.put("Neuromancer", new Novel("Neuromancer", "William Gibson", 1984));
        novels.put("Never Let Me Go", new Novel("Never Let Me Go", "Kazuo Ishiguro", 2005));
        novels.put("1984", new Novel("1984", "George Orwell", 1948));
        novels.put("On the Road", new Novel("On the Road", "Jack Kerouac", 1957));
        novels.put("One Flew Over the Cuckoo's Nest", new Novel("One Flew Over the Cuckoo's Nest", "Ken Kesey", 1962));
        novels.put("The Painted Bird", new Novel("The Painted Bird", "Jerzy Kosinski", 1965));
        novels.put("Pale Fire", new Novel("Pale Fire", "Vladimir Nabokov", 1962));
        novels.put("A Passage to India", new Novel("A Passage to India", "E.M. Forster", 1924));
        novels.put("Play It as It Lays", new Novel("Play It as It Lays", "Joan Didion", 1970));
        novels.put("Portnoy's Complaint", new Novel("Portnoy's Complaint", "Philip Roth", 1969));
        novels.put("Possession", new Novel("Possession", "A.S. Byatt", 1990));
        novels.put("The Power and the Glory", new Novel("The Power and the Glory", "Graham Greene", 1939));
        novels.put("The Prime of Miss Jean Brodie", new Novel("The Prime of Miss Jean Brodie", "Muriel Spark", 1961));
        novels.put("Rabbit, Run", new Novel("Rabbit, Run", "John Updike", 1960));
        novels.put("Ragtime", new Novel("Ragtime", "E.L. Doctorow", 1975));
        novels.put("The Recognitions", new Novel("The Recognitions", "William Gaddis", 1955));
        novels.put("Red Harvest", new Novel("Red Harvest", "Dashiell Hammett", 1929));
        novels.put("Revolutionary Road", new Novel("Revolutionary Road", "Richard Yates", 1961));
        novels.put("The Sheltering Sky", new Novel("The Sheltering Sky", "Paul Bowles", 1949));
        novels.put("Slaughterhouse-Five", new Novel("Slaughterhouse-Five", "Kurt Vonnegut", 1969));
        novels.put("Snow Crash", new Novel("Snow Crash", "Neal Stephenson", 1992));
        novels.put("The Sot-Weed Factor", new Novel("The Sot-Weed Factor", "John Barth", 1960));
        novels.put("The Sound and the Fury", new Novel("The Sound and the Fury", "William Faulkner", 1929));
        novels.put("The Sportswriter", new Novel("The Sportswriter", "Richard Ford", 1986));
        novels.put("The Spy Who Came in from the Cold", new Novel("The Spy Who Came in from the Cold", "John le Carré", 1964));
        novels.put("The Sun Also Rises", new Novel("The Sun Also Rises", "Ernest Hemingway", 1926));
        novels.put("Their Eyes Were Watching God", new Novel("Their Eyes Were Watching God", "Zora Neale Hurston", 1937));
        novels.put("Things Fall Apart", new Novel("Things Fall Apart", "Chinua Achebe", 1959));
        novels.put("To Kill a Mockingbird", new Novel("To Kill a Mockingbird", "Harper Lee", 1960));
        novels.put("To the Lighthouse", new Novel("To the Lighthouse", "Virginia Woolf", 1929));
        novels.put("Tropic of Cancer", new Novel("Tropic of Cancer", "Henry Miller", 1934));
        novels.put("Ubik", new Novel("Ubik", "Philip K. Dick", 1969));
        novels.put("Under the Net", new Novel("Under the Net", "Iris Murdoch", 1954));
        novels.put("Under the Volcano", new Novel("Under the Volcano", "Malcolm Lowry", 1947));
        novels.put("Watchmen", new Novel("Watchmen", "Alan Moore and Dave Gibbons", 1986));
        novels.put("White Noise", new Novel("White Noise", "Don DeLillo", 1985));
        novels.put("White Teeth", new Novel("White Teeth", "Zadie Smith", 2000));
        novels.put("Wide Sargasso Sea", new Novel("Wide Sargasso Sea", "Jean Rhys", 1966));

        final Set<String> titles;
        final Iterator<String> it1;

        titles = novels.keySet();
        it1    = titles.iterator();

        while(it1.hasNext())
        {
           final String title;
           title = it1.next();

           System.out.println(title);
        }

        System.out.println(
                "\n=== Remove novels whose title contains \"the\" ===");

        final Iterator<String> it2;
        it2 = titles.iterator();

        while(it2.hasNext())
        {
            final String title;
            title = it2.next();

            if(title.toLowerCase().contains(FILTER))
            {
                it2.remove();
            }
        }

        final List<String> titleList;
        titleList = new ArrayList<>(titles);

        Collections.sort(titleList);

        System.out.println("\n=== Novels after removal (sorted) ===");
        for(final String title : titleList)
        {
            System.out.println(novels.get(title));
        }
    }

    /**
     * Main method that runs the bookshop.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(final String[] args)
    {
        final Bookshop bookshop;
        bookshop = new Bookshop();
    }
}
