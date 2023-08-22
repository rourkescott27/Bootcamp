package book2.ch8;

public class MyException
{
    public static void main(String[] args)
    {
        try
        {
            doSomething(true);
        } catch (Exception e)
        {
            System.out.println(e);
            System.out.println("Exception!");
        }
    }

    public static void doSomething(boolean t)
            throws Exception
    {
        String name = "N";
        if (name.length() < 2);
        {
            throw new Exception("MASSIVE ERROR!!!! PLEASE HELP!!!");
        }

    }
}
