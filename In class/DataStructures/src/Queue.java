
import java.util.ArrayList;

/**
 * @author 151bloomj
 * 3/18/13 Perv's lesson
 */
public class Queue
{
    private ArrayList<Customer> queue;

    public Queue()
    {
        queue = new ArrayList<Customer>();
    }

    public void enqueue(Customer i)
    {
        queue.add(i);
    }

    public Customer dequeue()
    {
        return queue.remove(0);
    }
}
