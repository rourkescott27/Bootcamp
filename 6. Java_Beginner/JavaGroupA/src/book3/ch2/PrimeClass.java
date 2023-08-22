package book3.ch2;

import java.util.Scanner;

public class PrimeClass
{
    private Scanner sc = new Scanner(System.in);
    public int x = getX();
    private int getX()
    {
        System.out.print("Enter the starting value for x: ");
        return sc.nextInt();
    }

    public static void main(String[] args)
    {
        PrimeClass pc = new PrimeClass();
    }
}
