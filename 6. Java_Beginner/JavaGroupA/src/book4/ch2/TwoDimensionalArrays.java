package book4.ch2;

import java.text.NumberFormat;

public class TwoDimensionalArrays
{

    public static void main(String[] args)
    {
        double[][] sales = new double[5][4];
        for (int y = 0; y < 5; y++)
        {
            for (int r = 0; r < 4; r++)
            {
                sales[y][r] = Math.floor(Math.random() * 2000000 + 100000);
            }
        }
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        System.out.println("\tNorth\t\tSouth\t\tEast\t\tWest");
        int year = 2004;
        for (int y = 0; y < 5; y++)
        {
            System.out.print(year + "\t");
            for (int region = 0; region < 4; region++)
            {
                System.out.print(cf.format(sales[y][region]));
                System.out.print("\t");
            }
            year++;
            System.out.println();
        }

    }
}
