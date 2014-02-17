package q2;

/**
 * @author Joey Bloom
 * 2006 Free Response Question 2
 * Tests Item, TaxableItem, and Vehicle
 */
public class Tester
{
    public static void main(String[] args)
    {
        TaxableItem car = new Vehicle(20000, 2500, .10);
        System.out.println(car);

        ((Vehicle)car).changeMarkup(1000);

        System.out.println(car);
    }
}

/*
Output:
Cost: 20000.0
Markup: 2500.0
List price: 22500.0
Purchase Price: 24750.0
Cost: 20000.0
Markup: 1000.0
List price: 21000.0
Purchase Price: 23100.0
 */
