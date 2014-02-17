/**
 * @author Joey Bloom
 * Assignment #36
 * Tests the DataSet with Comparable objects
 */
public class ComparableTester
{
    public static void main(String[] args)
    {
        Circle[] c = new Circle[5];
        for(int i = 0; i < 5; i++)
        {
            //fun way of getting different numbers!!
            c[i] = new Circle((((5*(i+1))%7)*17)%9);
            System.out.print(c[i].getRadius() + " ");
        }
        System.out.println();
        DataSet cirSet = new DataSet();
        for(Circle foo : c)
        {
            cirSet.add(foo);
        }
        System.out.println("Largest Circle: ");
        System.out.println(cirSet.getMaximum());
        System.out.println("Smallest Circle: ");
        System.out.println(cirSet.getMinimum());
        System.out.println();
        
        Coin[] coins = new Coin[5];
        String[] coinNames = {"Quarter","Rupee","MyCoin","AlsoMyCoin","Euro"};
        for(int i = 0; i < 5; i++)
        {
            //fun way of getting different numbers!!
            coins[i] = new Coin(coinNames[i],(((37*(i+1))%27)*18)%47);
            System.out.print(coins[i].getValue() + " ");
        }
        System.out.println();
        DataSet coinSet = new DataSet();
        for(Coin foo : coins)
        {
            coinSet.add(foo);
        }
        System.out.println("Largest Coin: ");
        System.out.println(coinSet.getMaximum());
        System.out.println("Smallest Coin: ");
        System.out.println(coinSet.getMinimum());
        System.out.println();
        
        String[] s = {"A","B","C","EA","EB"};
        DataSet sSet = new DataSet();
        for(String foo : s)
        {
            sSet.add(foo);
            System.out.print(foo + " ");
        }
        System.out.println();
        System.out.println("Largest String: ");
        System.out.println(sSet.getMaximum());
        System.out.println("Smallest String: ");
        System.out.println(sSet.getMinimum());
        System.out.println();
    }
}
/*
Output:
4.0 6.0 8.0 3.0 5.0 
Largest Circle: 
The radius of your Circle: 8.0
The area of your Circle: 201.06192982974676
The circumference of your Circle: 50.26548245743669
Smallest Circle: 
The radius of your Circle: 3.0
The area of your Circle: 28.274333882308138
The circumference of your Circle: 18.84955592153876

39.0 31.0 7.0 46.0 38.0 
Largest Coin: 
AlsoMyCoin is worth $46.0
Smallest Coin: 
MyCoin is worth $7.0

A B C EA EB 
Largest String: 
EB
Smallest String: 
A


 */