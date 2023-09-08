package book5.ch1;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownAppNew
{
    public static void main(String[] args)
    {
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(25);

        Runnable flood, ignition, liftoff;
        flood = new LaunchEventNew("FLOOD THE PAD!!");
        ignition = new LaunchEventNew("START ENGINES!!");
        liftoff = new LaunchEventNew("WE HAVE LIFTOFF!!");

        for (int t = 20; t >= 0; t--)
        {
            pool.schedule(new CountDownClockNew(t),(long)(20 - t), TimeUnit.SECONDS);
        }
        pool.schedule(flood, 3L, TimeUnit.SECONDS);
        pool.schedule(ignition, 13L, TimeUnit.SECONDS);
        pool.schedule(liftoff, 19L, TimeUnit.SECONDS);
        pool.shutdown();
    }
}
