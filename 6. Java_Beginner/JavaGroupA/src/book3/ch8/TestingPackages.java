package book3.ch8;

import com.gmail.rourkescott27.Console;

import java.util.ArrayList;

public class TestingPackages
{
    public static void main(String[] args)
    {
//        ArrayList array1 = new ArrayList();
        while (Console.askYorN("Keep going?"))
        {
            System.out.println("D'oh!");
        }
    }
}
