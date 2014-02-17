
/*
 * Joey Bloom
 * Assignment #10
 * An employee has a name and a salary, with a
 * method provided for giving the employee a
 * raise.
 */

public class Employee
{
    String name;
    double salary;
    
    public Employee()
    {
        name = "Deere, John";
        salary = 10000;
    }
    
    public Employee( String employeeName, 
                     double currentSalary )
    {
        name = employeeName;
        salary = currentSalary;
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getSalary()
    {
        return salary;
    }
    
    public void raiseSalary(double byPercent)
    {
        salary = salary + ( salary * ( byPercent / 100.0 ) );
    }
    
    public String toString()
    {
        return "The salary for " + getName() + " is $" + getSalary();
    }

}