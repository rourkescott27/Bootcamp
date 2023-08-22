package book3.ch2;

public class Player
{
    private int health;

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        if (health > 60 && health <= 100)
        {
            this.health = health;
        } else
        {
            System.out.println("Your HP is too low, heal up first!");
        }
//        if (h < 0)
//        {
//            health = 0;
//        } else if (h > 100)
//        {
//            health = 100;
//        } else
//            health = h;
    }
}
