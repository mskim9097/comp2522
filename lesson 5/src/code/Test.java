import java.util.*;

public class Test
{

    public static void main (final String[] args)
    {
        final List<String> advice;
        advice = new ArrayList<>();

        advice.add("aest1");
        advice.add("best2w");
        advice.add("cest3w");
        advice.add("dest4");
        advice.add("eest5");

        final String[] arr;
        arr = new String[advice.size()];
        int count = 0;
        for(int i = 0; i < advice.size(); i++)
        {
            final String str;
            str = advice.get(i);
            if(str != null && !str.contains("w"))
            {
                arr[i] = str.toUpperCase();
                count++;
            }
        }

        final Map<Character, String> map;
        map = new HashMap<>();

        for(String s : arr)
        {
            if(s != null)
            {
                map.put(s.charAt(0), s);
            }
        }

        final Set<Character> keys;

        keys = map.keySet();

        final Iterator<Character> it;
        it = keys.iterator();

        while(it.hasNext())
        {
            final Character key;
            key = it.next();
            System.out.println(map.get(key).toUpperCase());
        }
    }
}
