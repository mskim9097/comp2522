@FunctionalInterface
interface Operable
{
    String concat(String s1, String s2, int i);
}

public class Name
{
    public void main(final String[] args)
    {

        final Formattable test1;

        final Operable replicate;

        replicate = (str1, str2, n) -> {
            String output;
            output = "";
            for(int i = 0; i < n; i++)
            {
                output += str1;
            }
            for(int i = 0; i < n; i++)
            {
                output += str2;
            }
            return output;
        };

        System.out.println(replicate.concat("tiger", "woods", 3));
    }
}
