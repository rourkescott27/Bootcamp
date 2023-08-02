package book2.ch2;

import java.util.Scanner;

public class ScannerApp {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.print("Enter an integer: ");
        if (sc.hasNextInt()) {
            int x = sc.nextInt();
            System.out.println("You entered " + x + ".");
        } else {
            System.out.println("Incorrect! No integer detected!");
            System.out.println("Please rerun app and try again!");
        }
    }
}
