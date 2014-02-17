
/**
 * @author Joey Bloom
 * Assignment #18
 * Tests the Easter class
 */
public class EasterTester
{
    public static void main(String[] args)
    {
        Easter mainArgs = new Easter(2001);
        Easter two = new Easter(2012);
        Easter three = new Easter(2013);
        System.out.println(mainArgs);
        System.out.println(two);
        System.out.println(three);
    }
}

/*
Output: 
In 2001, Easter falls on 4-15
In 2012, Easter falls on 4-8
In 2013, Easter falls on 3-31

 */