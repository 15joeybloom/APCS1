/**
 * @author Joey Bloom
 * Assignment #39
 * Just like Employee except a Manager has a department
 */
public class Manager extends Employee
{
    public String department;
    /**
     * makes a Manager with name salary department
     * @param name
     * @param salary
     * @param department
     */
    public Manager(String name,double salary,String department)
    {
        super(name,salary);
        this.department = department;
    }
    /**
     * gets the department
     * @return department
     */
    public String getDepartment()
    {
        return department;
    }
    /**
     * Returns a String representation of the Manager
     * @return String
     */
    @Override
    public String toString()
    {
        return super.toString() +
                "    and oversees the " + getDepartment() + " department\n";
    }
}