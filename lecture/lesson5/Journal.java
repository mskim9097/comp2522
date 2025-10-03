import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Journal
{
    private final List<String> notes;  // declare as interface

    Journal()
    {
        notes = new ArrayList<>();

        // RAGS: remove() add() get() size()
        notes.add("DRY");
        notes.add("use best practices");
        notes.add("make code easy to extend");
        notes.add("SOLID principles");
        notes.add("comment your code");
        notes.add("STUPID principles");
        notes.add("structure");
        notes.add("HAVE FUN");


        for(final String n: notes)
        {
            if(n.contains("STUPID"))
            {
                notes.remove(n);
            }
        }


        final Iterator<String> it;
        it = notes.iterator();

        while(it.hasNext())
        {
            final String note;
            note = it.next();

            if(note.contains("easy"))
            {
                System.out.println("REMOVING " + note);
                it.remove();
            }
            else
            {
                System.out.println(note.toUpperCase());
            }
        }





        System.out.println(notes);
        Collections.sort(notes);
        System.out.println(notes);




        System.out.println(notes.size());
        System.out.println(notes.get(0));
        notes.remove(5);
        System.out.println(notes.size());
    }

    public static void main(final String[] args)
    {
        final Journal j;
        j = new Journal();
    }
}
