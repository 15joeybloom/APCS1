
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
/**
 * @author Joey Bloom
 * Assignment #39
 * Tests the Employee, Manager, and Executive classes
 */
public class EmployeeManagerExecutive
{
    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(
            null, 
            "Hello!",
            "Welcome",
            INFORMATION_MESSAGE);
        ArrayList<Employee> database = new ArrayList<Employee>();
        while(true)
        {
            Object[] options = {
                "Employee",
                "Manager",
                "Executive",
                "Quit and Print"};
            int selection = showOptionDialog(
                null,
                "Select Employee type: ",
                "Type",
                DEFAULT_OPTION,
                QUESTION_MESSAGE,
                null,
                options,
                options[0]);

            if(selection == 3 || selection == -1) break;

            String name = showInputDialog(
                null,
                "Enter " + options[selection] + "'s name: ",
                "Name",
                QUESTION_MESSAGE);
            double salary;
            while(true)
            {
                try
                {
                    salary = Double.parseDouble(showInputDialog(
                        null,
                        "Enter " + options[selection] + 
                            " " + name + "'s salary: ",
                        "Salary",
                        QUESTION_MESSAGE));
                }
                catch(NumberFormatException e)
                {
                    showMessageDialog(
                        null,
                        "NaN",
                        "NaN",
                        ERROR_MESSAGE);
                    continue;
                }
                break;
            }
            String department = "";
            if(selection != 0)
            {
                department = showInputDialog(
                    null,
                    "Enter " + options[selection] + 
                        " " + name + "'s department: ",
                    "Department",
                    QUESTION_MESSAGE);
            }
            else
            {
                database.add(new Employee(name,salary));
                continue;
            }

            if(selection == 1) database.add(
                    new Manager(name,salary,department));
            else if(selection == 2) database.add(
                    new Executive(name,salary,department));
            else System.err.println("uh-oh");
        }
        String printout = "";
        for(Employee hiMrSvetlik : database)
        {
            printout += hiMrSvetlik;
        }
        if(printout.equals("")) printout = "Is empty!";
        showMessageDialog(null,"Your Company:\n" + printout,
                "Your Company",INFORMATION_MESSAGE);
    }
}
