/**
 * @author Joey Bloom
 * Assignment #39
 * Tests the Employee, Manager, and Executive classes
 */
public class Employee
{
    private String name;
    private double salary;

    /**
     * makes an Employee with name salary
     * @param name
     * @param salary
     */
    public Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }
    /**
     * returns the name
     * @return name
     */
    public String getName() { return name; }
    /**
     * returns the salary
     * @return salary
     */
    public double getSalary() { return salary; }
    /**
     * returns a String representing this Employee
     * @return String
     */
    @Override
    public String toString()
    {
        return getClass().getName() + " " + 
            getName() + " makes $" + getSalary() + "\n";
    }
}
