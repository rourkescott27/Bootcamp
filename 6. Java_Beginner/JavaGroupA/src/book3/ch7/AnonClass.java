package book3.ch7;

public class AnonClass
{
    public static void main(String[] args)
    {

        Ball b1 = () ->  System.out.println("You missed the ball :( (Lambda)"); // Lambda expression
        b1.hit();

        Ball b2 = new Baseball();
        b2.hit();

        // Anonymous Class
         Ball b = new Ball()
        {
            @Override
            public void hit()
            {
               System.out.println("Can you hit an anonymous ball ?? (Anonymous Class)");
            }
        };
        b.hit();

    }
}

class Baseball implements Ball
{
    @Override
    public void hit()
    {
        System.out.println("Good luck hitting a concrete ball (Concrete Class)");
    }
}

interface Ball
{
    void hit();
}
