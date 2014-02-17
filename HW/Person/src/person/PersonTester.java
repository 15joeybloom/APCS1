package person;

import java.util.ArrayList;
import java.util.Scanner;
import sorting.Sorting;

/**
 * @author 151bloomj
 */
public class PersonTester
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        String name;
        while(true)
        {
            System.out.println("Enter a name or q to quit");
            name = in.nextLine();
            if(name.equals("q"))
            {
                break;
            }
            else
            {
                people.add(new Person(name,""));
            }
        }
        if(people.isEmpty())
        {
            System.out.println("Empty List");
            System.exit(0);
        }
        Sorting.quickSort(people);
        System.out.println("First: " + people.get(0));
        System.out.println("Last: " + people.get(people.size() -1));
    }
}
/*
Output 1:
Enter a name or q to quit
Bloom
Enter a name or q to quit
Svet
Enter a name or q to quit
Gordon
Enter a name or q to quit
Falouji
Enter a name or q to quit
Bond
Enter a name or q to quit
Wex
Enter a name or q to quit
q
First: Bloom

Last: Wex

Output 2:
Enter a name or q to quit
Bloom
Enter a name or q to quit
q
First: Bloom

Last: Bloom

Output 3:
Enter a name or q to quit
q
Empty List
 */
