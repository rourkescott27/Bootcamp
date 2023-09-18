package book8.ch4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest
{

    public static void main(String[] args)
    {
        getconnection();
    }

    private static Connection getconnection()
    {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Movies";
            String user = "root";
            String pw = "C6$1%dHP1lh(4|`";
            con = DriverManager.getConnection(url, user, pw);
        } catch (ClassNotFoundException e)
        {
            System.out.println(e);
            System.exit(0);
        } catch (SQLException e)
        {
            System.out.println(e);
            System.exit(0);
        }
        System.out.println("CONNECTION SUCCESSFUL");
        return con;
    }
}

