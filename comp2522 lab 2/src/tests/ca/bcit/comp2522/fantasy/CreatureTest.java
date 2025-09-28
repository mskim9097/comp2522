package ca.bcit.comp2522.fantasy;

import java.util.Date;

public class CreatureTest
{
    public static void main(final String[] args)
    {

        final Creature c1;
        final Creature c2;
        final Creature c3;

        final Date b1;
        final Date b2;
        final Date b3;

        b1 = new Date(100, 1, 21);
        b2 = new Date(101, 11, 2);
        b3 = new Date(119, 3, 8);

        c1 = new Dragon("Dragon", b1, 100, 100);
        c2 = new Elf   ("Elf",    b2, 100,  50);
        c3 = new Orc   ("Orc",    b3, 100,  10);

        System.out.println("=== Details (polymorphism) ===");
        c1.getDetails();
        c2.getDetails();
        c3.getDetails();

        System.out.println("\n=== Runtime Type Check ===");

        System.out.println("c1 is a " + c1.getClass().getSimpleName());
        if (c1 instanceof Dragon)
        {
            System.out.println("instanceof Dragon == true");
        }
        System.out.println("c2 is a " + c2.getClass().getSimpleName());
        if (c2 instanceof Elf)
        {
            System.out.println("instanceof Elf == true");
        }
        System.out.println("c3 is a " + c3.getClass().getSimpleName());
        if (c3 instanceof Orc)
        {
            System.out.println("instanceof Orc == true");
        }

        System.out.println();

        final Dragon d1;
        final Elf e1;
        final Orc o1;

        d1 = (Dragon)c1;
        e1 = (Elf)c2;
        o1 = (Orc)c3;

        System.out.println("=== Battle ===");
        System.out.println("=== Start of the first turn ===");

        try
        {
            d1.breatheFire(e1);
        }
        catch (LowFirePowerException e)
        {
            System.out.println(
                    "Breathe fire failed: " +
                    e.getMessage());
        }

        try
        {
            e1.castSpell(o1);
        }
        catch (LowManaException e)
        {
            System.out.println(
                    "Cast spell failed: " +
                    e.getMessage());
        }

        try
        {
            o1.berserk(d1);
        }
        catch (LowRageException e)
        {
            System.out.println(
                    "Berserk failed: " +
                    e.getMessage());
        }


        System.out.println("=== End of the first turn ===");
        d1.getDetails();
        e1.getDetails();
        o1.getDetails();
        System.out.println("=== Start of the second turn ===");

        try
        {
            o1.berserk(e1);
        }
        catch (LowRageException e)
        {
            System.out.println(
                    "Berserk failed: " +
                            e.getMessage());
        }

        try
        {
            e1.castSpell(d1);
        }
        catch (LowManaException e)
        {
            System.out.println(
                    "Cast spell failed: " +
                    e.getMessage());
        }

        try
        {
            d1.breatheFire(o1);
        }
        catch (LowFirePowerException e)
        {
            System.out.println(
                    "Breathe fire failed:" +
                    e.getMessage());
        }

        System.out.println("=== End of the second turn ===");
        d1.getDetails();
        e1.getDetails();
        o1.getDetails();

        System.out.println("=== Start of the third turn ===");

        d1.heal(50);
        e1.heal(50);
        o1.heal(50);

        d1.restoreFirePower(50);
        e1.restoreMana(50);

        try
        {
            o1.berserk(d1);
        }
        catch (LowRageException e)
        {
            System.out.println(
                    "Berserk failed: " +
                    e.getMessage());
        }

        System.out.println("=== End of the third turn ===");
        d1.getDetails();
        e1.getDetails();
        o1.getDetails();
    }
}
