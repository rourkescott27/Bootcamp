package book2.ch8;

import java.util.InputMismatchException;

public class TestingException
{
    public static void main(String[] args)
    {
        try
        {
            int a = 10;
            int b = 0;
            int c = a / b;
        } catch (InputMismatchException e)
        {
            e.printStackTrace(System.out);
        } catch (Exception e)
        {
            e.printStackTrace(System.out);
        } finally
        {
            System.out.println("Testing Finally");
        }
    }
}
