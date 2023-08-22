package book2.ch6;

import java.util.Scanner;

public class SpaApp
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Welcome to the best Spa in town!\n\n");
        System.out.print("Choose between our wide selection of treatments: ");
        String s = sc.next();
        s = s.toLowerCase();
        char p = s.charAt(0);
        String details = "";

        switch (p)
        {
            case 'a':
                details += "\t\"Aromatherapy Massage.\"\t";
            case 'b':
                details += "\tBeer Bath Hydrotherapy, plus ... \n";
            case 'c':
                details += "\tAnti-Aging Facial, plus ... \n";
            case 'd':
                details +=
                        "\tInfrared Sauna, plus ... \n";
            case 'e':
                details += "\tZero Gravity Massage, plus ... \n";
            case 'f':
                details += "\tHot Stone Massage.\n";
                break;
            default:
                details = "Please choose only between the following options - A, B, C, D, E, F" ;
                break;
        }
        System.out.println("\nThat treatment includes:\n");
        System.out.println(details);
    }
}
