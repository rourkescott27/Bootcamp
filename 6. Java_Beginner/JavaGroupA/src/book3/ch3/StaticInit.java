package book3.ch3;

public class StaticInit
{
    public static int x;

    static
    {
        x = 32;
        System.out.println("X is " + x);
    }

    public StaticInit()
    {
        System.out.println("IN CONSTRUCTOR!!");
    }

    public static void main(String[] args)
    {
        System.out.println(StaticInit.x);
    }
}
