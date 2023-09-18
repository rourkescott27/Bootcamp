package book8.ch1;

import java.io.File;

public class FileTest
{
    public static void main(String[] args)
    {
//------------------CHECK IF FILE EXISTS----------------------\\
        /*File f = new File("C:\\book8\\hello.txt");

        if(!f.exists())
        {
            System.out.println("Exists");
        }*/

//-----------------CREATE A NEW FILE------------------\\
        /*File f = new File("C:\\book8\\hits35.log");
        try
        {
            if (f.createNewFile())
            {
                System.out.println("FILE HAS BEEN SUCCESSFULLY CREATED");
            } else {
                System.out.println("FILE COULD NOT BE CREATED");
            }
        } catch (Exception e) {
            System.out.println("ERROR CREATING FILE ---> " + e);
        }*/

//----------------LOOPS THROUGH DIRECTORY TO SHOW FILES-------------------\\
        /*String filePath = "C:\\Users\\Rourke Scott\\Documents\\1) Bootcamp\\6. Java_Beginner\\JavaGroupA\\src";
        File dir = new File(filePath);
        if (dir.isDirectory())
        {
            File[] files = dir.listFiles();
            for (File f: files)
            {
                System.out.println(f.getName());
            }
        }*/

//---------------RENAMING FILES-----------------\\

        /*File f = new File("C:\\book8\\helloNew.txt");
        if (f.renameTo(new File(("C:\\book8\\helloNewer.txt"))))
        {
            System.out.println("FILE HAS BEEN SUCCESSFULLY RENAMED");
        } else {
            System.out.println("FAILED TO RENAME FILE!!");
        }*/

//------------------DELETING FILES---------------------\\

        /*File f = new File("C:\\book8\\hits35.log");
        if (f.delete())
        {
            System.out.println("FILE HAS BEEN DELETED!");

        }else {
            System.out.println("FILE COULD NOT BE DELETED!!");
        }*/
    }
}
