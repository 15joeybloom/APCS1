
/*
 * Joey Bloom
 * Assignment #10
 * Tests the Employee class.
 */
public class EmployeeTester
{
    public static void main(String[] args)
    {
        Employee defaultEmployee = new Employee();
        Employee joeyBloom = new Employee( 
            "OVER NINE THOUSANDDDDDDDD", 9000.01);
        
        defaultEmployee.raiseSalary(20);
        System.out.println(defaultEmployee);
        System.out.println("Expected: $12000");
        
        defaultEmployee.raiseSalary(100);
        System.out.println(defaultEmployee);
        System.out.println("Expected: $24000");
        
        System.out.println(joeyBloom);
        System.out.println("Expected: $9000.01");
    }
}

/*
Output:

The salary for Deere, John is $12000.0
Expected: $12000
The salary for Deere, John is $24000.0
Expected: $24000
The salary for OVER NINE THOUSANDDDDDDDD is $9000.01
Expected: $9000.01


*/