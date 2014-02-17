/**
 * @author Joey Bloom
 * Assignment #38
 * An Animal has a type and makes a sound
 */
public class Cow implements Animal
{
    private String myType;
    private String mySound;

    /**
     * makes a Cow with type and sound
     * @param type type
     * @param sound sound
     */
    public Cow(String type, String sound)
    {
        myType = type;
        mySound = sound;
    }
    /**
     * gets the sound
     * @return sound
     */
    @Override
    public String getSound() { return mySound; }
    /**
     * gets the type
     * @return type
     */
    @Override
    public String getType() { return myType; }
}
