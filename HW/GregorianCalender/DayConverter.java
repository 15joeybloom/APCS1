
/**
 * Joey Bloom
 * Assignment #7
 * This class provides one static method
 * that, when provided with an int representing
 * a day of the week, returns a String containing
 * that day.
 */
public class DayConverter
{
    public static String toDay(int dayNumber)
    {
        String[] daysOfTheWeek =
            { "Sunday", "Monday", "Tuesday",
              "Wednesday", "Thursday", "Friday",
              "Saturday", "Funday!!" };
        
        return daysOfTheWeek[dayNumber - 1];
    }
}
