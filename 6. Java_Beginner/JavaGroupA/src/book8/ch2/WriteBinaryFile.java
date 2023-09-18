package book8.ch2;

import java.io.*;

public class WriteBinaryFile
{
    public static void main(String[] args)
    {
        Movie[] movies = getMovies();
        DataOutputStream outputStream = openOutputStream("C:\\Users\\Rourke Scott\\Documents\\1) Bootcamp\\6. Java_Beginner\\JavaGroupA\\src\\book8\\ch2\\movies2.dat");

        for (Movie m : movies)
        {
            writeMovie(m, outputStream);
        }
        closeFile(outputStream);
    }

    private static void closeFile(DataOutputStream outputStream)
    {
        try{
           outputStream.close();

        }catch (IOException e){
            System.out.println("I/O EXCEPTION!! " + e);
            System.exit(0);
        }
    }


    private static void writeMovie(Movie m, DataOutputStream outputStream)
    {
        try
        {
         outputStream.writeUTF(m.title);
         outputStream.writeInt(m.year);
         outputStream.writeDouble(m.price);
        }catch (IOException e)
        {
            System.out.println("I/O EXCEPTION!! " + e);
            System.exit(0);
        }
    }

    private static DataOutputStream openOutputStream(String name)
    {
        DataOutputStream outputStream = null;
        try
        {
            File file = new File(name);
            outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            return outputStream;

        } catch (IOException e)
        {
            System.out.println("I/O EXCEPTION " + e);
            System.exit(0);
        }
        return outputStream;
    }


    private static Movie[] getMovies()
    {
        Movie[] movies = new Movie[10];

        movies[0] = new Movie("It's a Wonderful Life", 1946, 14.95);
        movies[1] = new Movie("Young Frankenstein", 1974, 16.95);
        movies[2] = new Movie("Star Wars", 1977, 17.95);
        movies[3] = new Movie("The Princess Bride", 1987, 16.95);
        movies[4] = new Movie("Glory", 1989, 14.95);
        movies[5] = new Movie("The Game", 1997, 14.95);
        movies[6] = new Movie("Shakespeare in Love", 1998, 19.95);
        movies[7] = new Movie("Zombieland", 1997, 18.95);
        movies[8] = new Movie("The King's Speech", 1997, 19.95);
        movies[9] = new Movie("Star Trek Into Darkness", 1997, 19.95);
        return movies;
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
