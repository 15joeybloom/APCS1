package person;

/**
 * @author Joey Bloom
 * Assignment #15
 * A Contact has a name and a phone number. sorted by name.
 */
public class Person implements Comparable<Person>
{
    private String name;
    private String number;

    /**
     * Constructs a Contact with name and phone number
     * @param nam name
     * @param num phone number
     */
    public Person(String nam, String num)
    {
        name = nam;
        number = num;
    }

    /**
     * returns the name
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * returns the phone number
     * @return the phone number
     */
    public String getNumber()
    {
        return number;
    }

    /**
     * Compares Contacts lexicographically by name according to the agreement specified in
     * Comparable.compareTo(Object)
     * @param o
     * @return
     */
    @Override
    public int compareTo(Person o)
    {
        return name.compareTo(o.getName());
    }

    /**
     * Returns a String containing the Contact's name and number
     * @return string
     */
    @Override
    public String toString()
    {
        return name + "\n" + number;
    }
}
