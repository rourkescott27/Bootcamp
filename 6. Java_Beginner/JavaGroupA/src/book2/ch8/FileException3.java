package book2.ch8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileException3
{
    public static void main(String[] args) throws FileNotFoundException
    {
        openFile("C:/test.txt");
    }

    public static void openFile(String fileName) throws FileNotFoundException
    {
        FileInputStream f = new FileInputStream(fileName);
    }
}
