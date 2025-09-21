import java.util.Date;

public class CreatureTest
{
    public static void main(final String[] args)
    {
        final Creature c1;
        final Creature c2;
        final Creature c3;

        final Date d1 = new Date(125,1,29);
        final Date d2 = new Date(124,11,2);
        final Date d3 = new Date(119,3,8);

        c1 = new Dragon("Dragon", d1, 100, 100);
        c2 = new Elf("Elf", d2, 100, 50);
        c3 = new Orc("Orc", d3, 100, 0);

        Creature[] party = {c1, c2, c3};
        for(Creature c : party)
        {
            c.getDetails();
            System.out.println("Type via instanceof: " +
                    (c instanceof Dragon ? "Dragon" :
                            c instanceof Elf ? "Elf" :
                            c instanceof Orc ? "Orc" :
                                    "Unknown"));
            System.out.println("Type via getClass(): " +
                    c.getClass());
        }
    }
}
