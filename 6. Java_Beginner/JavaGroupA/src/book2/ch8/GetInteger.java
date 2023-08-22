package book2.ch8;

import java.util.*;

public class GetInteger
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.print("Enter an integer: ");
        int i = getAnInteger();
        System.out.println("You entered " + i);
    }

    public static int getAnInteger()
    {
        while (true)
        {
            try
            {
                return sc.nextInt();
            } catch (InputMismatchException e)
            {
                sc.next();
                System.out.print("That's not an integer. \nTry again: ");
            }
        }
    }
}
