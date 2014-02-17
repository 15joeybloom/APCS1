import java.util.Random;
/**
 * @author Joey Bloom
 * Assignment #38
 * A Chick has a type and makes a sound
 */
public class Chick implements Animal
{
    private String myType;
    private String mySound1;
    private String mySound2;

    /**
     * makes a Chick with type and sound
     * @param type type
     * @param sound sound
     */
    public Chick(String type, String sound)
    {
        this(type,sound,sound);
    }

    /**
     * makes a Chick with type and 2 sound
     * @param type type
     * @param sound1 sound1
     * @param sound2 sound2
     */
    public Chick(String type, String sound1, String sound2)
    {
        myType = type;
        mySound1 = sound1;
        mySound2 = sound2;
    }
    /**
     * gets the sound
     * @return sound
     */
    @Override
    public String getSound()
    {
        Random gen = new Random();
        if(gen.nextBoolean())
        {
            return mySound1;
        }
        else
        {
            return mySound2;
        }
    }
    /**
     * gets the type
     * @return type
     */
    @Override
    public String getType() { return myType; }
}