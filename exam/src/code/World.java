import java.util.Iterator;
import java.util.List;

public class World
{
    public World()
    {
        final Thatable[] thatables;
        thatables = new Thatable[2];

        thatables[0] = new Person(10);
        thatables[1] = new Person(11);

        final List<Person> people;

        if(thatables != null)
        {
            for(final Person p : thatables)
            {
                if(p != null)
                {
                    people.add(p);
                }
            }
        }

        final Iterator<Person> it;

        it = people.iterator();

        while(it.hasNext())
        {
            final Person p;
            p = it.next();
            p.a();
        }
    }
}
