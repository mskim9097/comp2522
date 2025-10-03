public class NoteBook
{
    private static final int MAX_NOTES = 15;
    private final Note[] notes;

    NoteBook()
    {
        final String [] strings = {"hello", "goodbye", "the end"};

        notes = new Note[MAX_NOTES];

        notes[0]  = new Note("flappy bird", "Nguyen");
        notes[2]  = new Note("2048", "Cirulli");
        notes[9]  = new Note("milliondollarhomepage", "Tew");
        notes[11] = new Note("iwearyourshirt.com", "sadler");
        notes[3]  = new Note("hotornot", "whoever");
        notes[7]  = new Note("fart app", "??");
        notes[1]  = new Note("ugly meter", "???");
        notes[4]  = new Note("i am rich", "??????");
        notes[5]  = new Note("nothing app", "?");
        notes[8]  = new Note("desert golf", "smith");
        notes[10] = new Note("600 games", "Hayward-Mayhew");

        for(final Note n: notes)
        {
            if(n != null)
            {
                System.out.println(n.getData());
            }
        }

        for(int i = 0; i < notes.length; i++)
        {
            System.out.println(notes[i]);
        }
    }

    public static void main(final String[] args)
    {
        final NoteBook nb;
        nb = new NoteBook();
        System.out.println("Printing");
        System.out.println(nb);
    }
}
