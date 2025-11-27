import java.util.Random;
import java.util.Scanner;

public class GuessingGame2
{
    public static void main(final String[] args) {
        final Random rand;

        rand = new Random();

        try(final Scanner s = new Scanner(System.in)) {
            String line;
            int target;
            int userGuess;

            line = "";
            target = rand.nextInt(10) + 1;

            while(!line.equalsIgnoreCase("Q")) {
                System.out.println("Enter a number: ");
                if(s.hasNext()) {
                    if (s.hasNextInt()) {
                        userGuess = s.nextInt();
                        if (userGuess == target) {
                            System.out.println("Right");
                            target = rand.nextInt(10) + 1;
                        } else {
                            System.out.println("Wrong");
                        }
                    } else {
                        line = s.next();
                    }




                }
            }
        }
    }
}
