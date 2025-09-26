abstract class Validator
{
    static boolean isValidString(final String s)
    {
        if(s == null || s.isBlank())
        {
            return false;
        }
        return true;
    }
}

class Test
{
    public static void main(final String[] args)
    {
        System.out.println(Validator.isValidString(""));
    }
}
