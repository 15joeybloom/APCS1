/*
 * Joey  Bloom
 * In-class Example 4
 * Shows an alternative means of collecting input
 * from the user
 */

import javax.swing.JOptionPane;

public class DialogViewerTwo
{
    public static void main(String[] args)
    {
        String name = 
            JOptionPane.showInputDialog("What is your name?");
        System.out.println(name);
        System.exit(0);
    }
}
