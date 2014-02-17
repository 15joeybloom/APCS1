/**
 * @author Joey Bloom
 * In class example (Chapter 7)
 * Plays with ArrayLists!
 */

import java.util.ArrayList;

public class ALTester
{
    public static void main(String[] args)
    {
        ArrayList<String> a = new ArrayList<String>();
        a.add("Alexis");
        a.add("Henry");
        a.add("Joey Boom");
        a.add("Jacob");
        System.out.println(a);
        a.add(2,"17");
        System.out.println(a);
    }
}