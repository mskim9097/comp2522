import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@FunctionalInterface
interface Formattable
{
    String format(String s);
}

class Notebook
{
    private final List<String> notes;

    Notebook()
    {
        notes = new ArrayList<>();
        notes.add("reAch out");
        notes.add("exiT strategy");
        notes.add("takE time and space to plan");
        notes.add("imposTEr syndrome: humility");
        notes.add("just DO it");
        notes.add("prove them wrong");
        notes.add("focus and be intentional");
        notes.add("manage YOUR career");

        final Formattable up;
        final Formattable lower;
        final Formattable reverse;
        final Formattable titlecase;

        final Function<String, String> upAgain;

        up = str -> str.toUpperCase();
        System.out.println(up.format("bcIt"));
        upAgain = (final String s) -> s.toUpperCase();

        System.out.println("again: " + upAgain.apply("bcIt"));

        lower = (final String st) -> {
            System.out.println("Lowercasing: " + st);
            return st.toLowerCase();
        };
        System.out.println(lower.format("bcIt"));

        reverse = s -> new StringBuilder(s)
                    .reverse().
                    toString();
        System.out.println(reverse.format("bcIt"));

        titlecase = s -> s.toUpperCase().charAt(0) + s.substring(1).toLowerCase();
        System.out.println(titlecase.format("bcIt"));


        display(notes, up);
        display(notes, lower);
        display(notes, reverse);
        display(notes, titlecase);
    }

    void display(final List<String> list,
                 final Formattable  f)
    {
        for (final String note : list)
        {
            System.out.println(f.format(note));
        }
    }

    public static void main(final String[] args)
    {
        new Notebook();
    }
}
