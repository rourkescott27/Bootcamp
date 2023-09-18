package book8.ch2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileStreams
{
    public static void main(String[] args)
    {
        try
        {
            File f = new File("C:\\book8\\movie.txt");
            BufferedReader in = new BufferedReader(new FileReader(f));

            String line = in.readLine();
            while (line != null)
            {
                System.out.println(line);
                line = in.readLine();
            }
        } catch (Exception e)
        {
            System.out.println("Error " + e);
        }

    }
}
