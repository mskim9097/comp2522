import java.util.Random;
import java.util.Scanner;

public class GuessingGame
{
    public static void main(final String[] args)
    {
        final  Scanner s;
        final  Random  r;
        int    computerNumber;
        int    userNumber;
        String userInput;

        s = new Scanner(System.in);
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
