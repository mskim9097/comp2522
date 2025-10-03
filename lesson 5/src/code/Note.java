public class Note implements Comparable<Note>
{
    private final String data;
    private final String authorLastName;

    Note(final String data,
         final String authorLastName)
    {
        this.data = data;
        this.authorLastName = authorLastName;
    }

    public String getData()
    {
        return data;
    }
    public String getAuthorLastName()
    {
        return authorLastName;
    }

    @Override
    public String toString()
    {
        return "Note{" +
                "data=" + data + "\n" +
                ", authorLastName=" + authorLastName + "\n" +
                '}';
    }

    @Override
    public int compareTo(final Note that) {
        return this.data.compareTo(that.data);
    }
}
