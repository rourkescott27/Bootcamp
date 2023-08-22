package book2.ch8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileException4
{
    public static void main(String[] args)
    {
        try
        {
            openFile("C:/test.txt");
        } catch (FileNotFoundException err)
        {
            /*Swallowing the error*/
//            System.out.println(err);
        }
    }

    public static void openFile(String fileName) throws FileNotFoundException
    {
        FileInputStream f = new FileInputStream(fileName);
    }
}
