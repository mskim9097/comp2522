import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class World
{
    public static void main(final String[] args)
    {
        final Map<String, String> countries;
        final Set<String> countryCodes;
        final Iterator<String> it;

        countries = new HashMap<>();

        countries.put("ca", "Canada");
        countries.put("cl", "Chile");

        countryCodes = countries.keySet();
        it = countryCodes.iterator();

        while(it.hasNext())
        {
            final String key;
            key = it.next();

            System.out.printf("%s is %s!!!%s",
                    key,
                    countries.get(key), System.lineSeparator());
        }


    }
}