@FunctionalInterface
interface Mathable
{
    double operate(int x, int y);
}

class Calculator
{

    private static double calculate(final int a,
                                    final int b,
                                    final Mathable m)
    {
        System.out.println("doing math on " + a + " and " + b);
        return m.operate(a, b);
    }

    public static void main(final String[] args)
    {
        final Mathable subtraction;
        final Mathable addition;
        final Mathable power;
        final Mathable multiplication;

        subtraction = (x,y) -> x - y;

        System.out.println(calculate(5,6, subtraction));
        System.out.println(calculate(5,6, (x,y) -> x + y));
        System.out.println(calculate(2,3, (x,y) -> Math.pow(x, y)));
        System.out.println(calculate(6,3, (x,y) -> x*y));




    }

}
