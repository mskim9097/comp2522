import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Canada
{
    private static List<Province> provinces;
    public static final int MAX_PERCENTAGE;

    static
    {
        provinces = new ArrayList<>();
        MAX_PERCENTAGE = 100;
    }

    public static void main(final String[] args)
    {
        provinces.add(new Province("British Columbia", 5466646));
        provinces.add(new Province("Alberta", 4645229));
        provinces.add(new Province("Saskatchewan", 1200540));
        provinces.add(new Province("Manitoba", 1443875));
        provinces.add(new Province("  ", 2000000));
        provinces.add(new Province("zzz", 1000000));
        provinces.add(new Province("Ontario", 15457075));
        provinces.add(null);
        provinces.add(new Province("Best province ever", 1000000));
        provinces.add(new Province("Quebec", 8814007));
        provinces.add(new Province("defacb", 8814007));
        provinces.add(new Province("New Brunswick", 826622));
        provinces.add(new Province("abc def", 8814007));
        provinces.add(new Province("saame", 1000000));
        provinces.add(new Province("same letter", 2000000));
        provinces.add(new Province("Kayak", 1000000));
        provinces.add(new Province("Ra cecar", 1000000));
        provinces.add(new Province("Nova Scotia", 1047803));
        provinces.add(new Province("primey", 13));
        provinces.add(new Province(null, 5000000));
        provinces.add(new Province("Prince Edward Island", 171790));
        provinces.add(new Province("Newfoundland and Labrador", 536291));
        provinces.add(new Province("villejason", 536291));
        provinces.add(new Province("jason ville", 536291));
        provinces.add(new Province("jasville  on", 536291));
        provinces.add(new Province("primey too", 17));
        provinces.add(new Province("Yukon", 44596));
        provinces.add(new Province("Northwest Territories", 44678));
        provinces.add(new Province("Nunavut", 40481));

        System.out.println("-------------------------");
        System.out.println("all provinces with their population, in alpha order");
        final List<Province> allExceptNulls = provinces.stream()
                        .filter(p->p!=null)
                        .filter(p->p.getName() != null && !p.getName().isBlank())
                        .sorted(Comparator.comparing((final Province p)->p.getName()))
                        .toList();
        allExceptNulls.forEach(System.out::println);



        System.out.println("-------------------------");
        System.out.println("same thing but in alpha order DESCENDING");
        final List<Province> all = filteredStream(provinces)
                .filter(p->!p.getName().isBlank())
                .sorted(Comparator.comparing(Province::getName).reversed())
                .toList();
        all.forEach(System.out::println);



        System.out.println("-------------------------");
        System.out.println("same as above but names in UPPER");
        final List<Province> upper  = filteredStream(provinces)
                .filter(p->!p.getName().isBlank())
                .sorted(Comparator.comparing(Province::getName).reversed())
                .map(p->new Province(p.getName().toUpperCase(), p.getPopulation()))
                .toList();
        upper.forEach(System.out::println);

        System.out.println("-------------------------");
        System.out.println("same thing but in POP DESCENDING; just loop don't store");
        provinces.stream()
                        .filter(p->p!=null)
                        .filter(p->p.getName() != null && !p.getName().isBlank())
                        .sorted(Comparator.comparing(Province::getPopulation).reversed())
                        .forEach(System.out::println);



        System.out.println("-------------------------");
        System.out.println("combined total pop all of provinces whose names starts with vowel");
        // the population is an integer
        // UNLESS...there are no provinces maybe that start with a vowel!!!
        final Optional<Integer> combinedPop;
        combinedPop = filteredStream(provinces)
                .filter(p->p.getName().matches("^[AEIOUaeiou].*"))
                .map(Province::getPopulation)
                .reduce(Integer::sum); // terminal operation
        combinedPop.ifPresent(total-> System.out.println("total pop: " + total));


        System.out.println("-------------------------");
        System.out.println("total pop");
        final int totalPop = filteredStream(provinces)
                .mapToInt(Province::getPopulation)
                        .sum();
        System.out.println(totalPop);


        System.out.println("-------------------------");
        System.out.println("all provinces with fewer than 250000, sorted by pop");
        final List<Province> small = filteredStream(provinces)
                .filter(p->p.getPopulation() < 250000)
                        .sorted(Comparator.comparing(Province::getPopulation))
                                .toList();
        System.out.println(small);
        System.out.println(small.size());

        System.out.println("-------------------------");
        System.out.println("all provinces with more than 250000, sorted by name");
        final List<Province> large = filteredStream(provinces)
                .filter(p->p.getPopulation() >= 250000)
                .sorted(Comparator.comparing(Province::getPopulation))
                .toList();
        System.out.println(large);
        System.out.println(large.size());



        System.out.println("-------------------------");
        System.out.println("percentage of provinces that are large");
        final double percent = 1.0 * large.size() / all.size() * MAX_PERCENTAGE;
        System.out.printf("%% of large provinces is %.1f%%\n", percent);



        System.out.println("-------------------------");
        System.out.println("provs with 1M+ sorted by pop in reverse pop order");
        final List<Province> million =
                provinces.stream()
                         .filter(p->p!=null && p.getName() != null && !p.getName().isBlank())
                                 .filter(p->p.getPopulation() >= 1000000)
                                         .sorted(Comparator.comparing(Province::getPopulation)).toList().reversed();
        million.forEach(System.out::println);



        System.out.println("-------------------------");
        System.out.println("largest pop");
        filteredStream(provinces)
                .max(Comparator.comparing(Province::getPopulation))
                        .ifPresent(largest-> System.out.println(largest));




        System.out.println("-------------------------");
        System.out.println("smallest pop");
        filteredStream(provinces)
                .min(Comparator.comparing(Province::getPopulation))
                .ifPresent(smallest-> System.out.println(smallest));



        System.out.println("-------------------------");
        System.out.println("provs with 3M-8M, reverse alpha order, UPPERCASED");
        final List<Province> mid = filteredStream(provinces)
                .filter(p->p.getPopulation() >= 3000000 && p.getPopulation() < 8000000)
                        .sorted(Comparator.comparing(Province::getName).reversed())
                                .toList();
        mid.forEach(p-> System.out.println(p.getName().toUpperCase() + " pop " +
                p.getPopulation()));

        System.out.println("-------------------------");
        System.out.println("group all provinces by their first letter");
        final Map<Character, List<Province>> pr = filteredStream(provinces)
                .filter(Objects::nonNull)  // or p->p!=null
                .filter(p->!p.getName().isBlank())
                .collect(Collectors.groupingBy(p->p.getName().charAt(0)));
        pr.forEach((key, value)->
        {
            System.out.println(key + ":");
            value.forEach(p -> System.out.println("\t" + p.getName()));
        });



        System.out.println("-------------------------");
        System.out.println("provinces ordered from shortest name to longest");
        System.out.println(filteredStream(provinces)
                .filter(p->!p.getName().isBlank())
        //        .sorted(Comparator.comparing(p->p.getName().length()))
        .sorted(Comparator.comparingInt(Canada::getProvinceNameLength))
        .toList());


        System.out.println("-------------------------");
        System.out.println("Longest name");
        final Optional<Province> l = filteredStream(provinces)
                .max(Comparator.comparingInt(p->p.getName().length()));
        l.ifPresent(p-> System.out.println("longest name is " + p.getName()));

        System.out.println("-------------------------");
        System.out.println("does canada have a province with 10M+?");
        final boolean has10M = filteredStream(provinces)
                .anyMatch(p->p.getPopulation() >= 10000000);
        System.out.println(has10M);


        System.out.println("-------------------------");
        System.out.println("does EVERY province have at least 50000?");
        System.out.println(filteredStream(provinces).allMatch(p->p.getPopulation() >= 50000));


        System.out.println("-------------------------");
        System.out.println("is there a province called Alberta?");
        System.out.println(filteredStream(provinces).anyMatch(p->p.getName().equalsIgnoreCase("alberta")));



        System.out.println("-------------------------");
        System.out.println("provinces that start with N:");
        filteredStream(provinces)
                .filter(p->p.getName().startsWith("N"))
                .forEach(System.out::println);


        System.out.println("-------------------------");

        System.out.println("percentage of canada's pop for each province:");



        System.out.println("-------------------------");
        System.out.println("the median province by pop (half the provinces have more, half have less than:");
        final Optional<Province> median;
        median = filteredStream(provinces)
                .sorted(Comparator.comparing(Province::getPopulation))
                        .skip(provinces.size()/2)
                                .findFirst();
        median.ifPresent(m-> System.out.println(m));




        System.out.println("-------------------------");
        System.out.println("average population (if not available, make it 0)");
        final double avg;
        avg = filteredStream(provinces)
                .mapToInt(Province::getPopulation)
                        .average()
                                .orElse(0);
        System.out.println(avg);



        System.out.println("-------------------------");

        System.out.println("provinces with 10+ characters in their name");




        System.out.println("-------------------------");
        System.out.println("provinces with a single-word name:"); // i.e. no spaces
        final List<Province> single;
        single = filteredStream(provinces)
                .filter(p->!p.getName().contains(" "))
                        .peek(p-> System.out.println("peeking at " + p)) // doesn't change anything; just useful for debugging
                        .toList();




        System.out.println("-------------------------");


        System.out.println("-------------------------");
        System.out.println("how many have A or a in their name?");
        System.out.println(filteredStream(provinces).filter(p->p.getName().toLowerCase().contains("a")).count());




        System.out.println("-------------------------");
        System.out.println("total pop of provinces starting with B");


        System.out.println("-------------------------");
        System.out.println("provinces listed in DESC order of their last letter of their name");
        final List<Province> last = filteredStream(provinces)
                .sorted(Comparator.comparing((final Province p)->p.getName().toLowerCase().charAt(p.getName().length()-1)).reversed())
                .toList();
        last.forEach(System.out::println);




        System.out.println("-------------------------");
        System.out.println("total pop of provinces whose name contains the same letter twice in a row:");




        System.out.println("-------------------------");
        System.out.println("names start with N, contain e, have 500000+, sort DESC by pop, and calculate their total pop");




        System.out.println("-------------------------");
        System.out.println("total pop of provinces that do not contain a vowel:");




        System.out.println("-------------------------");
        System.out.println("alt vowel and consonant");



        System.out.println("-------------------------");
        System.out.println("palindromes (ignore case, ignore whitespace");
        // Ra cecar
        // Racecar
        // racecar
        // racecar (forward) equals racecar (backward)
        final List<Province> pals = filteredStream(provinces)
                .filter(p->new StringBuilder(p.getName().replaceAll("\\s+", ""))
                        .reverse().toString().equalsIgnoreCase(p.getName().replaceAll("\\s+", "")))
                        .toList();
        pals.forEach(System.out::println);


        System.out.println("-------------------------");
        System.out.println("the FIRST province whose pop is prime");




        System.out.println("-------------------------");

        // anagram: same letters, mixed up (e.g. hello and elloh)
        System.out.println("anagrams, grouped together");


        System.out.println("-------------------------");
        System.out.println("3 vowels");


        System.out.println("-------------------------");
        System.out.println("provinces grouped by pop group: 0-1M, 1M-5M, 5M+");
        final Map<String, List<Province>> ranges =
                filteredStream(provinces)
                        .collect(Collectors.groupingBy(p->{

                            if(p.getPopulation() <= 1000000)
                            {
                                return "0-1M";
                            }
                            else if(p.getPopulation() > 5000000)
                            {
                                return "5M+";
                            }
                            else
                            {
                                return "1-5M";
                            }
                        }));
        ranges.forEach((range, group)-> System.out.println(range + ":::" + group));


        System.out.println("-------------------------");
        System.out.println("total number of times A or a appears in all province names");
    }

    // re-usable method for us to get a NON-NULL province STREAM
    private static Stream<Province> filteredStream(final List<Province> provinces)
    {
        return provinces.stream().filter(p->p!=null && p.getName() != null);
    }

    private static String sortedString(final String input)
    {
        final char[] chars;
        chars = input.replaceAll("\\s+", "").toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static int getProvinceNameLength(final Province p)
    {
        return p.getName().trim().length();
    }

    private static boolean isPrime(final int n)
    {
        if(n <= 1)
        {
            return false;
        }

        for(int i = 2; i < Math.sqrt(n); i++)
        {
            if(n % i == 0)
            {
                return false;
            }
        }
        return true;
    }

}
