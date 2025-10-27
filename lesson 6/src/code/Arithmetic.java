import java.util.function.IntPredicate;

class Arithmetic
{
    public static void main(final String[] args)
    {
        final IntPredicate even;
        final IntPredicate positive;
        final IntPredicate zeroToHundred;

        even = i->i%2==0;
        System.out.println(even.test(10));

        positive = n->n>0;
        System.out.println(positive.test(3));

        zeroToHundred = (int x)->{
            System.out.println("testing whether " + x + " is between 0 and 100");
            if(x >= 0 && x <= 100)
            {
                return true;
            }
            return false;
        };

        System.out.println(zeroToHundred.test(105));

    }

}
