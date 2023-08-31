package book3.ch7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TickTockInner
{
    private String tickMessage = "Tick...";
    private String tockMessage = "Tock...";

    public static void main(String[] args)
    {
        TickTockInner t = new TickTockInner();
        t.go();
    }

    private void go()
    {
        Timer t = new Timer(1000, new Ticker());
        t.start();

        JOptionPane.showMessageDialog(null, "Click OK to exit program");
        System.exit(0);
    }

    class Ticker implements ActionListener
    {
        private boolean tick = true;

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(tick)
            {
                System.out.println(tickMessage);
            }
            else
            {
                System.out.println(tockMessage);
            }
            tick = !tick;
        }
    }

}
