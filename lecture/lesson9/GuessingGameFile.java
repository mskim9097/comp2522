import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class GuessingGameFile
{
    public static void main(final String[] args)
            throws FileNotFoundException
    {
        final  Scanner s;
        final  Random  r;
        final File f;
        int    computerNumber;
        int    userNumber;
        String userInput;

        f = new File("guesses.txt");
        s = new Scanner(f);
        // s.useDelimiter("\t");
        r = new Random();

        computerNumber = r.nextInt(10) + 1;

        while(true)
        {
            System.out.println("Type a number 1-10 or Q to quit: ");

            if(s.hasNext()) // "freezes" here until ENTER is pressed
            {
                if(s.hasNextInt())
                {
                    userNumber = s.nextInt();

                    if(userNumber == computerNumber)
                    {
                        System.out.printf("CORRECT; you typed %d and computer had %d\n",
                                userNumber,
                                computerNumber);

                        computerNumber = r.nextInt(10) + 1;
                    }
                    else if(userNumber > 10)
                    {
                        System.out.printf("OUT OF BOUNDS TOO HIGH; you typed %d and computer had %d\n",
                                userNumber,
                                computerNumber);
                    }
                    else if(userNumber < 1)
                    {
                        System.out.printf("OUT OF BOUNDS TOO LOW; you typed %d and computer had %d\n",
                                userNumber,
                                computerNumber);
                    }
                    else
                    {
                        System.out.printf("WRONG; you typed %d and computer had %d\n",
                                userNumber,
                                computerNumber);
                    }
                    // s.next();
                }
                else // user typed something, but not an int
                {
                    userInput = s.next();
                    if(userInput.equalsIgnoreCase("Q"))
                    {
                        System.out.println("Thanks bye");
                        break;
                    }
                    else
                    {
                        System.out.println("ERROR; try again");
                    }
                }
            }
        }
        s.close();
    }
}
