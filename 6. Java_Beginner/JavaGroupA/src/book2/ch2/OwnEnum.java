package book2.ch2;

public class OwnEnum
{
    public enum GameConsoles {PLAYSTATION, XBOX, WII, NINTENDO_DS}

    public static void main(String[] args)
    {
        GameConsoles types;
        types = GameConsoles.WII;
        System.out.println("The best gaming console is of all time is " + types);
    }
}
