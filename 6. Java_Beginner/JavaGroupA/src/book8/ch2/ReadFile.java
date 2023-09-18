package book8.ch2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

public class ReadFile
{
    public static void main(String[] args)
    {
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        BufferedReader in = getReader("C:\\book8\\movie.txt");
        Movie movie = readMovie(in);

        while (movie != null)
        {
            String msg = Integer.toString(movie.year);
            msg += ": " + movie.title;
            msg += " (" + cf.format(movie.price) + ")";
            System.out.println(msg);
            movie = readMovie(in);
        }

        try
        {
            in.close();
        } catch (Exception e)
        {
            System.out.println("ERROR CLOSING BUFFER WRITER!!");
        }

    }

    private static Movie readMovie(BufferedReader in)
    {
        String title;
        int year;
        double price;
        String line = "";
        String[] data;

        try
        {
            line = in.readLine();
        } catch (IOException e){
            System.out.println("I/O ERROR!");
            System.exit(0);
        }

        if (line == null){
            return null;
        }else {
            data = line.split("#");
            title = data[0];
            year = Integer.parseInt(data[1]);
            price = Double.parseDouble(data[2]);
            return new Movie(title, year, price);
        }
    }

    public static  BufferedReader getReader(String name)
    {
        BufferedReader in = null;
        try
        {
            File file = new File(name);
            in = new BufferedReader(new FileReader(file));
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
        return in;
    }

    private static class Movie
    {
        public String title;
        public int year;
        public double price;

        public Movie(String title, int year, double price)
        {
            this.title = title;
            this.year = year;
            this.price = price;
        }
    }
}
