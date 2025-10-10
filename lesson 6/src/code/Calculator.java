@FunctionalInterface
interface Mathable {
    int calculate(int a, int b);
}

public class Calculator
{

    final static void main(final String[] args)
    {
        final Mathable add;
        final Mathable subtraction;
        final Mathable power;
        final Mathable multiplication;

        add = (a, b) -> a + b;
        subtraction = (a, b) -> a - b;
        power = (a, b) -> (int) Math.pow(a, b);
        multiplication = (a, b) -> a * b;

        System.out.println(add.calculate(1, 2));
        System.out.println(subtraction.calculate(1, 2));
        System.out.println(power.calculate(2, 3));
        System.out.println(multiplication.calculate(2, 3));


    }

}
