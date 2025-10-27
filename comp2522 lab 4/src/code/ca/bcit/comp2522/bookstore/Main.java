package ca.bcit.comp2522.bookstore;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class that creates and tests.
 */
public class Main
{
    /**
     * Drives the program.
     * @param args no-argument
     */
    public static void main(final String[] args)
    {
        final Name n1;
        final Name n2;
        final Name n3;
        final Name n4;
        final Name n5;
        final Name n6;
        final Name n7;
        final Name n8;
        final Name n9;
        final Name n10;
        final Name n11;
        final Name n12;
        final Name n13;
        final Name n15;
        final Name n16;
        final Name n17;
        final Name n18;
        final Name n19;
        final Name n20;

        final Date d1DOB;
        final Date d2DOB;
        final Date d3DOB;
        final Date d4DOB;
        final Date d5DOB;
        final Date d6DOB;
        final Date d7DOB;
        final Date d8DOB;
        final Date d9DOB;
        final Date d10DOB;
        final Date d11DOB;
        final Date d12DOB;
        final Date d13DOB;
        final Date d15DOB;
        final Date d16DOB;
        final Date d17DOB;
        final Date d18DOB;
        final Date d19DOB;
        final Date d20DOB;

        final Date d1DOD;
        final Date d2DOD;
        final Date d3DOD;
        final Date d4DOD;
        final Date d5DOD;
        final Date d7DOD;
        final Date d9DOD;
        final Date d10DOD;
        final Date d11DOD;
        final Date d13DOD;
        final Date d15DOD;
        final Date d16DOD;
        final Date d17DOD;
        final Date d18DOD;
        final Date d19DOD;
        final Date d20DOD;

        final Author a1;
        final Author a2;
        final Author a3;
        final Author a4;
        final Author a5;
        final Author a6;
        final Author a7;
        final Author a8;
        final Author a9;
        final Author a11;
        final Author a12;
        final Author a13;
        final Author a14;
        final Author a15;

        final Person p1;
        final Person p2;
        final Person p3;
        final Person p4;
        final Person p5;

        final Book b1;
        final Book b2;
        final Book b3;
        final Book b4;
        final Book b5;

        final Biography bg1;
        final Biography bg2;
        final Biography bg3;
        final Biography bg4;
        final Biography bg5;

        final Autobiography ab1;
        final Autobiography ab2;
        final Autobiography ab3;
        final Autobiography ab4;
        final Autobiography ab5;

        n1  = new Name("George", "Orwell");
        n2  = new Name("Harper", "Lee");
        n3  = new Name("Jane", "Austen");
        n4  = new Name("F. Scott", "Fitzgerald");
        n5  = new Name("Herman", "Melville");

        n6  = new Name("Robert", "Caro");
        n7  = new Name("Robert", "Moses");
        n8  = new Name("Walter", "Isaacson");
        n9  = new Name("Steve", "Jobs");
        n10 = new Name("Martin", "Gilbert");
        n11 = new Name("Winston", "Churchill");
        n12 = new Name("Ron", "Chernow");
        n13 = new Name("Alexander", "Hamilton");
        n15 = new Name("Albert", "Einstein");

        n16 = new Name("Anne", "Frank");
        n17 = new Name("Nelson", "Mandela");
        n18 = new Name("Mahatma", "Gandhi");
        n19 = new Name("Maya", "Angelou");
        n20 = new Name("Malcolm", "X");

        d1DOB  = new Date(1903, 6, 25);
        d2DOB  = new Date(1926, 4, 28);
        d3DOB  = new Date(1775, 12, 16);
        d4DOB  = new Date(1896, 9, 24);
        d5DOB  = new Date(1819, 8, 1);
        d6DOB  = new Date(1935, 10, 30);
        d7DOB  = new Date(1888, 12, 18);
        d8DOB  = new Date(1952, 5, 20);
        d9DOB  = new Date(1955, 2, 24);
        d10DOB = new Date(1936, 10, 25);
        d11DOB = new Date(1874, 11, 30);
        d12DOB = new Date(1949, 3, 3);
        d13DOB = new Date(1755, 1, 11);
        d15DOB = new Date(1879, 3, 14);
        d16DOB = new Date(1929, 6, 12);
        d17DOB = new Date(1918, 7, 18);
        d18DOB = new Date(1869, 10, 2);
        d19DOB = new Date(1928, 4, 4);
        d20DOB = new Date(1925, 5, 19);

        d1DOD  = new Date(1950, 1, 21);
        d2DOD  = new Date(2016, 2, 19);
        d3DOD  = new Date(1817, 7, 18);
        d4DOD  = new Date(1940, 12, 21);
        d5DOD  = new Date(1891, 9, 28);
        d7DOD  = new Date(1981, 7, 29);
        d9DOD  = new Date(2011, 10, 5);
        d10DOD = new Date(2015, 2, 3);
        d11DOD = new Date(1965, 1, 24);
        d13DOD = new Date(1804, 7, 12);
        d15DOD = new Date(1955, 4, 18);
        d16DOD = new Date(1945, 3, 1);
        d17DOD = new Date(2013, 12, 5);
        d18DOD = new Date(1948, 1, 30);
        d19DOD = new Date(2014, 5, 28);
        d20DOD = new Date(1965, 2, 21);

        a1  = new Author(n1,  d1DOB,  d1DOD,  "Dystopian");
        a2  = new Author(n2,  d2DOB,  d2DOD,  "Drama");
        a3  = new Author(n3,  d3DOB,  d3DOD,  "Romance");
        a4  = new Author(n4,  d4DOB,  d4DOD,  "Classics");
        a5  = new Author(n5,  d5DOB,  d5DOD,  "Adventure");
        a6  = new Author(n6,  d6DOB,  null,   "Biography");
        a7  = new Author(n8,  d8DOB,  null,   "Biography");
        a8  = new Author(n10, d10DOB, d10DOD, "Biography");
        a9  = new Author(n12, d12DOB, null,   "Biography");
        a11 = new Author(n16, d16DOB, d16DOD, "Memoir");
        a12 = new Author(n17, d17DOB, d17DOD, "Political");
        a13 = new Author(n18, d18DOB, d18DOD, "Philosophy");
        a14 = new Author(n19, d19DOB, d19DOD, "Literature");
        a15 = new Author(n20, d20DOB, d20DOD, "Civil Rights");

        p1 = new Person(n7,  d7DOB,  d7DOD);
        p2 = new Person(n9,  d9DOB,  d9DOD);
        p3 = new Person(n11, d11DOB, d11DOD);
        p4 = new Person(n13, d13DOB, d13DOD);
        p5 = new Person(n15, d15DOB, d15DOD);

        b1 = new Book("1984", 1949, a1);
        b2 = new Book("To Kill a Mockingbird", 1960, a2);
        b3 = new Book("Pride and Prejudice", 1813, a3);
        b4 = new Book("The Great Gatsby", 1925, a4);
        b5 = new Book("Moby-Dick", 1851, a5);

        bg1 = new Biography("The Power Broker", 1974, a6,  p1);
        bg2 = new Biography("Steve Jobs", 2011, a7,  p2);
        bg3 = new Biography("Churchill: A Life", 1991, a8,  p3);
        bg4 = new Biography("Alexander Hamilton", 2004, a9,  p4);
        bg5 = new Biography("Einstein: His Life and Universe", 2007, a7,  p5);

        ab1 = new Autobiography("The Diary of a Young Girl", 1947, a11);
        ab2 = new Autobiography("Long Walk to Freedom", 1994, a12);
        ab3 = new Autobiography("The Story of My Experiments with Truth", 1927, a13);
        ab4 = new Autobiography("I Know Why the Caged Bird Sings", 1969, a14);
        ab5 = new Autobiography("Autobiography of Malcolm X", 1965, a15);

        System.out.println("===== printable & reversible tests =====");

        final List<Book> books;
        books = new ArrayList<>();

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(bg1);
        books.add(bg2);
        books.add(bg3);
        books.add(bg4);
        books.add(bg5);
        books.add(ab1);
        books.add(ab2);
        books.add(ab3);
        books.add(ab4);
        books.add(ab5);

        for (Book book : books)
        {
            if (book != null)
            {
                book.display();
                book.backward();
            }
        }

        final List<Person> people;
        people = new ArrayList<>();

        people.add(a1);
        people.add(a2);
        people.add(a3);
        people.add(a4);
        people.add(a5);
        people.add(a6);
        people.add(a7);
        people.add(a8);
        people.add(a9);
        people.add(a11);
        people.add(a12);
        people.add(a13);
        people.add(a14);
        people.add(a15);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);

