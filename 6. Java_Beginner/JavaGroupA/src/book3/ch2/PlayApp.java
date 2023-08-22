package book3.ch2;

public class PlayApp
{
    public static void main(String[] args)
    {
        Player p1 = new Player();
//        p1.health = 10; Not private
        p1.setHealth(10); // Private
        System.out.println("HP of player 1 is -> " + p1.getHealth());
        Player p2 = new Player();
        p2.setHealth(70);
        System.out.println("HP of player 2 is -> " + p2.getHealth());
    }
}
