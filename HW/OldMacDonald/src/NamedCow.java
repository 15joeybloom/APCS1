/**
 * @author Joey Bloom
 * Assignment #38
 * A NamedCow has a type and makes a sound
 * and also has a name
 */
public class NamedCow extends Cow
{
    private String myName;
    /**
     * makes a Cow with type and sound and name
     * @param type type
     * @param name name
     * @param sound sound
     */
    public NamedCow(String type,String name,String sound)
    {
        super(type,sound);
        myName = name;
    }
    /**
     * gets the name
     * @return name
     */
    public String getName() { return myName; }
}
