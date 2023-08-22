package book2.ch5;

public class LaunchControl
{
    public static void main(String[] args)
    {
        System.out.print("We are go for launch in T minus");
        for (int count = 10; count > 0; count--)
        {
            if (count == 8)
            {
                System.out.println("Ignition sequence start!");
            } else
            {
                System.out.println(count + "...");
            }

            try
            {
                Thread.sleep(1000);
            } catch (Exception e)
            {
                System.out.println(e);
            }

        }
        System.out.println("All engines running\nWe have liftoff!!!!!");
    }
}

