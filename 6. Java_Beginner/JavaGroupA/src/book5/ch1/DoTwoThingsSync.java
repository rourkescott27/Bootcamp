package book5.ch1;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class DoTwoThingsSync
{
    ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(2);
    CountDownClockSync clock = new CountDownClockSync(20);

    DoTwoThingsSync()
    {
        pool.execute(clock);
        pool.execute(clock);
        pool.shutdown();
    }

    public static void main(String[] args)
    {
        new DoTwoThingsSync();
    }

}


