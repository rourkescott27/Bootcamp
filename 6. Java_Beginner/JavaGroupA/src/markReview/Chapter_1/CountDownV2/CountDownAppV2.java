package markReview.Chapter_1.CountDownV2;

import java.util.ArrayList;

public class CountDownAppV2 {
    public static void main(String[] args) {

        CountDownClockV2 clock = new CountDownClockV2(20);

        ArrayList<Runnable> events =
                new ArrayList<Runnable>();

        events.add(new LaunchEventV2(16, "Flood the pad!", clock));
        events.add(new LaunchEventV2(6, "Start engines!", clock));
        events.add(new LaunchEventV2(0, "Liftoff!", clock));
        clock.start();

        for (Runnable e : events) {
            new Thread(e).start();
        }

    }
}