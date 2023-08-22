package book2.ch5;

import java.util.Scanner;

public class NumberPhobia2 {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int number = 5;
        String input = "Y";
        while (input.equalsIgnoreCase("Y")){
            System.out.println(number + " ");
            System.out.println("Do you want to keep counting ?" + "(Y or N)");
            input = sc.nextLine();
            number += 2;
        }
        System.out.println("\nDone so soon !\n");
    }
}
