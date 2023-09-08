package markReview.Chapter_1.Sync;

import markReview.Chapter_1.CountDownV1.CountDownClock;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class DoTwoThings
{
    ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(2);
    CountDownClock clock = new CountDownClock();

    DoTwoThings()
    {
        pool.execute(clock);
        pool.execute(clock);
        pool.shutdown();
    }

}
