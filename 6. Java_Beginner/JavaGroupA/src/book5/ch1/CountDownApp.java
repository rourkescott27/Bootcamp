package book5.ch1;

import java.util.ArrayList;

public class CountDownApp
{
    public static void main(String[] args)
    {
        CountDownClock clock = new CountDownClock(20);
        ArrayList<Runnable> events = new ArrayList<>();

        events.add(new LaunchEvent(16, "FLOOD THE PAD!!", clock));
        events.add(new LaunchEvent(6, "START ENGINES!!", clock));
        events.add(new LaunchEvent(0, "WE HAVE LIFTOFF!!", clock));

        clock.start();

        for (Runnable e : events)
        {
            new Thread(e).start();
        }
    }
}

/*
public class CountDownApp
{
    public static void main(String[] args)
    {
//  Version 1
        Thread clock = new CountDownClock();
        clock.start();

//  Version 2

        Thread clock = new CountDownClock();
        Runnable flood, ignition, liftoff;
        flood = new LaunchEvent(10, "FLOOD THE PAD!!");
        ignition = new LaunchEvent(6, "START ENGINES!!");
        liftoff = new LaunchEvent(0, "WE HAVE LIFTOFF!!");

        clock.start();

        new Thread(flood).start();
        new Thread(ignition).start();
        new Thread(liftoff).start();

    }
}
*/
