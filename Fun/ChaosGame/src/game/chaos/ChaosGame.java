//package game.chaos;
///**
// * Write a description of class ChaosGame here.
// *
// * @author (your name)
// * @version (a version number or a date)
// */
//
//import javax.swing.JFrame;
//import java.util.Scanner;
//import javax.swing.JPanel;
//
//public class ChaosGame
//{
//    public static void main(String[] args)
//    {
//        JFrame frame = new JFrame();
//        Scanner in = new Scanner(System.in);
//
//        System.out.print( "Enter No. of sides on polygon (up to 8):" );
//        int numberOfSides = in.nextInt();
//        System.out.println( "Enter distance factor:" );
//        System.out.print( "\t Numerator:" );
//        int numerator = in.nextInt();
//        System.out.print( "\t Denominator:" );
//        int denominator = in.nextInt();
//
//        frame.setSize(520, 540);
//        frame.setTitle("Chaos Game");
//        frame.setResizable(false);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        JPanel triangle = new TriangleComponent( numberOfSides, numerator, denominator );
//        frame.add(triangle);
//
//        frame.setVisible(true);
//    }
//}
