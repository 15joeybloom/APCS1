
/*
 * Joey Bloom
 * Assignment #13
 * Contains the main method that runs
 * the entire program
 */
import javax.swing.JFrame;
import java.util.Scanner;
public class HouseViewerTextInput
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("A Very Fine House");
        Scanner in = new Scanner(System.in);
        frame.setSize(300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        System.out.println("Where do you want your house?");
        System.out.print("X:");
        int x = in.nextInt();
        System.out.print("Y:");
        int y = in.nextInt();
        
        HouseComponent c = new HouseComponent(x,y);
        frame.add(c);
        
        frame.setVisible(true);
    }
}

