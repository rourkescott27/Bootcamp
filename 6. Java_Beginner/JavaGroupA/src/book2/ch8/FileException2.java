package book2.ch8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileException2
{
    public static void main(String[] args)
    {
        try
        {
            openFile("C:/test.txt");
        } catch (FileNotFoundException err)
        {
            System.out.println("File not found");
        }
    }

    public static void openFile(String fileName) throws FileNotFoundException
    {
        FileInputStream f = new FileInputStream(fileName);
    }
}
