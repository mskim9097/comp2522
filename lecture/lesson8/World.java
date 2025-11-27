import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class World
{
    World()
    {
        final Thatable[] thats;
        final List<Thatable> more;
        final Iterator<Thatable> it;

        thats = new Thatable[2];
        more = new ArrayList<>();

        thats[0] = new Person(2000);
        thats[1] = new Person(2020);
        it = more.iterator();

        for(final Thatable that: thats)
        {
            more.add(that);
        }

        while(it.hasNext())
        {
            final Thatable t;
            t = it.next();
            t.d();
        }
    }
}
