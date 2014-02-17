package phonebook;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Joey Bloom
 * Assignment #15
 * A PhoneBook holds Contact objects
 */
public class PhoneBook
{
    private ArrayList<Contact> contacts;
    private boolean sorted;

    /**
     * Constructs an empty phonebook
     */
    public PhoneBook()
    {
        this(new ArrayList<Contact>());
    }

    /**
     * Constructs a phonebook with the given list of contacts
     * @param c contacts
     */
    public PhoneBook(ArrayList<Contact> c)
    {
        contacts = c;
        sorted = false;
    }

    /**
     * Constructs a phonebook with the given contacts
     * @param c contacts
     */
    public PhoneBook(Contact... c)
    {
        this();
        contacts.addAll(Arrays.asList(c));
    }

    /**
     * Adds a Contact to this phonebook
     * @param c Contact to add
     */
    public void add(Contact c)
    {
        sorted = false;
        contacts.add(c);
    }

    /**
     * Finds a person in the phonebook by name
     * @param name name to search for
     * @return the Contact with the target name. null if not found.
     */
    public Contact searchByName(String name)
    {
        if(!sorted)
        {
            Collections.sort(contacts);
        }
        int i = Searching.binarySearch(contacts, new Contact(name,""));
        return i == -1 ? null : contacts.get(i);
    }

    /**
     * Finds a person in the phonebook by phonenumber in linear time.
     * @param number number to search for
     * @return the Contact with the target number. null if not found.
     */
    public Contact searchByNumber(String number)
    {
        for(Contact c : contacts)
        {
            if(c.getNumber().equals(number))
            {
                return c;
            }
        }
        return null;
    }
}