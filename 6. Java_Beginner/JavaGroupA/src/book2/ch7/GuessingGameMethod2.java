package book2.ch7;


import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessingGameMethod2
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Let's play a guessing game!");
        do
        {
            playAround();
        } while (askForAnotherRound());
        {
            System.out.println("\nThank you for playing.\n");
        }
    }

    public static void playAround()
    {
//        boolean validInput;
        int number, guess;
//        String answer;
        number = getRandomNumber(1, 10);

//        Get the guess from the user
        System.out.println("\nMake a random guess between 1 - 10.\n");
        System.out.print("What do you think the random number is ?\n");
        guess = getGuess();

        if (guess == number)
        {
            System.out.println("Well done you guessed the correct number!!");
        } else
        {
            System.out.println("Unlucky, you guessed the wrong number, the number was " + number + "\nPlease try again.");
        }
    }

    //    Generating random number
    public static int getRandomNumber(int min, int max)
    {
        return (int) (Math.random() * max) + min;
    }

    //    Checking if the users guess is valid
    static int getGuess()
    {
        do
        {
            int guess = 0;
            try
            {
//                sc.close();
                guess = sc.nextInt();
            } catch (InputMismatchException e)
            {
                System.out.println("\nInvalid input!! Please enter a number.\n");
            } catch (Exception e)
            {
                System.out.println("Your input resulted in the following error: " + e.getMessage());
//                e.printStackTrace();
                System.exit(0);
            }

            if ((guess <= 0) || (guess > 10))
            {
                System.out.println("You can only pick a number between 1 - 10 \nPlease try again!");
            } else
            {
                return guess;
            }
            sc.next();
        } while (true);

    }

    static boolean askForAnotherRound()
    {
        System.out.println("\nWant to play again ? (Y or N) ");
        do
        {
            String answer;
            answer = sc.next();
            if (answer.equalsIgnoreCase("Y"))
            {
                return true;
            } else if (answer.equalsIgnoreCase("N"))
            {
                return false;
            }
        } while (true);
    }
}

