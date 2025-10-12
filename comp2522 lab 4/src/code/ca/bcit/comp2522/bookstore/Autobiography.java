package ca.bcit.comp2522.bookstore;

public class Autobiography extends Biography
                           implements Printable
{
    public Autobiography(final String title,
                         final int yearPublished,
                         final Author author)
    {
        super(title, yearPublished, author, author);
    }

    @Override
    public void display()
    {
        System.out.println(toString());
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
