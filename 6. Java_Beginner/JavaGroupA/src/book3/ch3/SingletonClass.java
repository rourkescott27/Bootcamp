package book3.ch3;

public class SingletonClass
{
    private static SingletonClass instance;

    private SingletonClass()
    {

    }

    public static SingletonClass getInstance()
    {
        if (instance == null)
            instance = new SingletonClass();
        return instance;
    }

    public static void main(String[] args)
    {
        SingletonClass s1 = SingletonClass.getInstance();
        SingletonClass s2 = SingletonClass.getInstance();
        if (s1 == s2)
        {
            System.out.println("The objects are the same.");
        } else
        {
            System.out.println("The objects are not the same.");
        }
    }
}
