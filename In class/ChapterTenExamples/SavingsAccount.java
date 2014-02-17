
/**
 * @author Joey Bloom
 * Assignment #37
 * A child class of Account.. this
 * extends the Account class
 */
public class SavingsAccount extends Account
{
    private double rate;
    
    public SavingsAccount(String o, double b, double r)
    {
        super(o,b);
    }
    public void collectInterest()
    {
        double interest = getBalance() * .01 * rate;
        deposit(interest);
    }
}
