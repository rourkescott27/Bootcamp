package book4.ch2;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int[] lotto = new int[5];
        for (int i = 0; i < 5; i++)
        {
            lotto[i] = (int)( Math.floor((Math.random() * 10 - 1) + 1));
        }
        Arrays.sort(lotto);
        System.out.println("Enter a lucky number between 1 and 10 --|>");
        int lucky = sc.nextInt();
        int foundAt = Arrays.binarySearch(lotto, lucky);
        if (foundAt > -1)
        {
            System.out.println("My number came up!");
        } else
        {
            System.out.println("Today's not my lucky day :(");
        }


    }
}
