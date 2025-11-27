@FunctionalInterface
interface Formattable
{
    String make(String s, int n);
}

class Test2
{
    public static void main(final String[] args)
    {
        final Formattable f1;
        final Formattable f2;

        f1 = (s, n)->{
            String str;
            str = "";
            for(int i = 0; i < n; i++)
            {
                str += s;
            }
            return str;
        };

        f2 = (s, n)->s+n;


        final Formattable f3;
        final Formattable f4;

        f3 = Test2::repeat;
        f4 = Test2::join;
    }

    static String repeat(final String s, final int n)
    {
        String str;
        str = "";
        for(int i = 0; i < n; i++)
        {
            str += s;
        }
        return str;
    }

    static String join(final String s, final int n)
    {
        return s + n;
    }
}
