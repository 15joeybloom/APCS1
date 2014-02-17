package phonebook;

import java.io.*;

/**
 * @author Joey Bloom
 * Assignment #15
 * Tests the PhoneBook class
 */
public class PhoneBookTester
{
    public static void main(String[] args) throws IOException, FileNotFoundException
    {
        PhoneBook pB = new PhoneBook();
        try(BufferedReader in = new BufferedReader(new FileReader(new File("directory.txt"))))
        {
            String name = in.readLine();
            while(name != null)
            {
                pB.add(new Contact(name,in.readLine()));
                name = in.readLine();
            }
        }
        System.out.println("DeFazio, Peter A. :\n" + pB.searchByName("DeFazio, Peter A."));
        System.out.println("Kirk, Mark Steven :\n" + pB.searchByName("Kirk, Mark Steven"));
        System.out.println("Boom, Joey Congressman\n: " + pB.searchByName("Boom, Joey Congressman"));
        System.out.println("225-2735:\n" + pB.searchByNumber("225-2735"));
        System.out.println("225-2727:\n" + pB.searchByNumber("225-2727"));
        System.out.println("225-3615:\n" + pB.searchByNumber("225-3615"));
    }
}
/*
Output:
DeFazio, Peter A. :
DeFazio, Peter A.
225-6416
Kirk, Mark Steven :
Kirk, Mark Steven
225-4835
Boom, Joey Congressman
: null
225-2735:
Langevin, James R.
225-2735
225-2727:
null
225-3615:
Slaughter, Louise McIntosh
225-3615
 */
