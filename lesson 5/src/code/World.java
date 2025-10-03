import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class World
{
    public static void main(final String[] args)
    {
        final Map<String, String> countries;
        final Set<String> countryCodes;
        final Iterator<String> it;

        countries = new HashMap<>();

        countries.put("ca", "canada");
        countries.put("ch", "china");
        countries.put("mx", "mexico");
        countries.put("cl", "chile");
        countries.put("bu", "burundi");

        countryCodes = countries.keySet();

        it = countryCodes.iterator();

        while(it.hasNext())
        {
            final String key;
            key = it.next();

            System.out.printf("%s is %s!!\n", key, countries.get(key));
        }


    }
}
