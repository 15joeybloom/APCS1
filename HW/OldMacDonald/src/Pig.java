/**
 * @author Joey Bloom
 * Assignment #38
 * A Pig has a type and makes a sound
 */
public class Pig implements Animal
{
    private String myType;
    private String mySound;
    /**
     * makes a Pig with type and sound
     * @param type type
     * @param sound sound
     */
    public Pig(String type, String sound)
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