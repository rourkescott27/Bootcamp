package book2.ch5;

import java.util.Scanner;

public class GetABet {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int bankBalance;
        int bet;
        System.out.println("Want to bet on the horses ? Answer one question before you bet!");

        do {
            System.out.print("\nHow much money do you have in your bank account ?(Asking for a friend)\n");
            bankBalance = sc.nextInt();
            System.out.print("\nHow much do you want to bet ?\n");
            bet = sc.nextInt();
        } while ((bet <= 0) || (bet > bankBalance)); {
            System.out.println("You have enough money to bet on the horses.");
        }
    }
}
