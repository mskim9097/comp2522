import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Numberline
{
    private final Map<Integer, String> numbers;

    Numberline()
    {
        numbers = new HashMap<>();

        // instead of RAGS, we have RPGS (put), and keySet
        numbers.put(5, "five");
        numbers.put(3, "three");
        numbers.put(1, "one");
        numbers.put(0, "zero");
        numbers.put(9, "nine");
        numbers.put(7, "seven");
        numbers.put(8, "eight");
        numbers.put(2, "two");
        numbers.put(6, "six");
        numbers.put(4, "four");

        System.out.println(numbers.get(8)); // eight
        numbers.remove(7);
        System.out.println(numbers.size()); // 10

        final Set<Integer> keys;
        keys = numbers.keySet();

        for(final Integer key: keys)
        {
            System.out.println(key);
            System.out.println(numbers.get(key).toUpperCase());
        }
    }

    public static void main(final String[] args)
    {
        final Numberline nl;
        nl = new Numberline();
    }
}
