package book5.ch1;

import java.sql.Time;

//  ABORTED VERSION
class LaunchEvent implements Runnable
{
    private int start;
    private String message;
    TimeMonitor tm;

    public LaunchEvent(int start, String message, TimeMonitor monitor)
    {
        this.start = start;
        this.message = message;
        this.tm = monitor;
    }

    public void run()
    {
        boolean eventDone = false;
        boolean aborted = false;

        while (!eventDone)
        {
            try
            {
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
                aborted = true;
            }
            if (tm.getTime() <= start)
            {
                System.out.println(this.message);
                eventDone = true;
                System.out.println("ABORT!! ABORT!!");
                tm.abortCountDown();
            }
            if (Thread.interrupted())
            {
                aborted = true;
            }
            if (aborted)
            {
                System.out.println("Aborting " + message);
                break;
            }
        }
    }
}


//  COORDINATED VERSION
/*
class LaunchEvent implements Runnable
{
    private int start;
    private String message;
    TimeMonitor tm;

    public LaunchEvent(int start, String message, TimeMonitor monitor)
    {
        this.start = start;
        this.message = message;
        this.tm = monitor;
    }

    public void run()
    {
        boolean eventDone = false;
        while (!eventDone)
        {
            try
            {
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
            }

            if (tm.getTime() <= start)
            {
                System.out.println(this.message);
                eventDone = true;
            }
        }
    }
}
*/


/*
//VERSION 1
public class LaunchEvent implements Runnable
{
    private int start;
    private String message;


//    Constructor
    public LaunchEvent(int start, String message)
    {
        this.start = start;
        this.message = message;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(20000 - (start * 1000));
        } catch (InterruptedException e)
        {}
        System.out.println(message);
    }
}
*/
