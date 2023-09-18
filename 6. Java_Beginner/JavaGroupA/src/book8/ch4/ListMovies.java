package book8.ch4;

import java.sql.*;
import java.text.NumberFormat;

public class ListMovies
{
    private static Connection con;

    public static void main(String[] args)
    {
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        ResultSet movies = getMovies();
        try
        {
            while (movies.next())
            {
                Movie m = getMovies(movies);
                String msg = Integer.toString(m.year);
                msg += ": " + m.title;
                msg += " (" + cf.format(m.price) + ")";
                System.out.println(msg);
            }
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        try
        {
            con.close();
            System.out.println("CONNECTION CLOSED!");
        } catch (Exception e)
        {
            System.out.println("ERROR CLOSING CONNECTION " + e);
        }
    }

    private static ResultSet getMovies()
    {
        Connection con = getConnection();
        try
        {
            Statement s = con.createStatement();
            String select = "Select title, year, price from movie order by year";
            ResultSet rows = s.executeQuery(select);
            return rows;
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return null;
    }

    private static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Movies";
            String user = "root";
            String pw = "C6$1%dHP1lh(4|`";
            con = DriverManager.getConnection(url, user, pw);
            System.out.println("CONNECTION SUCCESSFUL!");
        } catch (ClassNotFoundException e)
        {
            System.out.println(e);
            System.exit(0);
        } catch (SQLException e)
        {
            System.out.println(e);
            System.exit(0);
        }

        return con;
    }

    private static Movie getMovies(ResultSet movies)
    {
        try
        {
            String title = movies.getString("Title");
            int year = movies.getInt("Year");
            double price = movies.getDouble("Price");
            return new Movie(title, year, price);
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return null;
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
