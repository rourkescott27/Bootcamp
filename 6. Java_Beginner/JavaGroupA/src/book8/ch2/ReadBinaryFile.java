package book8.ch2;

import java.io.*;
import java.text.NumberFormat;

public class ReadBinaryFile
{
    public static void main(String[] args)
    {
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        DataInputStream inputStream = getStream("C:\\Users\\Rourke Scott\\Documents\\1) Bootcamp\\6. Java_Beginner\\JavaGroupA\\src\\book8\\ch2\\movies2.dat");
        boolean eof = false;

        while (!eof)
        {
            Movie movie = readMovie(inputStream);
            if (movie == null)
            {
                eof = true;
            } else
            {
                String msg = Integer.toString(movie.year);
                msg += ": " + movie.title;
                msg += "(" + cf.format(movie.price) + ")";
                System.out.println(msg);
            }
        }
        closeFile(inputStream);
    }

    private static void closeFile(DataInputStream inputStream)
    {
        try
        {
            inputStream.close();
        } catch (IOException e)
        {
            System.out.println("ERROR CLOSING FILE " + e);
        }
    }

    private static DataInputStream getStream(String name)
    {
        DataInputStream inputStream = null;
        try
        {
            File file = new File(name);
            inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));

        } catch (FileNotFoundException e)
        {
            System.out.println("THE FILE DOESN'T EXIST");
            System.exit(0);
        }
        return inputStream;
    }

    private static Movie readMovie(DataInputStream inputStream)
    {
        String title = "";
        int year = 0;
        double price = 0.0;

        try
        {
            title = inputStream.readUTF();
            year = inputStream.readInt();
            price = inputStream.readDouble();

        } catch (EOFException e)
        {
            return null;

        } catch (IOException e)
        {
            System.out.println("I/O ERROR!");
            System.exit(0);
        }
        return new Movie(title, year, price);
    }


}
