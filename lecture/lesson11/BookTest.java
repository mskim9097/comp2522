package ca.bcit.bookstore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest
{
    Book b1;
    Book b2;
    Book b3;

    @BeforeEach
    void setUp()
    {
        System.out.println("setting up");
        b1 = new Book("learning app development", 2000);
        b2 = new Book("the four-hour workweek", 2020);
        b3 = new Book("01234567890123456789012345678901234", 2025); // 45 max
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("tearing down");
        b1 = null;
        b2 = null;
    }

    @Test
    void testTitleGood()
    {
        assertEquals("learning app development", b1.getTitle());
        assertEquals("the four-hour workweek", b2.getTitle());
        assertEquals("01234567890123456789012345678901234", b3.getTitle());
    }

    @Test
    void testTitleBad()
    {
        badTitle("0123456789012345678901234567890123456789012345");
        badTitle("       ");
        badTitle("");
        badTitle(null);
        badTitle("bcit");
        badTitle("BCIT");
        badTitle("contains bcIt bad");
    }

    void badTitle(final String terribleTitle)
    {
        final IllegalArgumentException e;
        e = assertThrows(IllegalArgumentException.class,
                ()->new Book(terribleTitle, 2000));
        assertEquals("Bad title: " + terribleTitle + "!", e.getMessage());
    }
}