        for (Person person : people)
        {
            if (person != null)
            {
                person.display();
                person.backward();
            }
        }

        System.out.println();
        System.out.println("===== comparison tests =====");
        final int bookResult;
        bookResult = b1.compareTo(b3);

        if (bookResult > 0)
        {
            final StringBuilder r1;
            r1 = new StringBuilder();
            r1.append(b1.getTitle());
            r1.append(" published in ");
            r1.append(b1.getYearPublished());
            r1.append(" is before ");
            r1.append(b3.getTitle());
            r1.append(" published in ");
            r1.append(b3.getYearPublished());
            System.out.println(r1.toString());
        }
        else if (bookResult == 0)
        {
            final StringBuilder rEq;
            rEq = new StringBuilder();
            rEq.append("Both books were published in ");
            rEq.append(b1.getYearPublished());
            System.out.println(rEq.toString());
        }
        else
        {
            final StringBuilder r2;
            r2 = new StringBuilder();
            r2.append(b1.getTitle());
            r2.append(" published in ");
            r2.append(b1.getYearPublished());
            r2.append(" is after ");
            r2.append(b3.getTitle());
            r2.append(" published in ");
            r2.append(b3.getYearPublished());
            System.out.println(r2.toString());
        }

        System.out.println("===== author comparison =====");
        final int authorResult;
        authorResult = a1.compareTo(a2);

