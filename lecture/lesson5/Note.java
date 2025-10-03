class Note implements Comparable<Note>
{
    private final String data;
    private final String authorLastName;

    Note(final String data,
         final String authorLastName)
    {
        this.data = data;
        this.authorLastName = authorLastName;
    }

    String getData()
    {
        return data;
    }

    String getAuthorLastName()
    {
        return authorLastName;
    }

    @Override
    public String toString()
    {
        return "Note{" +
                "data='" + data + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(final Note that)
    {
        return this.data.length() - that.data.length();
    }
}
