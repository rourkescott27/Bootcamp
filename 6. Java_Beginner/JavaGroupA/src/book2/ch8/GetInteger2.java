package book2.ch8;

import java.util.*;

public class GetInteger2
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
        while (!sc.hasNextInt())
        {
            sc.nextLine();
            System.out.println("That's not an integer. \nTry again: ");
        }
        return sc.nextInt();
    }
}
