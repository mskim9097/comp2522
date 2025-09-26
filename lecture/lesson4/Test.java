class Book implements Comparable<Book>
{
    private final String title;
    private final int    numPages;

    Book(final String title,
         final int numPages)
    {
        this.title = title;
        this.numPages = numPages;
    }

    String getTitle()
    {
        return title;
    }

    int getNumPages()
    {
        return numPages;
    }

    @Override
    public int compareTo(final Book that)
    {
        // longer title means bigger book
        return this.title.length() - that.title.length();
    }

    @Override
    public String toString()
    {
        return title;
    }
}

class Test
{
    public static void main(final String[] args)
    {
        final String[] s = {"hi", "the end", "bye"};
        final Integer[] i = {5, 7, 66, 4, 3, 222, 45};
        final Double[] d =  {5.5, 7.7, 66.6, 4.4, 3.3, 222.22, 45.4545};
        final Character[] c = {'g', '5', 'z', 'u'};

        final Book b1 = new Book("whatever", 101);
        final Book b2 = new Book("learning java", 55);
        final Book b3 = new Book("getting real", 77);
        final Book b4 = new Book("the end", 101);


        final Book[] b = {b1, b2, b3, b4};

        System.out.println(getMax(i));
        System.out.println(getMax(s));
        System.out.println(getMax(d));
        System.out.println(getMax(c));
        System.out.println(getMax(b));


    }

    static <T extends Comparable<T>>T getMax(final T[] a)
    {
        T max;
        max = a[0];
        for(final T i: a)
        {
            if(i.compareTo(max) > 0)
            {
                max = i;
            }
        }
        return max;
    }

//    static int getMax(final Integer[] a)
//    {
//        Integer max;
//        max = a[0];
//        for(final Integer i: a)
//        {
//            if(i > max)
//            {
//                max = i;
//            }
//        }
//        return max;
//    }

}
