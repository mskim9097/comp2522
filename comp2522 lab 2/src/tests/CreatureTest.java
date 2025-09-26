import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreatureTest {
    public static void main(String[] args) {

        Creature[] creatures = new Creature[3];

        try {
            /* Creates Dragon. */
            Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse("2000-02-21");
            creatures[0] = new Dragon("Dragon", birthDate, 100, 100);

        } catch (ParseException e) {
            System.out.println("Failed to create Dragon: " + e.getMessage());
        }


        try {
            /* Creates Elf. */
            Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse("2000-02-21");
            creatures[1] = new Elf("Elf", birthDate, 100,  50);

        } catch (ParseException e) {
            System.out.println("Failed to create Elf: " + e.getMessage());
        }


        try {
            /* Creates Orc. */
            Date birthDate = new SimpleDateFormat("yyyy.MM.dd").parse("2002.03.23");
            creatures[2] = new Orc("Orc", birthDate, 100, 30);

        } catch (ParseException e) {
            System.out.println("Failed to create Orc: " + e.getMessage());
        }

        System.out.println("\n         Creature Details and Actions                    ");

        for (Creature c : creatures) {
            if (c == null) continue;

            try {
                System.out.println("\n");
                c.getDetails();
                System.out.println("Class: " + c.getClass().getSimpleName());

                if (c instanceof Dragon) {
                    ((Dragon) c).breathFire(creatures[1]);
                } else if (c instanceof Elf) {
                    ((Elf) c).castSpell(creatures[2]);
                } else if (c instanceof Orc) {
                    ((Orc) c).berserk(creatures[0]);
                }
            } catch (Exception e) {
                System.out.println("Error during creature: " + e.getMessage());
            }
        }

    }
}







