import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
interface Mathable
{
    double operate(int x, int y);
}

class Calculator
{
    private final String name;

    // Function functional interface's apply() method takes one arg
    // and returns one T
    Calculator(final String name)
    {
        this.name = name;
        System.out.println("creating calculator named " + name);
    }

    // Supplier functional interface's get() method takes no args
    // but returns one T
    Calculator()
    {
        this("Unnamed calculator");
        System.out.println("creating unnamed calculator");
    }

    private static double calculate(final int a,
                                    final int b,
                                    final Mathable m)
    {
        System.out.println("doing math on " + a + " and " + b);
        return m.operate(a, b);
    }

    public static void main(final String[] args)
    {

        final Calculator c1;
        final Calculator c2;

        final Supplier<Calculator> defaultMaker;
        defaultMaker = Calculator::new;

        System.out.println("supplier...");
        c1 = defaultMaker.get();

        final Function<String, Calculator> namedMaker;
        namedMaker = Calculator::new;

        System.out.println("function...");
        c2 = namedMaker.apply("T1-345");


        final Mathable subtraction;
        final Mathable addition;
        final Mathable multiplication;

        // subtraction = (x,y) -> x - y;
        // METHOD REFERENCE 1: TO A STATIC METHOD
        subtraction = Calculator::subtract;

        // METHOD REFERENCE 2: TO A METHOD OF AN OBJECT OF SOME CLASS
        // ("UNBOUND") i.e. not bound to an object YET
        // BIND IMMEDIATELY TO A "NEW" OBJECT
        final Mathable division;
        division = new Calculator()::divide;
        System.out.println(division.operate(10, 3));

        // METHOD REFERENCE 3: TO AN EXISTING OBJECT'S METHOD
        // "BOUND": THE OBJECT ALREADY EXISTS; WE WILL REFERENCE ITS METHOD
        final Mathable power;
        final Calculator c;
        c = new Calculator();
        power = c::power;
        System.out.println(calculate(2, 3, power)); // internally using c's method

        System.out.println(calculate(5,6, subtraction));


        // System.out.println(calculate(5,6, (x,y) -> x + y));
        // System.out.println(calculate(6,3, (x,y) -> x*y));
    }

    static double subtract(final int a,
                           final int b)
    {
        return a - b;
    }

    double divide(final int a,
                           final int b)
    {
        return (1.0 * a) / b;
    }

    double power(final int a,
                  final int b)
    {
        return Math.pow(2, 3);
    }
}

/*
Why use ::new references instead of direct constructor calls?
a) can be passed as a value
b) lazy creation: nothing gets created until "later"; e.g. get() or apply()
c) resuable factory: use the same reference in many places
d) functional programming compatibility; e.g. stream() expects FUNCTION objects
e) cleaner syntax with APIs (vs. lambda expression syntax)

 */

