
/**
 * @author Joey Bloom
 * Assignment #17
 * Tests the DataSet method
 */
public class DataSetTester
{
    public static void main(String[] args)
    {
        DataSet boom = new DataSet();
        boom.addValue(17);
        boom.addValue(1717);
        boom.addValue(-1717);
        boom.addValue(-17);
        
        System.out.println(boom);
        System.out.println("Expected: ");
        System.out.println("Largest: 1717" +
                           "\nSmallest: -1717");
    }
}

/*
Output:
Largest: 1717
Smallest: -1717
Expected: 
Largest: 1717
Smallest: -1717
 */
