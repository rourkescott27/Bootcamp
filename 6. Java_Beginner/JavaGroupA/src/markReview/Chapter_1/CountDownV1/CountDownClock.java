package markReview.Chapter_1.CountDownV1;

public class CountDownClock extends Thread
{
    @Override
    public void run() {
        for (int t = 20; t > 0; t--)
        {
            System.out.println("T minus " + t);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
