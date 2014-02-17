package q3;

/**
 * @author Joey Bloom
 * 2012 Free Response Question 3
 */
public class Tester
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Horse[] horses = new Horse[7];
        horses[0] = new Horsey("Trigger",1340);
        horses[2] = new Horsey("Silver",1210);
        horses[5] = new Horsey("Patches",1350);
        horses[6] = new Horsey("Duke",1410);

        HorseBarn barn = new HorseBarn(horses);
        System.out.println(barn);
        System.out.println("Triger is at: " + barn.findHorseSpace("Triger"));
        System.out.println("Trigger is at: " + barn.findHorseSpace("Trigger"));
        System.out.println("Silver is at: " + barn.findHorseSpace("Silver"));

        barn.consolidate();
        System.out.println("Consolidated: ");
        System.out.println(barn);
    }

    private static class Horsey implements Horse
    {
        private String name;
        private int weight;

        public Horsey(String n, int w)
        {
            name = n;
            weight = w;
        }

        @Override
        public String getName()
        {
            return name;
        }

        @Override
        public int getWeight()
        {
            return weight;
        }

        @Override
        public String toString()
        {
            return getName() + " " + getWeight();
        }
    }
}

/*
Output:
[Trigger 1340, null, Silver 1210, null, null, Patches 1350, Duke 1410]
Triger is at: -1
Trigger is at: 0
Silver is at: 2
Consolidated:
[Trigger 1340, Silver 1210, Patches 1350, Duke 1410, null, null, null]
 */
