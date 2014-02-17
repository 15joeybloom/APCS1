/**
 * @author Joey Bloom
 * In-class Example for Chapter 10
 * This class will be the base (a.k.a. "parent class" and "Superclass"
 * for multiple types of Accounts, ecah of which
 * will be defined as SUBCLASSES
 * of this one
 */
public class Account implements Comparable
{
    private String owner; //the owner of the account
    private double balance; //the current balance of the account
    
    public Account(String o, double b)
    {
        owner = o;
        balance = b;
    }
    public void deposit(double amount)
    {
        if(amount > 0)
        {
            balance += amount;
        }
    }
    public void withdraw(double amount)
    {
        if(amount > 0 && amount <= balance)
        {
            balance -= amount;
        }
    }
    public double getBalance()
    {
        return balance;
    }
    public String getOwner()
    {
        return owner;
    }
    public int compareTo(Object o)
    {
        Account a = (Account) o;
        return (int) Math.rint(getBalance() - a.getBalance());
    }
    public String toString()
    {
        return "Owner: ";
    }
}
