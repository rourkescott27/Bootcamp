package book5.ch3;

import java.util.Scanner;

public class Factorial1
{
    private static Scanner sc = new Scanner(System.in);
    private static long factorial(int n)
    {
        long f = 1;
        for (int i = 1; i <= n; i++)
        {
            System.out.println(f);
            f = f * i;
        }
        return f;
    }
    public static void main(String[] args)
    {
        System.out.println("Enter a number to get the factorial: ");
        int n = sc.nextInt();
        long fact;
        fact = factorial(n);
        System.out.println("The factorial of " + n + " is "+ fact);
    }
}
