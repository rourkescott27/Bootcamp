package book3.ch7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TickTockAnon
{
    private String tickMessage = "Tick...";
    private String tockMessage = "Tock...";

    public static void main(String[] args)
    {
        TickTockAnon t = new TickTockAnon();
        t.go();
    }

    private void go()
    {
        Timer t = new Timer(1000, new ActionListener()
        {
            private boolean tick = true;

            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (tick)
                {
                    System.out.println(tickMessage);
                } else
                {
                    System.out.println(tockMessage);
                }
                tick = !tick;

            }
        });
        t.start();
        JOptionPane.showMessageDialog(null, "Click OK to exit program");
        System.exit(0);
    }

}