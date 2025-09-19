import java.util.Date;

public class Main {

    public static void main(final String[] args)
    {
        final Creature c1;

        c1 = new Creature("MINSU KIM", new Date(102,2,18), 100);

        c1.getDetails();
    }
}
