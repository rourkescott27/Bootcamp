package book2.ch8;

public class DivideByZero
{
    public static void main(String[] args)
    {
        int a = 5;
        int b = 0;
//        System.out.println(a / b);
        try
        {
            int c = a / b;
        } catch (ArithmeticException e)
        {
            System.out.println("Oops, you can't divide by zero");
//            e.printStackTrace();
        }
    }
}
