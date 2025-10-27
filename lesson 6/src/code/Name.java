@FunctionalInterface
interface Operable
{
    String operate(String s1, String s2, int n);
}

public class Name
{
    public static void main(final String[] args)
    {
        final Operable repeats;
        repeats = (str1, str2, n) -> {
            final StringBuilder sb;
            sb = new StringBuilder();
            for(int i = 0; i < n; i++)
            {
                sb.append(str1).append(str2);
            }
            return sb.toString();
        };
        System.out.println(repeats.operate("Tiger", "Woods", 3));

        final Operable replicate;

        replicate = (str1, str2, n) -> {
            String output;
            output = "";
            for(int i = 0; i < n; i++) {
                output+=str1;
            }
            for (int i = 0; i < n; i++) {
                output += str2;
            }

            return output;
        };
        System.out.println(replicate.operate("Tiger", "Woods", 3));

        final Operable charAtN;
        charAtN = (str1, str2, n) -> "" + str1.charAt(n-1) + str2.charAt(n-1);

        final Operable nStartLetters;

        nStartLetters = (str1, str2, n) -> str1.substring(0, n) + str2.substring(0, n);
        System.out.println(charAtN.operate("Tiger", "Woods", 3));
        System.out.println(nStartLetters.operate("Tiger", "Woods", 3));
    }


}


