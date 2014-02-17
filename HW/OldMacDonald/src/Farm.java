/**
 * @author Joey Bloom
 * Assignment #38
 * A Farm holds Animals and can print their sounds
 */
public class Farm
{
    private Animal[] a;

    /**
     * makes a farm with 3 animals: a cow named Elsie that goes moo,
     * a Chick that goes cluck and cheep, and a pig that goes
     * oink.
     */
    public Farm()
    {
        a = new Animal[3];
        a[0] = new NamedCow("cow","Elsie","moo");
        a[1] = new Chick("chick","cluck","cheep");
        a[2] = new Pig("pig","oink");
    }
    /**
     * prints the animals' sounds to the terminal window
     */
    public void animalSounds()
    {
        for(Animal silliness : a)
        {
            System.out.println(silliness.getType() +
                               " goes " +
                               silliness.getSound());
        }
        System.out.println("The cow is known as " +
                          ((NamedCow)a[0]).getName());
    }
}