package book2.ch8;

import java.io.*;

public class FileException1
{
    public static void main(String[] args)
    {
        openFile("C:/test.txt");
    }
    public static void openFile(String fileName)
    {
        try
        {
            FileInputStream f = new FileInputStream(fileName);

        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
