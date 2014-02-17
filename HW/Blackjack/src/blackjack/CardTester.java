/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author 151bloomj
 * Assignment #2
 * Tests Card
 */
public class CardTester
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        Card threeHearts = new Card(3,Card.HEARTS);
        Card alsoThreeHearts = new Card(threeHearts);
        System.out.println(threeHearts + " " + alsoThreeHearts);
        System.out.println(threeHearts.getValue());
        ImageIO.write(threeHearts.getBufferedImage(),"png",new File("threeHearts.png"));

        Card ace = new Card(Card.SOFT_ACE,Card.SPADES);
        System.out.println(ace + " " + ace.getValue());
        ImageIO.write(ace.getBufferedImage(),"png",new File("ace.png"));
        ace.hardenAce();
        System.out.println("Hardened: " + ace + " " + ace.getValue());
        ImageIO.write(ace.getBufferedImage(),"png",new File("ace2.png"));
    }
}
