/**
 * @author Joey Bloom
 * Assignment #34
 * a Die has a number that is shown and it can be rolled
 */

import java.util.Random;
import java.util.ArrayList;

public class Die implements Measurable
{
    private int number;
    private int sides;
    public Die(int s)
    {
        sides = s;
    }
    public void roll()
    {
        Random gen = new Random();
        number = gen.nextInt(sides) + 1;       
    }
    public double getMeasure()
    {
        return number;
    }
}