        if (authorResult > 0)
        {
            final StringBuilder a1sb;
            a1sb = new StringBuilder();
            a1sb.append(a1.getName().toString());
            a1sb.append(" (born ");
            a1sb.append(a1.getDateOfBirth().getYyyyMmDd());
            a1sb.append(") is before ");
            a1sb.append(a2.getName().toString());
            a1sb.append(" (born ");
            a1sb.append(a2.getDateOfBirth().getYyyyMmDd());
            a1sb.append(")");
            System.out.println(a1sb.toString());
        }
        else if (authorResult == 0)
        {
            final StringBuilder aEq;
            aEq = new StringBuilder();
            aEq.append(a1.getName().toString());
            aEq.append(" and ");
            aEq.append(a2.getName().toString());
            aEq.append(" were born in the same year (");
            aEq.append(a1.getDateOfBirth().getYyyyMmDd());
            aEq.append(")");
            System.out.println(aEq.toString());
        }
        else
        {
            final StringBuilder a2sb;
            a2sb = new StringBuilder();
            a2sb.append(a1.getName().toString());
            a2sb.append(" (born ");
            a2sb.append(a1.getDateOfBirth().getYyyyMmDd());
            a2sb.append(") is after ");
            a2sb.append(a2.getName().toString());
            a2sb.append(" (born ");
            a2sb.append(a2.getDateOfBirth().getYyyyMmDd());
            a2sb.append(")");
            System.out.println(a2sb.toString());
        }

        final Biography bgJobs2;
        bgJobs2 = new Biography("Becoming Steve Jobs", 2015, a7, p2);

        final boolean sameSubject1;
        sameSubject1 = bg2.equals(bgJobs2);

        if (sameSubject1)
        {
            final StringBuilder sb1;
            sb1 = new StringBuilder();
            sb1.append("\"");
            sb1.append(bg2.getTitle());
            sb1.append("\" and \"");
            sb1.append(bgJobs2.getTitle());
            sb1.append("\" are about the same subject: ");
            sb1.append(bg2.getSubject().getName().toString());
            System.out.println(sb1.toString());
        }
        else
        {
            final StringBuilder sb1;
            sb1 = new StringBuilder();
            sb1.append("\"");
            sb1.append(bg2.getTitle());
            sb1.append("\" and \"");
            sb1.append(bgJobs2.getTitle());
            sb1.append("\" are about different subjects.");
            System.out.println(sb1.toString());
        }

        final boolean sameSubject2;
        sameSubject2 = bg2.equals(bg5);

        if (sameSubject2)
        {
            final StringBuilder sb2;
            sb2 = new StringBuilder();
            sb2.append("\"");
            sb2.append(bg2.getTitle());
            sb2.append("\" and \"");
            sb2.append(bg5.getTitle());
            sb2.append("\" are about the same subject: ");
            sb2.append(bg2.getSubject().getName().toString());
            System.out.println(sb2.toString());
        }
        else
        {
            final StringBuilder sb2;
            sb2 = new StringBuilder();
            sb2.append("\"");
            sb2.append(bg2.getTitle());
            sb2.append("\" (");
            sb2.append(bg2.getSubject().getName().toString());
            sb2.append(") and \"");
            sb2.append(bg5.getTitle());
            sb2.append("\" (");
            sb2.append(bg5.getSubject().getName().toString());
            sb2.append(") are about different subjects.");
            System.out.println(sb2.toString());
        }

        System.out.println();
        System.out.println("===== SUMMARY =====");
        System.out.println("b1 equals b2? " + b1.equals(b2));
        System.out.println("bg2 equals bg5? " + bg2.equals(bg5));
        System.out.println("bg2 equals bgJobs2? " + bg2.equals(bgJobs2));
    }
}