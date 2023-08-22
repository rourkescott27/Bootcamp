package book2.ch7;

public class RandomNumber
{
    public static void main(String[] args)
    {
        int RandomNum = getRandomNumber();
        System.out.println("The random number is: " + RandomNum);
    }

    public static int getRandomNumber()
    {
        int num = (int) Math.floor(Math.random() * 10 + 1);
        return num;
    }
}
