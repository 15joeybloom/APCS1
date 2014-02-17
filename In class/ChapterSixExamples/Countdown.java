
/**
 * Write a description of class Countdown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.Timer;
import java.awt.event.*;

public class Countdown implements ActionListener
{
    private int n;
    public Timer t;
    public static void main(String[] args)
    {
        Countdown listener = new Countdown();
        listener.t = new Timer(100, listener);
        listener.t.start();
        
    }
    public Countdown()
    {
        n = 100;
    }
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(n);
        n--;
        if(n == 0)
        {
            System.out.println("BOOM!");
            t.stop();
        }
    }
}
