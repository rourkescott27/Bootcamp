package book8.ch1;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest
{
    public static void main(String[] args)
    {
        Path p = Paths.get("C:\\Users\\Rourke Scott\\Desktop\\Text Files\\HelloApp.txt");

           /* if (Files.exists(p))
            {
                System.out.println("FILE EXISTS!!");
            } else {
                System.out.println("FILE DOES NOT EXIST!!");
            }*/

            /*try
            {
                Files.createFile(p);
                System.out.println("FILE CREATED");

            } catch (Exception e)
            {
                e.printStackTrace();
            }*/

        Path c = Paths.get("C:\\");
        try{

            DirectoryStream<Path> stream = Files.newDirectoryStream(c, "*.txt");
            for (Path entry : stream){
//                System.out.println(entry.toString());
                System.out.println(entry);
            }
        } catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());

        }
    }
}
