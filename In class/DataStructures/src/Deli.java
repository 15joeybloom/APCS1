/**
 * @author 151bloomj
 * in class example of how to use queues
 */
public class Deli
{
    private Queue line;

    public Deli()
    {
        line = new Queue();
    }

    public void numberTaken(Customer c)
    {
        line.enqueue(c);
    }

    public String nextOrder()
    {
        return line.dequeue().toString();
    }

    public static void main(String[] args)
    {
        Deli henrys = new Deli();
        Customer zack = new Customer("Zack", "Corned Beef");
        henrys.numberTaken(zack);
        System.out.println(henrys.nextOrder());
        Customer andy = new Customer("Andy", "37 dozen bagels");
        Customer jacob = new Customer("Jacob", "escargots");
        henrys.numberTaken(jacob);
        henrys.numberTaken(andy);
        Customer amy = new Customer("Amy", "Lox");
        henrys.numberTaken(amy);
        System.out.println(henrys.nextOrder());
        System.out.println(henrys.nextOrder());
        System.out.println(henrys.nextOrder());

    }
}
