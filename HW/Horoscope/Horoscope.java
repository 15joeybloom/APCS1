
/**
 * @author Joey Bloom
 * Assignment #21
 * Provides a horoscope reading for any birthday
 */
public class Horoscope
{
    private int month;
    private int day;
    
    /**
     * Constructs a Horoscope with the given month and day
     * 
     * @param m the month
     * @param d the day
     */
    public Horoscope(int m, int d) throws Exception
    {
        if (m < 1 || d <1)
            throw new Exception();
        else
        {
            month = m;
            day = d;
        }
    }
    /**
     * Returns a String containing a horoscope for the 
     * given birthday.
     * 
     * @return a horoscope
     */
    public String getHoroscope()
    {
        if (( month == 3 && 21 <= day && day <= 31 ) || 
            ( month == 4 && day <= 19 ))
        {
            return "Aries " +
                "will have significantly more patience" +
                "\nfor the n00bsauce today. You might" +
                "\neven offer your assistance to one.";
        }
        else if (( month == 4 && 20 <= day && day <= 30 ) || 
                 ( month == 5 && day <= 20 ))
        {
            return "Taurus " +
                "will be frustrated today. The compiler" +
                "\nwill be super annoying for whatever" +
                "\nstupid compiler-reason and you won't" +
                "\nknow why. Fear not, Taurus. Your friend" +
                "\nthe debugger will help you in your" +
                "\ntime of need.";
        }
        else if (( month == 5 && 21 <= day && day <= 31 ) || 
                 ( month == 6 && day <= 20 ))
        {
            return "Gemini " +
                "will need help today. You will have an" +
                "\nunforeseen moment of complete" +
                "\nn00bsauceyness. Seek out Aries for" +
                "\nassitance.";
        }
        else if (( month == 6 && 21 <= day && day <= 30 ) || 
                 ( month == 7 && day <= 22 ))
        {
            return "Cancer " +
                "will have a hard week in the near future." +
                "\nYou will feel tempted to isolate yourself" +
                "\nin your room with your computer and" +
                "\nprogram for hours on end. Advice: don't" +
                "\nforget to eat. It's more important than" +
                "\nyou think it is.";
        }
        else if (( month == 7 && 23 <= day && day <= 31 ) || 
                 ( month == 8 && day <= 22 ))
        {
            return "Leo " +
                "will want to punch your monitor very soon." +
                "\nChoose a wiser course of action, i.e." +
                "\nlooking up the constructor for" +
                "\nRectangle instead of guessing and" +
                "\nwasting time and angering yourself.";
        }
        else if (( month == 8 && 23 <= day && day <= 31 ) || 
                 ( month == 9 && day <= 22 ))
        {
            return "Virgo " +
                "should put some extra effort in your" +
                "\nprogramming today. Take the time to" +
                "\nwrite that do-while loop; don't just" +
                "\nmain(args) it.";
        }
        else if (( month == 9 && 23 <= day && day <= 30 ) || 
                 ( month == 10 && day <= 22 ))
        {
            return "Libra " +
                "wishes the compiler would just shut up." +
                "\nMind your {}. They might not add up" +
                "\nas you think they do.";
        }
        else if (( month == 10 && 23 <= day && day <= 31 ) || 
                 ( month == 11 && day <= 21 ))
        {
            return "Scorpio " +
                "is in a good position to learn today." +
                "\nYour leisure time is bountiful; get" +
                "\noff Minecraft and start teaching" +
                "\nyourself C++.";
        }
        else if (( month == 11 && 22 <= day && day <= 30 ) || 
                 ( month == 12 && day <= 21 ))
        {
            return "Sagittarius " +
                "will encounter algorithmic trouble today." +
                "\nYou cannot think of how to solve your" +
                "\nproblem using the tools in your arsenal." +
                "\nIt is time to visit the API.";
        }
        else if (( month == 12 && 22 <= day && day <= 31 ) || 
                 ( month == 1 && day <= 19 ))
        {
            return "Capricorn " +
                "will have the bestest day ever." +
                "\nYou won't be a n00b, you'll pwn" +
                "\nGregorianCalendar in the face, and you" +
                "\nare the cooliest because I said so.";
        }
        else if (( month == 1 && 20 <= day && day <= 31 ) || 
                 ( month == 2 && day <= 18 ))
        {
            return "Aquarius " +
                "will write a program that does an" +
                "\nincredibly stupid, pointless task. It" +
                "\nwill take you most of your day. A day" +
                "\nwell spent.";
        }
        else if (( month == 2 && 19 <= day && day <= 29 ) || 
                 ( month == 3 && day <= 20 ))
        {
            return "Pisces " +
                "will try to show off today. You'll write" +
                "\nsome fancy GUI to complete a really," +
                "\nreally, really, mundane task. Your " +
                "\ntime is better spent elsewhere.";
        }
        else
        {
            return 
            "You are too magical for my computing abilities";
        }
    }
}